import java.io.*;
import java.net.Socket;

public class Client {

    public static Integer PORT = 8080;

    public static void main(String[] args) {
        String host = "localhost";

        try (Socket socket = new Socket(host, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {


            out.println("Шведов Дмитрий");
            System.out.println("Отправлено: Шведов Дмитрий");


            String response = in.readLine();
            System.out.println("Сервер мне ответил: " + response);

        } catch (IOException e) {
            System.err.println("Ошибка подключения к серверу!");
            e.printStackTrace();
        }
    }
}