/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package todolistfx;

/**
 *
 * @author user
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodolistfX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      Label title = new Label("TO-DO LIST");
title.setStyle(
    "-fx-font-size: 24px; " // tukar 20px-24px
    + "-fx-font-weight: bold;"
);

Label lblUsername =new Label("Username");
TextField txtUsername =new TextField();

Label lblPassword =new Label("Password");

PasswordField txtPassword =new PasswordField();
txtUsername.setMaxWidth(200);

txtPassword.setMaxWidth(200);

Label lblError = new Label(""); //tmbh

lblError.setStyle("-fx-text-fill: red;"); //css

Button btnLogin = new Button("Login");
btnLogin.setTranslateY(15);

btnLogin.setOnAction(e -> {              //dashboard page

    String username =
            txtUsername.getText();

    String password =
            txtPassword.getText();

    FileHandler fileHandler =
            new FileHandler();

    UserHandler userHandler =
            new UserHandler();

    userHandler.getUsers().addAll(
            fileHandler.loadUsers());

    User user =
            userHandler.loginUser(
                    username,
                    password);

    if (user != null) {

        DashboardPage dashboard =
                new DashboardPage();

        dashboard.show(
                primaryStage,
                username);
    }

    else{
    lblError.setText( //tmbh
            "Wrong username or password. Please enter again.");

    txtPassword.clear(); //css
}

});

Label lblRegister= new Label("Don't have an account?");
lblRegister.setTranslateY(15);

Button btnRegister =new Button("Register");
btnRegister.setTranslateY(15);

btnRegister.setOnAction(e -> {
    

    
    RegisterPage registerPage =
            new RegisterPage();

    registerPage.show(primaryStage);

});
btnLogin.setPrefWidth(150);

btnRegister.setPrefWidth(150);

btnLogin.setStyle( //css
    "-fx-background-radius: 10;"  
    + "-fx-font-weight: bold;"   
    + "-fx-cursor: hand;"
);

btnRegister.setStyle( //css
    "-fx-background-radius: 10;"
    + "-fx-font-weight: bold;"
    + "-fx-cursor: hand;"
);


VBox root =new VBox(10);

root.setAlignment(Pos.CENTER);


root.getChildren().addAll(
        title,lblUsername,txtUsername,lblPassword,txtPassword,lblError, btnLogin,lblRegister,btnRegister);

Scene scene =new Scene(root, 450, 350);

primaryStage.setTitle("To-Do List System");

primaryStage.setScene(scene);

primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}