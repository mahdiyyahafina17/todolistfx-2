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

public class TaskHandlerPage {

    public void show(Stage primaryStage,String username) {

        Label title = new Label("TASK MANAGEMENT");
    title.setStyle(
    "-fx-font-size: 24px; "
    + "-fx-font-weight: bold;"); //css

        Button btnPersonal = new Button(" 📌 Personal Tasks");
        btnPersonal.setOnAction(e -> {

    PersonalTaskPage personalPage = new PersonalTaskPage();

    personalPage.show(primaryStage,username);

});
        Button btnAcademic = new Button(" 📚 Academic Tasks");
        btnAcademic.setOnAction(e -> {

    AcademicTaskPage academicPage =new AcademicTaskPage();

    academicPage.show( primaryStage, username);
});

        Button btnBack = new Button("Back");

        btnPersonal.setPrefWidth(180); //css

        btnAcademic.setPrefWidth(180); //css

        btnBack.setPrefWidth(100);//css

        
        btnPersonal.setStyle( //css
    "-fx-background-radius: 10;"
    + "-fx-font-weight: bold;"
    );

        btnAcademic.setStyle( //css
    "-fx-background-radius: 10;"
    + "-fx-font-weight: bold;"
    );

    btnBack.setStyle( //css
    "-fx-background-radius: 10;"
    );
    
    
        VBox root = new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,btnPersonal,btnAcademic,btnBack );

        Scene scene =new Scene(root, 400, 400);

        primaryStage.setScene(scene);

        btnBack.setOnAction(e -> {

            DashboardPage dashboard =new DashboardPage();

            dashboard.show(
                    primaryStage,username);

        });
    }
}