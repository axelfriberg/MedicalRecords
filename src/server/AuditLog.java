package server;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by johanmansson on 15-02-18.
 */
public class AuditLog {
    PrintStream out;

    public AuditLog(){
        try {
            FileOutputStream auditfile = new FileOutputStream("auditlog.tex", true);
            out = new PrintStream(auditfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printConnected(String userId) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + "is connected to database");
        out.flush();
    }

    public void printDisconnected(String userId) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + "disconnected from database");
        out.flush();
    }
    public void printAction(String userId, String actionType) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + actionType);
        out.flush();
    }











}
