
import core.Connection;
import core.Telephone;

import domain.*;
import ui_views.*;

import javax.swing.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by abraa on 23/05/2016.
 */
public class TelephoneForm implements Telephone {

    private final MainForm form;
    private Auth auth;
    private Messager messager;
    private String output;

    public TelephoneForm(MainForm console) {
        form = console;

        configLookAndFeel(form);
    }

    @Override
    public void speak(String mailOutput) {
        output = parseOutput(mailOutput);
    }

    private String parseOutput(String str) {
        return str
            .replace(Connection.INITIAL_PROMPT, "")
            .replace(Connection.MAILBOX_MENU_TEXT, "")
            .replace(Connection.MESSAGE_MENU_TEXT, "");
    }

    @Override
    public void run(Connection connection) {
        this.auth = new Auth(connection);
        this.messager = new Messager(connection);

        this.startListnerEvents();

        form.setVisible(true);
    }

    private void startListnerEvents(){

        LoginForm login = this.form.getLoginForm();
        SenderForm senderForm = this.form.getSenderForm();
        MailboxForm managerMessages = this.form.getManagerMessages();
        ChangeGreetingDialog changeGreeting =  this.form.getChangeGreetingDialog();

        managerMessages.onRequestCurrentMessage(() ->
            this.messager.requestCurrentMessage(() -> output)
        );

        senderForm.onMessage((String mailboxNumber, String message) ->
            this.messager.Send(mailboxNumber, message)
        );

        login.onLogin((String ramal, String password) -> {
            this.auth.Login(ramal, password);
            managerMessages.showMessages();
            managerMessages.setVisible(true);
        });

        managerMessages.onArchiveMessage(() ->
            this.messager.archiveCurrentMessage()
        );

        managerMessages.onDeleteMessage(() ->
            this.messager.deleteCurrentMessage()
        );

        managerMessages.onLogout(() ->
            this.auth.Logout()
        );

        managerMessages.onOpenChangePass(() ->{
            login.changePass();
            login.setVisible(true);
        });

        managerMessages.onOpenChangeGreeting(() ->
            changeGreeting.setVisible(true)
        );

        managerMessages.onRequestCurrentGreeting(() ->
            this.auth.requestCurrentGreeting(() -> output)
        );

        changeGreeting.onChange((String newGreeting) ->{
            this.auth.changeGreating(newGreeting);
            managerMessages.showMessages();
        });

        login.onChangePass((String newPass) ->
            this.auth.changePass(newPass)
        );
    }

    private void configLookAndFeel(MainForm form){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (
                ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException  ex) {

            Logger.getLogger(this.form.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
