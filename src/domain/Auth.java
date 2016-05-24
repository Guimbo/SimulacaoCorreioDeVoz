package domain;

import core.Connection;

/**
 * Created by abraa on 23/05/2016.
 */
public class Auth {
    private Connection connection;

    public Auth(Connection connection){
        this.connection = connection;
    }

    public void Login(String mailBoxNumber, String pass){
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
}
