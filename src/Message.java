/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suzy
 */
public class Message {
    /**
       Construct a Message object.
       @param messageText the message text
    */
    public Message(String messageText)
    {
       text = messageText;
    }
 
    /**
       Get the message text.
       @return message text
    */
    public String getText()
    {
       return text;
    }
 
    private String text;    
}
