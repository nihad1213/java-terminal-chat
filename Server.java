import java.io.*;
import java.net.*;
import java.util.*;

public class Server implements Runnable {

    private final List<PrintWriter> clients = new ArrayList<>();

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(9999)) {
            System.out.println("Server started on port 9999...");
            while (true) {
                Socket socket = server.accept();
                new Thread(new ConnectionHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message) {
        for (PrintWriter client : clients)
            client.println(message);
    }

    class ConnectionHandler implements Runnable {

        private final Socket socket;

        ConnectionHandler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out  = new PrintWriter(socket.getOutputStream(), true);
                clients.add(out);

                String message;
                while ((message = in.readLine()) != null)
                    broadcast(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}