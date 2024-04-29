import javax.imageio.IIOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer
{
    public static void main(String[]args)
    {
        int port=5000;//sunucu port numarası
        try(ServerSocket sc=new ServerSocket(port)) {
            System.out.println("Sunucu port\t" + port +"\t üzerinde dinleniyor");

            //Bağlantı beklemek için serverSocket.accept() kullandık
            Socket clientSocket=sc.accept();
            System.out.println("istemci baglandı");

            //istemciye mesaj göndermek için
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true);
            out.println("Merhaba istemci");


            clientSocket.close();
        }
        catch (IOException e)
        {
            System.err.println("Sunucu hatası"+ e.getMessage());
            e.printStackTrace();// hatayı konsolo yazdır
        }
    }
}
