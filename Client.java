import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
    public static void main(String args[]) throws IOException {
        Scanner sc=new Scanner(System.in);
        Socket socket=new Socket("localhost",9090);
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        System.out.println("Enter a Mesaage for server ");
        String line=sc.nextLine();
        if (!line.trim().equalsIgnoreCase("Quit")) {
        while (!line.trim().equalsIgnoreCase("Quit")) {
            out.println(line);
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader in=new BufferedReader(isr);
            String respose=in.readLine();
            System.out.println("Server Response: "+respose);
            System.out.println("Enter a Mesaage for server ");
            line=sc.nextLine();    
        }    
       }else{
         out.println("I Don't want to make Communication Sorry!");
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader in=new BufferedReader(isr);
            String respose=in.readLine();
            System.out.println("Server Response: "+respose);
            
       }
        out.println(line);
        InputStream is=socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader in=new BufferedReader(isr);
        String respose=in.readLine();
        System.out.println(respose);
        System.out.println("Client's Sockets Are Closed");
        socket.close();
    }
}
