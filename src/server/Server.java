package server;
import common.MedicalRecord;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.*;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;


public class Server implements Runnable {
    private ServerSocket serverSocket = null;
    private static int numConnectedClients = 0;
    private Database database;
    private AuditLog auditLog;





    public Server(ServerSocket ss) throws IOException {
        //Start auditLog
        auditLog = new AuditLog();
        serverSocket = ss;

        newListener();
    }

    public void run() {
        try {
            database = new Database();
            database.add("Patrick", new MedicalRecord("Doctor", "n1", 1, "A+", "Patrick"));
            SSLSocket socket=(SSLSocket)serverSocket.accept();
            newListener();
            SSLSession session = socket.getSession();
            X509Certificate cert = (X509Certificate)session.getPeerCertificateChain()[0];
            String subject = cert.getSubjectDN().getName();
            String userId = subject.substring(3,6);
            Character clearance = subject.charAt(3);
            numConnectedClients++;

            auditLog.printConnected(userId);
            System.out.println("client connected");

            System.out.println("client name (cert subject DN field): " + subject);

            //For testing purposes
            if (clearance == 'n'){
                System.out.println("You are a nurse");
            } else if (clearance == 'g'){
                System.out.println("You are a government employee");
            } else if (clearance == 'd'){
                System.out.println("You are a doctor");
            } else if (clearance == 'p'){
                System.out.println("You are a patient");
            } else {
                System.out.println("I do not recognize you");
            }

            System.out.println("Clearance level is: " + clearance);
            System.out.println(numConnectedClients + " concurrent connection(s)\n");

            PrintWriter out = null;
            BufferedReader in = null;
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMsg = null;
            while ((clientMsg = in.readLine()) != null) {
                String[] parts = clientMsg.split(" ");
                String returnMsg;
                if(parts[0].compareTo("read") == 0){
                    MedicalRecord mr = database.patientRecords(parts[1]).get(Integer.parseInt(parts[2]));
                    returnMsg = checkReadPermission(subject, Character.getNumericValue(subject.charAt(5)), mr);

                } else if (parts[0].compareTo("write") == 0){
                    returnMsg = "You want to write";
                } else if (parts[0].compareTo("delete") == 0){
                    returnMsg = "You want to delete";
                } else if (parts[0].compareTo("create") == 0){
                    returnMsg = "You want to create";
                } else {
                    returnMsg = "That command is not recognized";
                }

                System.out.println("received '" + clientMsg + "' from client");
                System.out.print("sending '" + returnMsg + "' to client...");
                out.println(returnMsg);
                out.flush();
                System.out.println("done\n");
            }
            in.close();
            out.close();
            socket.close();
            numConnectedClients--;
            System.out.println("client disconnected");
            auditLog.printDisconnected(userId);
            System.out.println(numConnectedClients + " concurrent connection(s)\n");
        } catch (IOException e) {
            System.out.println("client died: " + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

    private void newListener() {
        (new Thread(this)).start();
    } // calls run()

    public static void main(String args[]) {
        System.out.println("\nserver Started\n");
        int port = -1;
        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }
        String type = "TLS";

        try {
            ServerSocketFactory ssf = getServerSocketFactory(type);
            ServerSocket ss = ssf.createServerSocket(port);
            ((SSLServerSocket)ss).setNeedClientAuth(true); // enables client authentication
            new Server(ss);
        } catch (IOException e) {
            System.out.println("Unable to start server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static ServerSocketFactory getServerSocketFactory(String type) {
        if (type.equals("TLS")) {
            SSLServerSocketFactory ssf = null;
            try { // set up key manager to perform server authentication
                SSLContext ctx = SSLContext.getInstance("TLS");
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
                TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
                KeyStore ks = KeyStore.getInstance("JKS");
                KeyStore ts = KeyStore.getInstance("JKS");
                char[] password = "password".toCharArray();

                ks.load(new FileInputStream("serverkeystore"), password);  // keystore password (storepass)
                ts.load(new FileInputStream("servertruststore"), password); // truststore password (storepass)
                kmf.init(ks, password); // certificate password (keypass)
                tmf.init(ts);  // possible to use keystore as truststore here
                ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
                ssf = ctx.getServerSocketFactory();
                return ssf;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return ServerSocketFactory.getDefault();
        }
        return null;
    }

    //Patient får läsa egna, nurse får läsa egna samt division, doctor får läsa samma som nurse, gov får läsa allt

    private String checkReadPermission(String id, int division, MedicalRecord mr){
        if (division == mr.getDivision() || id.equals(mr.getPatient()) || id.equals("g")){
            return mr.toString();
        } else {
            return "You do not have clearance";
        }
    }

}
