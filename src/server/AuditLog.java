package server;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A logging class, which keeps track of users
 */
public class AuditLog {
    PrintStream out;

    /**
     * Creates a text file for logging
     */
    public AuditLog() {
        try {
            FileOutputStream auditfile = new FileOutputStream("auditlog.txt", true);
            out = new PrintStream(auditfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs that a user has connected to the database
     * @param userId
     */
    public void printConnected(String userId) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + "is connected to database");
        out.flush();
    }

    /**
     * Logs that a user has disconnected from the database
     * @param userId
     */
    public void printDisconnected(String userId) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + "disconnected from database");
        out.flush();
    }

    /**
     * Logs that an action has been made by the user
     * @param userId
     * @param actionType
     */
    public void printAction(String userId, String actionType) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(Calendar.getInstance().getTime());

        out.println(timeStamp + " " + userId + " " + actionType);
        out.flush();
    }

}
