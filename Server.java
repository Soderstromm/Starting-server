import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Integer PORT = 8080;


    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер стартовал");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("New connection accepted "
                            + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                    String name = in.readLine();
                    System.out.println("Получено имя: " + name);

                    out.println(String.format("Hi, %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        }
    }
}
