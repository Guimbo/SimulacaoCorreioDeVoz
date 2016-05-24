
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suzy
 */
public class Telephone {
    
    private Scanner scanner; 
    
    /**
       Construtor Objeto Fone.
       Parâmetro aScanner que lê o texto dos caracteres inseridos.
     * @param aScanner
    */
    public Telephone(Scanner aScanner)
    {
       scanner = aScanner;
    }
 
    /**
       Diga uma mensagem para o System.out.
       Parâmetro mostra a saída do texto que será "falado".
     * @param output
    */
    public void speak(String output)
    {
       System.out.println(output);
    }
 
    /**
       Repete a leitura da entrada do usuário e passa para o 
       Objeto Connection os métodos dial, record ou hangup.
       Parâmetro c é a conexão que conecta esse fone ao sistema do correio de voz.
    */
    public void run(Connection c)
    {
       boolean more = true;
       while (more)
       {
          String input = scanner.nextLine();
          if (input == null) return;
          if (input.equalsIgnoreCase("H"))
             c.hangup();
          else if (input.equalsIgnoreCase("Q"))
             more = false;
          else if (input.length() == 1
             && "1234567890#".indexOf(input) >= 0)
             c.dial(input);
          else
             c.record(input);
       }
    }   
}
