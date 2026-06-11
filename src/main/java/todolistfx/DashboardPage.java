/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistfx;

/**
 *
 * @author user
 */


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardPage {

    public void show(Stage primaryStage, String username) {

        Label title =new Label("USER DASHBOARD");
        title.setStyle(
        "-fx-font-size: 24px; "//tukar 20-24px
      + "-fx-font-weight: bold;");

        Label welcome =new Label(" ✨ Welcome!, " + username);
        welcome.setStyle("-fx-font-size: 18px;" 
                + "-fx-font-weight: bold;");
        

FileHandler fileHandler = 
        new FileHandler();

java.util.ArrayList<Task> tasks =
        fileHandler.loadTasks();


int total = 0; 
int completed = 0;
int pending = 0;


for (Task task : tasks) {
 System.out.println(
        "USERNAME IN FILE = " + task.getUsername()
        + " | LOGIN USER = " + username
    );

    if (task.getUsername().equals(username)) {
        System.out.println("MATCH FOUND");
    }

    if (task.getUsername()
            .equals(username)) {

        total++;

        if (task.getStatus()
                .equalsIgnoreCase(
                        "Completed")) {
            completed++;
        }

        else {
            pending++;
        }
    }}


Label totalTasks =
        new Label( "Total Tasks : "+ total);

Label completedTasks =
        new Label( "Completed Tasks : "+ completed);

Label pendingTasks =
        new Label("Pending Tasks : "+ pending);
totalTasks.setStyle("-fx-font-size: 14px;");
completedTasks.setStyle("-fx-font-size: 14px;");
pendingTasks.setStyle("-fx-font-size: 14px;");

        Button btnManageTasks =new Button("📋 Manage Tasks");
        btnManageTasks.setPrefWidth(150);
        btnManageTasks.setStyle( //css
    "-fx-background-radius: 10;"
    + "-fx-font-weight: bold;");
        
        btnManageTasks.setOnAction(e -> {

    TaskHandlerPage taskPage =new TaskHandlerPage();

    taskPage.show(primaryStage,username);
});

        Button btnLogout =new Button(" 🚪 Logout");
 btnLogout.setPrefWidth(150);  
 btnLogout.setStyle(  //css
    "-fx-background-radius: 10;"
    + "-fx-font-weight: bold;");
 
        VBox root =new VBox(15);

        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20;");

        root.getChildren().addAll(
                title,welcome,totalTasks,completedTasks,pendingTasks,btnManageTasks,btnLogout
        );

        Scene scene =new Scene(root, 450, 350);
        primaryStage.setTitle("Dashboard");
        primaryStage.setScene(scene);

        btnLogout.setOnAction(e -> {

            TodolistfX loginPage =new TodolistfX();

            try {
                loginPage.start(primaryStage);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }}