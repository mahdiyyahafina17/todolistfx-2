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

public class EditPersonalTaskPage {

    public void show(Stage primaryStage,
                     String username,
                     PersonalTask selectedTask) {
Label title =
                new Label("EDIT PERSONAL TASK");

        Label lblTaskTitle =
                new Label("Task Title");

        TextField txtTitle =
                new TextField();

        txtTitle.setText(
                selectedTask.getTitle());

        Label lblTimeSlot =
                new Label("Time Slot");

        ComboBox<String> cbTimeSlot =
                new ComboBox<>();

        cbTimeSlot.getItems().addAll(
                "Morning",
                "Afternoon",
                "Evening",
                "Night"
        );

        cbTimeSlot.setValue(
                selectedTask.getTimeSlot());

        Label lblStatus =
                new Label("Status");

        ComboBox<String> cbStatus =
                new ComboBox<>();

        cbStatus.getItems().addAll(
                "Pending",
                "Completed"
        );


        cbStatus.setValue(
                selectedTask.getStatus());
Button btnUpdate =
                new Button("Update");
btnUpdate.setOnAction(e -> {
            selectedTask.setTitle(
                    txtTitle.getText());

            selectedTask.setTimeSlot(
                    cbTimeSlot.getValue());

            selectedTask.setStatus(
                    cbStatus.getValue());


FileHandler fileHandler =
        new FileHandler();

java.util.ArrayList<Task> allTasks =
        fileHandler.loadTasks();

// find matching task and update it

for (Task task : allTasks) {

    if (task.getTaskID() ==
            selectedTask.getTaskID()) {
        task.setTitle(
                txtTitle.getText());

        task.setStatus(
                cbStatus.getValue());

        if (task instanceof PersonalTask) {

            ((PersonalTask) task)
                    .setTimeSlot(
                            cbTimeSlot.getValue());
        }
    }
}

fileHandler.saveTasks(allTasks);
Alert alert =
        new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText("Personal Task Updated");

alert.showAndWait();
// Return to Personal Task Page

PersonalTaskPage page =
        new PersonalTaskPage();

page.show(
        primaryStage,
        username);
            System.out.println( "Task Updated");
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

                btnUpdate,
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