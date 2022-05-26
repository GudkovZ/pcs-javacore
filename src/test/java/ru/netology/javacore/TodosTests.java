package ru.netology.javacore;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodosTests {

    @BeforeAll
    public static void initSuite() {
        System.out.println("TodosTests running for methods of class \"Todos\"");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("All 'TodosTests' completed");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test completed");
    }

    @Test
    @DisplayName("Test \"addTask()\" method")
    public void addTaskTest(TestInfo addTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("Let doing something");
        boolean actual = todo.getAllTasks().contains("Let doing something");

        Assertions.assertTrue(actual, addTaskTestInfo.getDisplayName() + "NO complete");
        System.out.println(addTaskTestInfo.getDisplayName() + " completed");
    }

    @Test
    @DisplayName("Test \"removeTask()\" method")
    public void removeTaskTest(TestInfo removeTaskTestInfo) {

        Todos todo = new Todos();
        todo.addTask("Doing something!");
        todo.removeTask("Doing something!");
        boolean actual = todo.getAllTasks().contains("Doing something!");

        Assertions.assertFalse(actual, removeTaskTestInfo.getDisplayName() + " NO complete");
        System.out.println(removeTaskTestInfo.getDisplayName() + " completed");
    }


    @Test
    @DisplayName("Test \"getAllTask()\" method")
    public void getAllTasksTest(TestInfo getAllTasksTestInfo) {

        Todos todo = new Todos();
        String expected = "1st task" +
                " " +
                "2nd task" +
                " " +
                "3rd task" +
                " ";

        todo.addTask("1st task");
        todo.addTask("2nd task");
        todo.addTask("3rd task");

        Assertions.assertEquals(expected, todo.getAllTasks(), getAllTasksTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksTestInfo.getDisplayName() + " completed");
    }

    @Test
    @DisplayName("Test \"getAllTasksAsList()\" method")
    public void getAllTasksAsListTest(TestInfo getAllTasksAsListTestInfo) {
        Todos todo = new Todos();
        todo.addTask("1st task");
        todo.addTask("2nd task");
        todo.addTask("3rd task");

        List<String> expected = new ArrayList<>(Arrays.asList("1st task", "2nd task", "3rd task"));
        List<String> actual = todo.getAllTasksAsList();

        Assertions.assertEquals(expected, actual, getAllTasksAsListTestInfo.getDisplayName() + " NO complete!");
        System.out.println(getAllTasksAsListTestInfo.getDisplayName() + " completed");
    }
}
