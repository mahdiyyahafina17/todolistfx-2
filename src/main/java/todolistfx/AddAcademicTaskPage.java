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

public class AddAcademicTaskPage {

    public void show(Stage primaryStage,String username) {

        Label title =new Label("ADD ACADEMIC TASK");

        Label lblTaskTitle =new Label("Task Title");

        TextField txtTitle =new TextField();
         txtTitle.setMaxWidth(200); //tmbh
         
Label lblDueDate = new Label("Due Date");

 
TextField txtDueDate =
        new TextField();
txtDueDate.setMaxWidth(200); //tmbh

        Label lblStatus =new Label("Status");

        ComboBox<String> cbStatus =
               new ComboBox<>();

        cbStatus.getItems().addAll("Pending","Completed"
        );

        Button btnSave =new Button("Save");
        btnSave.setOnAction(e -> {

    String taskTitle = txtTitle.getText();

   String dueDate = txtDueDate.getText();

    String status = cbStatus.getValue();

    FileHandler fileHandler = new FileHandler();

    TaskHandler taskHandler = new TaskHandler();

    taskHandler.getTasks().addAll(
            fileHandler.loadTasks());

    int taskID = taskHandler.getTasks().size() + 1;

    AcademicTask task =
            new AcademicTask( taskID,username,taskTitle,status,dueDate);

    taskHandler.addTask(task);

    fileHandler.saveTasks(
            taskHandler.getTasks());
Alert alert =
        new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText("Task Added Successfully");
alert.showAndWait();
AcademicTaskPage page =
        new AcademicTaskPage();

page.show(
        primaryStage,
        username);
            System.out.println( "Academic Task Updated");
        });

/*alert.showAndWait();
AcademicTaskPage page =
        new AcademicTaskPage();

    System.out.println("Academic Task Saved");

});*/
        Button btnBack = new Button("Back");

        VBox root =new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,

                lblTaskTitle,
                txtTitle,

                lblDueDate,
                txtDueDate,

                lblStatus,
                cbStatus,

                btnSave,
                btnBack
        );

        Scene scene = new Scene(root,400,500);

        primaryStage.setScene(scene);

        btnBack.setOnAction(e -> {

            AcademicTaskPage page =new AcademicTaskPage();

            page.show(primaryStage, username);

        });
    }
}

   
