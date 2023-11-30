/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerc.proyecto.estructuras;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Objetos.*;
import espol.utilidades.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


/**
 *
 * @author crist
 */

public class CrearContacto extends Application {
    
    TextField txt_nombre;
    TextField txt_numeroTelefono;
    TextField txt_apellido;
    TextField txt_direccion;
    TextField txt_email;
    TextField txt_paginaweb;
    TextField txt_cumpleanos;
 
    private ArrayList<Contacto> contactos = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        
        Label label = new Label("Nuevo Contacto");
        Font fuente = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        label.setFont(fuente);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        
        Label lbl_nombre = new Label("Nombre: ");
        txt_nombre = new TextField();
        txt_nombre.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                var input = event.getCharacter();
                if (!input.matches("[a-zA-Z]")) {
                    event.consume(); // No permite la entrada si no es una letra
                }
            }
        });
        
        Label lbl_apellido = new Label("Apellido: ");
        txt_apellido = new TextField();
        txt_apellido.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                var input = event.getCharacter();
                if (!input.matches("[a-zA-Z]")) {
                    event.consume(); // No permite la entrada si no es una letra
                }
            }
        });
        
        Label lbl_numero = new Label("Numero: ");
        txt_numeroTelefono = new TextField();
        txt_numeroTelefono.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                var input = event.getCharacter();
                if (!input.matches("[0-9.]")) {
                    event.consume(); // No permite la entrada si no es un numero
                }
            }
        });
        
        Label lbl_direccion = new Label("Direccion: ");
        txt_direccion = new TextField();
        Label lbl_email = new Label("e-mail: ");
        txt_email = new TextField();
        Label lbl_pagina = new Label("Pagina Web: ");
        txt_paginaweb = new TextField();
        Label lbl_cumpleanos = new Label("Fecha Cumpleaños: ");
        txt_cumpleanos = new TextField();

        Button btn_guardar = new Button("Guardar Contacto");
        btn_guardar.setOnAction(e -> {
            Contacto nuevoContacto;
            if(txt_apellido.getText().equals(null)){
                nuevoContacto = new ContactoEmpresa(txt_nombre.getText(), txt_numeroTelefono.getText(), "FotoContacto1.png", 
                        txt_direccion.getText(), txt_email.getText(), txt_paginaweb.getText());
            }else{
                nuevoContacto = new ContactoPersona(txt_nombre.getText(), txt_apellido.getText(), txt_numeroTelefono.getText(), "FotoContacto1.png", 
                        txt_direccion.getText(), txt_email.getText(), txt_paginaweb.getText());
            }
            contactos.addLast(nuevoContacto);
            guardarContactosEnArchivo();
        });
        
        grid.setAlignment(Pos.CENTER);
        grid.add(lbl_nombre,0,0);
        grid.add(txt_nombre,1,0);
        grid.add(lbl_apellido,0,1);
        grid.add(txt_apellido, 1, 1);
        grid.add(lbl_numero,0,2);
        grid.add(txt_numeroTelefono, 1, 2);
        grid.add(lbl_direccion,0,3);
        grid.add(txt_direccion, 1, 3);
        grid.add(lbl_email,0,4);
        grid.add(txt_email, 1, 4);
        grid.add(lbl_pagina,0,5);
        grid.add(txt_paginaweb, 1, 5);
        grid.add(lbl_cumpleanos,0,6);
        grid.add(txt_cumpleanos, 1, 6);
        grid.add(btn_guardar, 0, 7);
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER); 
        root.getChildren().addAll(label,grid);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void guardarContactosEnArchivo() {
        try {
        FileOutputStream fileOut = new FileOutputStream("contactos.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(contactos);
        out.close();
        fileOut.close();
    } catch (IOException i) {
        i.printStackTrace();
    }
    }
}
