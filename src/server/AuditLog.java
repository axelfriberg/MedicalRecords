package server;

import java.io.PrintWriter;

/**
 * Created by johanmansson on 15-02-18.
 */
public class AuditLog {

    private PrintWriter writer = new PrintWriter("auditlog.tex", "UTF-8");

    public void writeToLog(String str) {

        writer.println(str);
        //to do


    }









}
