import java.net.*;
import java.io.*;
public class ContentServer
{
    public static void main(String args[])throws Exception
    {
        ServerSocket sersock=new ServerSocket(4001);
        System.out.println("Server ready for connection");

        Socket sock=sersock.accept();
        System.out.println("Connection is successful and waiting for filename ");

        DataInputStream din=new DataInputStream(sock.getInputStream());
        String fname=din.readUTF();

        BufferedReader contentRead=new BufferedReader(new FileReader(fname));
        DataOutputStream dout=new DataOutputStream(sock.getOutputStream());
        String str;
        while((str=contentRead.readLine())!=null)
        {
            dout.writeUTF(str);
        }
        dout.writeUTF("NULL");
        sock.close();
        sersock.close();
        din.close();
        dout.close();
        contentRead.close();
    }
}
