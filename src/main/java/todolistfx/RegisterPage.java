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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterPage {

    public void show(Stage primaryStage) {

        Label title = new Label("REGISTER");
title.setStyle(
    "-fx-font-size: 20px; "
    + "-fx-font-weight: bold;");// css


        Label lblUsername =
        new Label("Username");

TextField txtUsername =
        new TextField();

Label lblPassword =
        new Label("Password");

PasswordField txtPassword =
        new PasswordField();


Label lblConfirm =
        new Label("Confirm Password");

PasswordField txtConfirm =
        new PasswordField();

txtUsername.setMaxWidth(200);//css
txtPassword.setMaxWidth(200); //css
txtConfirm.setMaxWidth(200); //css

        Button btnCreate = new Button("Create Account");
        btnCreate.setTranslateY(20);//css
        
      btnCreate.setOnAction(e -> {

    String username =
            txtUsername.getText();

    String password =
            txtPassword.getText();

    String confirmPassword =
            txtConfirm.getText();

    if (!password.equals(confirmPassword)) {

        System.out.println("Password does not match.");

        return;
    }

    UserHandler userHandler =
            new UserHandler();

    FileHandler fileHandler =
            new FileHandler();
    
    userHandler.getUsers().addAll( fileHandler.loadUsers());// previous data not missing, load old user

    userHandler.registerUser( //add new user
            username,
            password);

    fileHandler.saveUsers( //save all user
            userHandler.getUsers());
 
    System.out.println("Account created successfully.");
    TodolistfX loginPage = new TodolistfX();

try {
    loginPage.start(primaryStage);
} catch (Exception ex) {
    ex.printStackTrace();
}
});
        Button btnBack = new Button("Back");
        btnBack.setTranslateY(20);//css

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

root.getChildren().addAll(
        title,

        lblUsername,
        txtUsername,

        lblPassword,
        txtPassword,

        lblConfirm,
        txtConfirm,

        btnCreate,
        btnBack
);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);

        btnBack.setOnAction(e -> {

            TodolistfX loginPage = new TodolistfX();

            try {
                loginPage.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

    }
}