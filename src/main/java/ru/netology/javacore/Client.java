package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int port = 8989;

    public static void main(String[] args) throws IOException {

        while (true) {
            try (Socket socket = new Socket(HOST, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String json = in.readLine();
                System.out.println(json); //  ???

                Scanner scanner = new Scanner(System.in);
                System.out.println("введите type :");
                String type = scanner.nextLine();

                System.out.println("введите task :");
                String task = scanner.nextLine();

                Gson gson = new Gson();
                Map<String, String> map = new HashMap<>();
                map.put("type", type);
                map.put("task", task);

                json = gson.toJson(map);
                out.println(json);

                String otvet = in.readLine();
                System.out.println(otvet);
                otvet = in.readLine();
                System.out.println(otvet);

            }
        }

    }
}
