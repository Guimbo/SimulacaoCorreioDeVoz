package domain;

import core.Connection;

import java.util.concurrent.Callable;

/**
 * Created by abraa on 23/05/2016.
 */
public class Auth {
    private Connection connection;
    private String mailBoxNumber;
    private String passMailbox;

    public Auth(Connection connection){
        this.connection = connection;
    }

    public void Login(String mailBoxNumber, String pass){
        this.mailBoxNumber = mailBoxNumber;
        this.passMailbox = pass;

        for (int i = 0; i < mailBoxNumber.length(); i++){
            char c = mailBoxNumber.charAt(i);
            this.connection.dial("" + c);
        }
        this.connection.dial("#");

        for (int i = 0; i < pass.length(); i++){
            char c = pass.charAt(i);
            this.connection.dial("" + c);
        }
        this.connection.dial("#");
    }

    public void Logout(){
        this.mailBoxNumber= "";
        this.passMailbox = "";
        this.connection.hangup();
    }

    public void changePass(String newPass) {
        this.connection.dial("2");
        for (int i = 0; i < newPass.length(); i++){
            char c = newPass.charAt(i);
            this.connection.dial("" + c);
        }
        this.connection.dial("#");
    }

    public void changeGreating(String newGreeting) {
        this.connection.dial("3");
        this.connection.record(newGreeting);
        this.connection.dial("#");
    }

    public String requestCurrentGreeting(Callable<String> getCurrentgreeting) {
        String myMailbox = this.mailBoxNumber;
        String myPass = this.passMailbox;

        this.Logout();

        for (int i = 0; i < myMailbox.length(); i++){
            char c = myMailbox.charAt(i);
            this.connection.dial("" + c);
        }
        this.connection.dial("#");

        String result = "";

        try {
            result = getCurrentgreeting.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Logout();
        this.Login(myMailbox, myPass);

        return result;
    }
}
