import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient
{
    public static void main(String[] args)
    {
        String host="localhost";
        int port=5000;
        try (Socket socket=new Socket(host,port)){
            //serverdan gelen mesajları okuma
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message=in.readLine();
            System.out.println("sunucadan gelen mesaj:"+message);


        }
        catch (UnknownHostException e)
        {
            System.err.println("Sunucu bulunamadı:"+e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("I/O hatası:"+ e.getMessage());
        }
    }
}
