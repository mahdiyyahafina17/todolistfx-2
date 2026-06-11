/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */
import java.util.ArrayList;

public class TaskHandler {

    private ArrayList<Task> tasks;

    public TaskHandler() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void deleteTask(int taskID) {

        Task taskToDelete = null;

        for (Task task : tasks) {

            if (task.getTaskID() == taskID) {

                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete != null) {

            tasks.remove(taskToDelete);

            System.out.println( "Task deleted successfully.");
        }
    }

    public void editTask(int taskID,String title,String status) {

        for (Task task : tasks) {

            if (task.getTaskID() == taskID) {

                task.setTitle(title);
                task.setStatus(status);
            }
        }
    }
}