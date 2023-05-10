package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    Todos todos = new Todos();

    @Test
    void test_addTask() {
        String[] actual = {"бегать", "учиться"};
        todos.addTask("бегать");
        todos.addTask("учиться");
        String[] expected = todos.getTask().toArray(new String[0]);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_removeTask() {
        String[] actual = {"учиться"};
        todos.addTask("бегать");
        todos.addTask("учиться");
        todos.removeTask("бегать");
        String[] expected = todos.getTask().toArray(new String[0]);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_restoreTask() {
        String[] actual = {"учиться", "бегать"};
        todos.addTask("бегать");
        todos.addTask("учиться");
        todos.removeTask("бегать");
        todos.restoreTask();
        String[] expected = todos.getTask().toArray(new String[0]);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_getAllTasks() {
        String actual = " бегать учиться";
        todos.addTask("бегать");
        todos.addTask("учиться");
        todos.removeTask("бегать");
        todos.restoreTask();
        String expected = todos.getAllTasks();

        Assertions.assertEquals(expected, actual);
    }
}