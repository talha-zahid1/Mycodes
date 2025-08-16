import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args)throws Exception {
       ServerSocket serverSocket=new ServerSocket(9090);
       System.out.println("Server is Waiting for  Client ");
       Socket Clientsocket=serverSocket.accept();
       System.out.println("Client is Conected ");
       PrintWriter out=new PrintWriter(Clientsocket.getOutputStream(),true);
       InputStream is=Clientsocket.getInputStream();
       InputStreamReader isr=new InputStreamReader(is);
       BufferedReader in=new BufferedReader(isr);
       String message=in.readLine();
       if (!message.trim().equalsIgnoreCase("Quit")) {
           while (!message.trim().equalsIgnoreCase("Quit")) {
               System.out.println("Client Says: "+message);
               out.println("Your Message is Recieved ");
               message=in.readLine();
            }
       }
        out.println("Communication Ended Successfully");
        System.out.println("Server's Sockets are closed");
        serverSocket.close();
        Clientsocket.close();
       
    }
}