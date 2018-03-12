import java.io.BufferedReader;
import java.io.IOException;

public class Reader implements Runnable {

    private Client client;
    private final BufferedReader in;

    Reader(Client client, BufferedReader in) {
        this.client = client;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String clientMessage;
            while (true) {
                clientMessage = in.readLine();

                if (clientMessage != null) {

                    String clientName = clientMessage.split("#")[0];
                    String message = clientMessage.split("#")[1];
                    MessageFormatter formatter = new MessageFormatter(message, clientName);
                    String formatedMessage = formatter.getMessage();

                    System.out.println(formatedMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}