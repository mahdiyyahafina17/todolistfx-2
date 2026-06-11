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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class AcademicTaskPage {
 
    public void show(Stage primaryStage, String username) {
        

        Label title =new Label("ACADEMIC TASKS");
        title.setStyle(
        "-fx-font-size: 24px; " //40px-24px
      + "-fx-font-weight: bold;");
        

TableView<AcademicTask> table =
        new TableView<>();

TableColumn<AcademicTask, Integer> idColumn =
        new TableColumn<>("ID");

idColumn.setCellValueFactory(
        new PropertyValueFactory<>("taskID"));

TableColumn<AcademicTask, String> titleColumn =
        new TableColumn<>("Title");

titleColumn.setCellValueFactory(
        new PropertyValueFactory<>("title"));

TableColumn<AcademicTask, String> timeColumn =
        new TableColumn<>("Due Date");

timeColumn.setCellValueFactory(
        new PropertyValueFactory<>("dueDate"));

TableColumn<AcademicTask, String> statusColumn =
        new TableColumn<>("Status");

statusColumn.setCellValueFactory(
        new PropertyValueFactory<>("status"));

table.getColumns().addAll(
        idColumn, titleColumn, timeColumn, statusColumn);

table.setColumnResizePolicy(
        TableView.CONSTRAINED_RESIZE_POLICY);

FileHandler fileHandler = new FileHandler();

ObservableList<AcademicTask> academicTasks =
        FXCollections.observableArrayList();

for (Task task :  fileHandler.loadTasks()) {
    if (task instanceof AcademicTask && task.getUsername() .equals(username)) {

        academicTasks.add(
                (AcademicTask) task);
    }}
table.setItems(academicTasks);
        Button btnAdd =new Button("+ Add");
        btnAdd.setStyle("-fx-background-color: lightgreen;"); //tmbh
        
      btnAdd.setOnAction(e -> {

    AddAcademicTaskPage addPage =new AddAcademicTaskPage();

    addPage.show(primaryStage,username);

});  
Button btnEdit =new Button("✏ Edit");
   btnEdit.setStyle("-fx-background-color: lightblue;"); //tmbh

btnEdit.setOnAction(e -> {

    AcademicTask selectedTask =
            table.getSelectionModel()
                 .getSelectedItem();

    if (selectedTask != null) {

        EditAcademicTaskPage page =
                new EditAcademicTaskPage();

        page.show(
                primaryStage,
                username,
                selectedTask);
    }
});
        Button btnDelete =new Button("🗑 Delete");
btnDelete.setStyle("-fx-background-color: lightcoral;"); //tmbh

btnDelete.setOnAction(e -> {

    AcademicTask selectedTask =
            table.getSelectionModel().getSelectedItem();

    if (selectedTask != null) {

        ArrayList<Task> allTasks =
                fileHandler.loadTasks();

        allTasks.removeIf(t ->
                t.getTaskID() == selectedTask.getTaskID()
                && t.getUsername().equals(username)
        );

        fileHandler.saveTasks(allTasks);

        academicTasks.remove(selectedTask);

     Alert alert =
        new Alert( Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText("Task Deleted Successfully");

alert.showAndWait();
    }
});

        Button btnBack =new Button("← Back");
        btnBack.setStyle("-fx-background-color: lightgray;"); //css
        
        btnAdd.setPrefWidth(120); //css
        btnEdit.setPrefWidth(120); //css
        btnDelete.setPrefWidth(120); //css
        btnBack.setPrefWidth(120); //css

        
        VBox root = new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title, table, btnAdd, btnEdit, btnDelete, btnBack
        );

        Scene scene =new Scene(root,600,350);// 400-600, 400-350

        primaryStage.setScene(scene);

        btnBack.setOnAction(e -> {

            TaskHandlerPage taskPage = new TaskHandlerPage();

            taskPage.show(
                    primaryStage, username);
        });
    }

}