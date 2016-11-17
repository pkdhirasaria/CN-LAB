
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ContentClient
{

      public static void main(String args[])throws Exception
    {
        Socket sock=new Socket("192.168.195.42",4001);


        System.out.println("enter the filename");
        Scanner keyRead = new Scanner(System.in);

        String fname=keyRead.next();
        DataOutputStream dout=new DataOutputStream(sock.getOutputStream());

        dout.writeUTF(fname);

        DataInputStream din=new DataInputStream(sock.getInputStream());

        String str;
       int count=0;
        while(!(str=din.readUTF()).equals("NULL"))
        {
          count++;
            System.out.println("Line "+count+"."+str);

        }

       sock.close();
       dout.close();
       din.close();
        keyRead.close();
     }
}
