/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerc.proyecto.estructuras;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author crist
 */
public class Menu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btn_Crearcontacto= new Button("Crear Contacto");
        Button btn_CerrarSesion= new Button("Cerrar Sesion");
        Button btn_VerContactos=new Button("Ver mis contactos");
        VBox vertical1= new VBox();
        vertical1.getChildren().add(btn_Crearcontacto);
        vertical1.getChildren().add(btn_CerrarSesion);
        vertical1.getChildren().add(btn_VerContactos);
        vertical1.setSpacing(25);
        vertical1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vertical1, 400, 300);
        btn_Crearcontacto.setOnMouseClicked(e -> mostrarCrearContacto() );
        btn_CerrarSesion.setOnMouseClicked(e -> stage.close());
        btn_VerContactos.setOnMouseClicked(e -> mostrarContactos());
        stage.setTitle("Inicio de Sesión");
        stage.setScene(scene);
        stage.show();
    }
      public static void main(String[] args) {
        launch(args);
    }
      
      public void mostrarCrearContacto(){
        try {
            CrearContacto VentanaContacto = new CrearContacto();
            VentanaContacto.start(new Stage());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
      
      public void mostrarContactos(){
          try{
              verContactos mostrarContacto = new verContactos();
              mostrarContacto.start(new Stage());
          }catch(Exception ex){
          }
      }
      
}
