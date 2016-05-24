package domain;

import core.Connection;

import java.util.StringJoiner;
import java.util.concurrent.Callable;

/**
 * Created by abraa on 23/05/2016.
 */
public class Messager {
    private Connection connection;

    public Messager(Connection connection) {

        this.connection = connection;
    }

    public void Send(String mailboxNumber, String Message){
        for (int i = 0; i < mailboxNumber.length(); i++){
            char c = mailboxNumber.charAt(i);
            this.connection.dial("" + c);
        }

        this.connection.dial("#");
        this.connection.record(Message);
        this.connection.hangup();
    }

    public String requestCurrentMessage(Callable<String> getCurrentMessage) {
        this.connection.dial("1");
        this.connection.dial("1");
        String result = "";
        try {
            result = getCurrentMessage.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.connection.dial("4");
        return result;
    }

    public void archiveCurrentMessage() {
        this.connection.dial("1");
        this.connection.dial("2");
        this.connection.dial("4");
    }

    public void deleteCurrentMessage() {
        this.connection.dial("1");
        this.connection.dial("3");
        this.connection.dial("4");
    }

}
