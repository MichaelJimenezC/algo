/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoPersona;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Michael
 */
public class VentanaDetalles extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Contacto c = verContactos.contactoSeleccionado;
        if (c instanceof ContactoPersona) {
            ContactoPersona cp = (ContactoPersona) c;

            Label lblNombre = new Label("Nombre: " + cp.getNombre());
            Label lblApellido = new Label("Apellido: " + cp.getApellido());
            VBox vboxTelefonos = new VBox();
            VBox vboxEmails = new VBox();
            if (!cp.getNumerosTelefonicos().isEmpty()) {
                for (String telefono : cp.getNumerosTelefonicos()) {
                    Label lblt = new Label();
                    lblt.setText("Telefono: " + telefono);
                    vboxTelefonos.getChildren().add(lblt);

                }

            }
            if (!cp.getEmailPersonal().isEmpty()) {
                for (String email : cp.getEmailPersonal()) {
                    Label lblt = new Label();
                    lblt.setText("Email: " + email);
                    vboxEmails.getChildren().add(lblt);

                }

            }
            if (!cp.getDireccion().isEmpty()) {
                for (String direccion : cp.getDireccion()) {
                    Label lblt = new Label();
                    lblt.setText("Direcion: " + direccion);
                    vboxEmails.getChildren().add(lblt);

                }

            }
            root.getChildren().addAll(lblNombre,lblApellido,vboxTelefonos,vboxEmails);
            

        }
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Ver Contactos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
