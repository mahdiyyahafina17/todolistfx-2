/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.ArrayList;

public class FileHandler { //save users

    public void saveUsers(ArrayList<User> users) {

        try {
             System.out.println( new java.io.File("users.txt").getAbsolutePath());
 BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));

            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
            writer.close();
            System.out.println("Users saved successfully");

        } catch (IOException e) {
            System.out.println("Error saving users!");
        }
    }
   public ArrayList<User> loadUsers() {

    ArrayList<User> users = new ArrayList<>();
    File file = new File("users.txt");

    try {
        if (!file.exists()) {
            file.createNewFile();
            return users;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length < 2) continue;

            users.add(new User(data[0], data[1]));
        }

        reader.close();

    } catch (IOException e) {
        System.out.println("Oops error loading users");
    }

    return users;
}


// Tasks
public void saveTasks(ArrayList<Task> tasks) { 

    try {

        BufferedWriter writer =
                new BufferedWriter(
                    new FileWriter("tasks.txt"));
        for (Task task : tasks) {
            if (task instanceof PersonalTask) {
                PersonalTask p =
                        (PersonalTask) task;

                writer.write(p.getTaskID() + ","+p.getUsername() + ","+ p.getTitle() + ","+ p.getStatus() + ","+ p.getType() + ","+ p.getTimeSlot());
                writer.newLine();
            }

            else if (task instanceof AcademicTask) {

                AcademicTask a =(AcademicTask) task;
                writer.write(a.getTaskID() + ","+a.getUsername() + ","+ a.getTitle() + ","+ a.getStatus() + ","+ a.getType() + ","+ a.getDueDate());
                writer.newLine();
            }
        }

        writer.close();
        System.out.println("Yeay tasks saved successfully.");

    }

    catch (IOException e) {

        System.out.println("Oops error saving tasks.");
    }
}
//loadtask
public ArrayList<Task> loadTasks() {

    ArrayList<Task> tasks = new ArrayList<>();
    File file = new File("tasks.txt");

    System.out.println(file.getAbsolutePath());

    try {
        if (!file.exists()) {
            file.createNewFile();
            return tasks;
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length < 5) continue;

            int taskID = Integer.parseInt(data[0]);
            String username = data[1];
            String title = data[2];
            String status = data[3];
            String type = data[4];

            if (type.equals("Personal") && data.length >= 6) {
                tasks.add(new PersonalTask(taskID, username, title, status, data[5]));
            }

            else if (type.equals("Academic") && data.length >= 6) {
                tasks.add(new AcademicTask(taskID, username, title, status, data[5]));
            }
        }

        reader.close();

    } catch (IOException e) {
        System.out.println("Oops error loading tasks");
    }

    return tasks;
}
}