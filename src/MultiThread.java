/**
 * created by Federico Di Maio
 *
 * client server implementation with random number generation
 */


public class MultiThread {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();
        server.start();
        client.start();
    }
}
