package ru.netology.javacore;

import java.util.*;

public class Todos {
    private Deque<String> stack = new ArrayDeque<>();
    private ArrayList<String> task = new ArrayList<>();

    public Deque<String> getStack() {
        return stack;
    }

    public ArrayList<String> getTask() {
        return task;
    }

    public void addTask(String task) {
        if (this.task.size() < 7) {
            this.task.add(task);
            this.stack.offer("ADD " + task);
        }
    }

    public void removeTask(String task) {
        this.task.remove(task);
        this.stack.offer("REMOVE " + task);
    }

    public void restoreTask() {
        String restore = stack.pollLast();
        String[] rest = restore.split(" ");
        String task = rest[1];
        String type = rest[0];
        if (type.equals("ADD")) {
            this.task.remove(task);
        } else if (type.equals("REMOVE")) {
            this.task.add(task);
        }
    }

    public String getAllTasks() {
        String strings1 = "";
        String[] strings = task.toArray(new String[0]);
        Arrays.sort(strings);
        for (String s : strings) {
            strings1 = strings1 + " " + s;
        }
        return strings1;
    }
}
