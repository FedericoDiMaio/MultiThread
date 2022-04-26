import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("server in attesa di connessione...");

            Socket socket_server = serverSocket.accept();

            // random number creation
            int numero = 100;
            int numeroRandomico = (int) (Math.random() * numero);

            // receive
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket_server.getInputStream()));
            // send
            PrintWriter printWriter = new PrintWriter(socket_server.getOutputStream());

            printWriter.println("Benvenuto sei collegato con il server " + socket_server.getLocalAddress().toString().substring(1)
                    + " sulla porta " + socket_server.getLocalPort());

            printWriter.flush();
            String riga = bufferedReader.readLine();

            if (riga.equalsIgnoreCase("genera numero")) {
                printWriter.println("il numero generato è " + numeroRandomico);
                printWriter.flush();
            }

            bufferedReader.close();
            printWriter.close();
            serverSocket.close();

        } catch (IOException a) {
            System.out.println(a.getMessage());
        }
        System.out.println("sessione chiusa...programma terminato");

    }
}




