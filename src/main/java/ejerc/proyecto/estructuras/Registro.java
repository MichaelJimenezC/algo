package ejerc.proyecto.estructuras;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class Registro extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField txt_correo= new TextField();
        Button btn_registrar = new Button("Registrar");
        Label lbl_correo= new Label("Ingrese su correo: ");
        Label lbl_clave=new Label("Ingrese su clave:   ");
        TextField txt_clave= new TextField();
        Button btn_volver= new Button("Volver");
        Label lbl_Registro= new Label("Registro");
        Font fuente = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        lbl_Registro.setFont(fuente);
        BorderPane.setAlignment(lbl_Registro, Pos.CENTER);
        HBox horizontal1=new HBox();
        HBox horizontal2=new HBox();
        VBox vertical1=new VBox();
        btn_registrar.setAlignment(Pos.CENTER);
        vertical1.setAlignment(Pos.CENTER);
        horizontal1.getChildren().add(lbl_correo);
        horizontal1.getChildren().add(txt_correo);
        horizontal2.getChildren().add(lbl_clave);
        horizontal2.getChildren().add(txt_clave);
        vertical1.getChildren().add(horizontal1);
        vertical1.getChildren().add(horizontal2);
        vertical1.getChildren().add(btn_registrar);
        horizontal1.setAlignment(Pos.CENTER);
        horizontal2.setAlignment(Pos.CENTER);
        vertical1.setAlignment(Pos.CENTER);
        btn_volver.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        btn_volver.setOnMouseClicked(e -> primaryStage.close());
        btn_registrar.setOnMouseClicked(e -> registrar());
        vertical1.setSpacing(10);
        BorderPane root = new BorderPane();
        root.setTop(lbl_Registro);
        root.setCenter(vertical1);
        root.setBottom(btn_volver);
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Registro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void registrar(){
        try{
            Alert alert = new
            Alert(AlertType.INFORMATION);
            alert.setTitle("Registro Exitoso");
            alert.setHeaderText("Se ha podido registrar de manera exitosa!");
            alert.setContentText("Tenga un buen dia!");
            alert.showAndWait();
        }catch(Exception e){
            
        }
}
}
