package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;


public class TodoServer {

    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = new Todos();
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        //...
        try (ServerSocket serverSocket = new ServerSocket(8989);) { // стартуем сервер один(!) раз
            String json;
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    System.out.println("New connection accepted  " + socket.getPort());
                    out.println("???");

                    json = in.readLine();
                    out.println("OK");
                    Gson gson = new Gson();
                    Map<String, String> map = gson.fromJson(json, Map.class);
                    String type = map.get("type");
                    String task = map.get("task");
                    switch (type) {
                        case "ADD":
                            todos.addTask(task);
                            break;
                        case "REMOVE":
                            todos.removeTask(task);
                            break;
                        case "RESTORE":
                            todos.restoreTask();
                            break;
                    }

                    String otvet = todos.getAllTasks();
                    out.println(otvet);
                }
            }
        }
    }
}
