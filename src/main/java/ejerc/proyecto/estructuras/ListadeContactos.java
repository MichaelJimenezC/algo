/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerc.proyecto.estructuras;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Objetos.*;
import espol.utilidades.*;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
/**
 *
 * @author Lenovo
 */
public class ListadeContactos extends Application{
    
    private ArrayList<Contacto> contactos = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        
        Label label = new Label("Lista de Contactos");
        Font fuente = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        label.setFont(fuente);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        
        cargarContactosDesdeArchivo();

        ListView<Contacto> listaContactos = new ListView<>();
        for (int i = 0; i < contactos.size(); i++) {
            listaContactos.getItems().add(contactos.get(i));
        }
        
        Button btn_volver = new Button("Volver");
        btn_volver.setOnMouseClicked(e -> primaryStage.close());
        grid.setAlignment(Pos.CENTER);
        grid.add(listaContactos,0,0);
        grid.add(btn_volver, 1, 1);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER); 
        root.getChildren().addAll(label,grid);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cargarContactosDesdeArchivo() {
        try {
            FileInputStream fileIn = new FileInputStream("contactos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            contactos = (espol.utilidades.ArrayList<Contacto>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("La clase Contacto no se encontró");
            c.printStackTrace();
            return;
        }
    }
}
