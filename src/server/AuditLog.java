package server;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by johanmansson on 15-02-18.
 */
public class AuditLog {
    PrintWriter writer;

    public AuditLog(){
        try {
            writer = new PrintWriter("auditlog.tex", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



    public void printConnected(String userType) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm").format(Calendar.getInstance().getTime());

        writer.println(timeStamp + " " + userType + " " + "is connected to database");


    }

    public void closeLog() {
        writer.close();
    }









}
