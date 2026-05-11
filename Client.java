import java.io.*;
import java.net.*;

public class Client implements Runnable {

    private final String name;

    Client(String name) { this.name = name; }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 9999)) {
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out    = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null)
                        System.out.println(msg);
                } catch (IOException e) { e.printStackTrace(); }
            }).start();

            String line;
            while ((line = kbd.readLine()) != null)
                out.println(name + ": " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}