import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {

    private final int PORT = 9999;
    private final List<ConnectionHandler> connections = new ArrayList<>();
    private ServerSocket serverSocket;
    private boolean running = false;


    @Override
    public void run() {
        System.out.println("Server is running...");
    }

    class ConnectionHandler implements Runnable {
        
        @Override
        public void run() {
            System.out.println("Handling a new connection...");
        }
    }
    
}
