//client side

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ContentClient
{

  	  public static void main(String args[])throws Exception
    {
        Socket sock=new Socket("127.0.0.1",4001);
        
        //
        System.out.println("enter the filename");
        Scanner keyRead = new Scanner(System.in);
       // BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
        
        String fname=keyRead.next();
        
        /*
        OutputStream Ostream=sock.getOutputStream();
        //
        
        
        PrintWriter pwrite=new PrintWriter(Ostream, true);
        
        pwrite.println(fname);
        */
        
        DataOutputStream dout=new DataOutputStream(sock.getOutputStream());
        
        dout.writeUTF(fname);
        
        /*InputStream istream=sock.getInputStream();

        BufferedReader SocketRead=new BufferedReader(new InputStreamReader(istream));*/
        
        DataInputStream din=new DataInputStream(sock.getInputStream());
        
        String str;
       int count=0;
        while(!(str=din.readUTF()).equals("NULL"))
        { 
        	count++;
            System.out.println("Line "+count+"."+str);
            
        }
       /* while((str=SocketRead.readLine())!=null)
        {
            System.out.println(str);
            
        }*/
       // pwrite.close();
       sock.close();
       dout.close();
       din.close();
        //SocketRead.close();
        keyRead.close();
     }
}

