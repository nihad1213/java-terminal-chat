public class Main {
    public static void main(String[] args) throws Exception {
        if (args[0].equals("server"))
            new Thread(new Server()).start();
        else
            new Thread(new Client(args[1])).start();
    }
}