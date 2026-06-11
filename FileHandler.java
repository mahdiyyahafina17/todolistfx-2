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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class AddPersonalTaskPage {

    public void show(Stage primaryStage,String username) {

        Label title =new Label("ADD PERSONAL TASK");

        Label lblTaskTitle =new Label("Task Title");

        TextField txtTitle =new TextField();
        txtTitle.setMaxWidth(200); //tmbh

        Label lblTimeSlot = new Label("Time Slot");

        ComboBox<String> cbTimeSlot = new ComboBox<>();

        cbTimeSlot.getItems().addAll("Morning","Afternoon","Evening","Night"
        );

        Label lblStatus =new Label("Status");
        ComboBox<String> cbStatus =
               new ComboBox<>();

        cbStatus.getItems().addAll(
                "Pending","Completed"
        );

        Button btnSave =new Button("Save");
        btnSave.setOnAction(e -> {

    String taskTitle = txtTitle.getText();

    String timeSlot = cbTimeSlot.getValue();

    String status = cbStatus.getValue();

    FileHandler fileHandler = new FileHandler();

    TaskHandler taskHandler = new TaskHandler();

    taskHandler.getTasks().addAll(
            fileHandler.loadTasks());

    int taskID = taskHandler.getTasks().size() + 1;

    PersonalTask task =
            new PersonalTask(taskID,username,taskTitle,status,timeSlot);

    taskHandler.addTask(task);

    fileHandler.saveTasks(
            taskHandler.getTasks());
    Alert alert =
        new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText("Task Added Successfully");

alert.showAndWait();
PersonalTaskPage page =
        new PersonalTaskPage();

page.show(
        primaryStage,
        username);
            System.out.println( "Personal Task Updated");
        });
        Button btnBack =
                new Button("Back");
        VBox root =
                new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,

                lblTaskTitle,
                txtTitle,

                lblTimeSlot,
                cbTimeSlot,

                lblStatus,
                cbStatus,

                btnSave,
                btnBack
        );

        Scene scene =
                new Scene(root,400,500);

        primaryStage.setScene(scene);
        btnBack.setOnAction(e -> {

            PersonalTaskPage page =
                    new PersonalTaskPage();

            page.show(
                    primaryStage,
                    username);

        });

    }
}