package domain;

import core.Connection;

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

    public void requestCurrentMessage() {
        this.connection.dial("1");
        this.connection.dial("1");
        //TODO: get current message here
        this.connection.dial("4");
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
