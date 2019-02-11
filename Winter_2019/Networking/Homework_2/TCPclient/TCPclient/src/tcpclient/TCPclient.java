/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

/**
 *
 * @author mahmood
 */
import java.io.*;
import java.net.*;
public class TCPclient {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)throws Exception
    {
        // TODO code application logic here
        

String sentence;
String modifiedSentence;
BufferedReader inFromUser =
new BufferedReader(new InputStreamReader(System.in));
        try (Socket clientSocket = new Socket("localhost", 6789)) {
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());
            
            BufferedReader inFromServer =
                    new BufferedReader(new
        InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
        }   
}
}