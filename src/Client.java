import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {

    @Override
    public void run() {
        try {
            //try to connect
            Socket socketClient = new Socket(InetAddress.getLocalHost(), 4444);

            //Stream input creation to receive information from servers
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            //creation of output streams to send data to clients
            PrintWriter printWriter = new PrintWriter(socketClient.getOutputStream());

            String riga = bufferedReader.readLine();
            System.out.println("MESSAGGIO : " + riga);

            printWriter.println("genera numero");
            printWriter.flush();
            riga = bufferedReader.readLine();
            System.out.println("\n" + riga);

            bufferedReader.close();
            printWriter.close();
            socketClient.close();

        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
    }
}