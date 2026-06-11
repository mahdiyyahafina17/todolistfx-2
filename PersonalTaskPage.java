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

public class EditAcademicTaskPage {

    public void show(Stage primaryStage,
                     String username,
                     AcademicTask selectedTask) {

        Label title =new Label("EDIT ACADEMIC TASK");

        Label lblTaskTitle =new Label("Task Title");

        TextField txtTitle =
                new TextField();

        txtTitle.setText(
                selectedTask.getTitle());

        Label lblDueDate =
                new Label("Due Date");

        TextField txtDueDate =
                new TextField();

        txtDueDate.setText(
                selectedTask.getDueDate());

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

        Button btnBack =
                new Button("Back");

        btnUpdate.setOnAction(e -> {

            selectedTask.setTitle(
                    txtTitle.getText());

            selectedTask.setDueDate(
                    txtDueDate.getText());

            selectedTask.setStatus(
                    cbStatus.getValue());

            FileHandler fileHandler =
                    new FileHandler();

            java.util.ArrayList<Task> allTasks =
                    fileHandler.loadTasks();

            // Find matching task and update it

            for (Task task : allTasks) {

                if (task.getTaskID() ==
                        selectedTask.getTaskID()) {

                    task.setTitle(
                            txtTitle.getText());

                    task.setStatus(
                            cbStatus.getValue());

                    if (task instanceof AcademicTask) {

                        ((AcademicTask) task)
                                .setDueDate(
                                        txtDueDate.getText());
                    }
                }
            }
            fileHandler.saveTasks(
                    allTasks);
            Alert alert =
        new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText("Academic Task Updated");

alert.showAndWait();

            AcademicTaskPage page =
                    new AcademicTaskPage();

            page.show(
                    primaryStage,
                    username);
        });

        btnBack.setOnAction(e -> {

            AcademicTaskPage page =
                    new AcademicTaskPage();

            page.show(
                    primaryStage,
                    username);
        });

        VBox root =
                new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,

                lblTaskTitle,
                txtTitle,

                lblDueDate,
                txtDueDate,

                lblStatus,
                cbStatus,

                btnUpdate,
                btnBack
        );

        Scene scene =
                new Scene(root,400,500);

        primaryStage.setScene(scene);
    }
}