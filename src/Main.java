import core.Connection;
import core.MailSystem;
import core.Telephone;
import ui_views.MainForm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        MailSystem system = new MailSystem(MAILBOX_COUNT);
        Scanner console = new Scanner(System.in);
        MainForm form = new MainForm();

        Telephone telephone = new TelephoneTerminal(console);
        //Telephone telephone = new TelephoneForm(form);
        Connection connection = new Connection(system, telephone);

        telephone.run(connection);
    }

    private static final int MAILBOX_COUNT = 20;


}
