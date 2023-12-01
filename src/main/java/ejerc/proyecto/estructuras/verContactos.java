/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoEmpresa;
import Objetos.ContactoPersona;
import espol.utilidades.DoubleLinkedList;
import java.util.ListIterator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Michael
 */
public class verContactos extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage)  {
        VBox root = new VBox();   
        DoubleLinkedList<Contacto> contactos=App.usuario.getContactos();
        ListIterator<Contacto> iterator = contactos.listIterator();
        if(!contactos.isEmpty()){
            if(iterator.hasNext()){
                System.out.println("hola");
                Contacto c=iterator.next();
                VBox cajaContacto=new VBox();
                if(c instanceof ContactoPersona){
                    ContactoPersona cp=(ContactoPersona)c;
                    Label lblNombre=new Label(cp.getNombre());
                    Label lblApellido=new Label(cp.getApellido());
                    Label lblCumpleaños=new Label(cp.getFechaCumpleanos());
                    cajaContacto.getChildren().addAll(lblNombre,lblApellido,lblCumpleaños);
                    root.getChildren().add(cajaContacto);
                }
            }
        }else{
            System.out.println("wtf");
        }
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Ver Contactos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
