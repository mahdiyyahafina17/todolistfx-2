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

public class PersonalTaskPage {
 

    public void show(Stage primaryStage, String username) {
        

        Label title =new Label("PERSONAL TASKS");
                title.setStyle(
        "-fx-font-size: 24px; " //40px-24px
      + "-fx-font-weight: bold;");

TableView<PersonalTask> table =
        new TableView<>();

TableColumn<PersonalTask, Integer> idColumn =
        new TableColumn<>("ID");

idColumn.setCellValueFactory(
        new PropertyValueFactory<>("taskID"));

TableColumn<PersonalTask, String> titleColumn =
        new TableColumn<>("Title");

titleColumn.setCellValueFactory(
        new PropertyValueFactory<>("title"));

TableColumn<PersonalTask, String> timeColumn =
        new TableColumn<>("Time Slot");

timeColumn.setCellValueFactory(
        new PropertyValueFactory<>("timeSlot"));

TableColumn<PersonalTask, String> statusColumn =
        new TableColumn<>("Status");

statusColumn.setCellValueFactory(
        new PropertyValueFactory<>("status"));

table.getColumns().addAll(
        idColumn, titleColumn, timeColumn, statusColumn);

table.setColumnResizePolicy( //css
        TableView.CONSTRAINED_RESIZE_POLICY); //css

FileHandler fileHandler = new FileHandler();

ObservableList<PersonalTask> personalTasks =
        FXCollections.observableArrayList();

for (Task task :  fileHandler.loadTasks()) {
    if (task instanceof PersonalTask && task.getUsername().equals(username) ) {
        personalTasks.add(
                (PersonalTask) task);
    }}
System.out.println("Total Personal Tasks: " + personalTasks.size());

for (PersonalTask p : personalTasks) {
    System.out.println(
        p.getTaskID() + " | " +
        p.getTitle() + " | " +
        p.getStatus() + " | " +
        p.getTimeSlot()
    );
}
table.setItems(personalTasks);
//table.setFixedCellSize(25);//tmbh

//table.prefHeightProperty().bind(
    //table.fixedCellSizeProperty().multiply(
       // personalTasks.size() + 1.01));// tmbh


       Button btnAdd =new Button(" + Add");
       
       btnAdd.setStyle("-fx-background-color: lightgreen;"); //css

      btnAdd.setOnAction(e -> {

    AddPersonalTaskPage addPage =new AddPersonalTaskPage();

    addPage.show(primaryStage,username);

});  
        Button btnEdit =new Button("✏ Edit");
        btnEdit.setStyle("-fx-background-color: lightblue;"); //css
        
btnEdit.setOnAction(e -> {
    PersonalTask selectedTask =
            table.getSelectionModel()
                 .getSelectedItem();

    if (selectedTask != null) {

        EditPersonalTaskPage editPage =   new EditPersonalTaskPage();

        editPage.show(
                primaryStage, username, selectedTask);
    }
});
        Button btnDelete =new Button("🗑 Delete");
        btnDelete.setStyle("-fx-background-color: lightcoral;"); //css
        
btnDelete.setOnAction(e -> {

    PersonalTask selectedTask =
            table.getSelectionModel()
                 .getSelectedItem();

    if (selectedTask != null) {

        ArrayList<Task> allTasks =
                fileHandler.loadTasks();

        allTasks.removeIf(task ->
                task.getTaskID()
                        == selectedTask.getTaskID());

        fileHandler.saveTasks(allTasks);

        personalTasks.remove(selectedTask);

        Alert alert =
        new Alert(Alert.AlertType.INFORMATION);

alert.setTitle("Success");

alert.setHeaderText(null);

alert.setContentText( "Task Deleted Successfully");

alert.showAndWait();
    }
});
        Button btnBack =new Button("← Back"); //tmbh
        btnBack.setStyle("-fx-background-color: lightgray;"); //tmbh
        
        btnAdd.setPrefWidth(120); //tmbh
        btnEdit.setPrefWidth(120); //tmbh
        btnDelete.setPrefWidth(120); //tmbh
        btnBack.setPrefWidth(120); //tmbh

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                title, table, btnAdd, btnEdit, btnDelete, btnBack
        );
        
        Scene scene =new Scene(root,600,300);// tukar from 400 to 600 & 400 to 300)
        primaryStage.setScene(scene);
        btnBack.setOnAction(e -> {

            TaskHandlerPage taskPage = new TaskHandlerPage();

            taskPage.show(
                    primaryStage, username);
        });
    }
}
