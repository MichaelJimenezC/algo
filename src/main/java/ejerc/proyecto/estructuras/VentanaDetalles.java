/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoPersona;
import espol.utilidades.DoubleLinkedList;
import java.util.ListIterator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    private DoubleLinkedList<String> fotos = verContactos.contactoSeleccionado.getFoto();
    private ListIterator<String> iterator = fotos.listIterator();
    private ImageView imgv = new ImageView();

    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        imgv.setFitWidth(100);
        imgv.setFitHeight(100);
        if (iterator.hasNext()) {
            mostrarImagenActual(iterator.next());
        }
        VBox vboxFotos = new VBox();
        HBox hboxBotonesFotos = new HBox();
        Button btnAtras = new Button("Anterior");
        Button btnAdelante = new Button("Adelante");
        btnAtras.setOnAction(e -> {
            if (!fotos.isEmpty()) {
                System.out.println("para atras");
                if (iterator.hasPrevious()) {
                    String anteriorFoto = iterator.previous();
                    mostrarImagenActual(anteriorFoto);
                } else {
                    // Vamos al final de la lista
                    while (iterator.hasNext()) {
                        iterator.next();
                    }
                    if (iterator.hasPrevious()) {
                        String anteriorFoto = iterator.previous();
                        mostrarImagenActual(anteriorFoto);
                    }
                }
            }
        });
        btnAdelante.setOnAction(e -> {
            if (!fotos.isEmpty()) {
                if (iterator.hasNext()) {
                    System.out.println("pa delante");
                    String siguienteFoto = iterator.next();
                    mostrarImagenActual(siguienteFoto);
                } else {
                    // Volvemos al principio de la lista
                    iterator = fotos.listIterator();
                    if (iterator.hasNext()) {
                        String siguienteFoto = iterator.next();
                        mostrarImagenActual(siguienteFoto);
                    }
                }
            }
        });
        hboxBotonesFotos.getChildren().addAll(btnAtras, btnAdelante);
        vboxFotos.getChildren().addAll(imgv, hboxBotonesFotos);
        root.getChildren().add(vboxFotos);
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
            root.getChildren().addAll(lblNombre, lblApellido, vboxTelefonos, vboxEmails);

        }
        HBox botones = new HBox();
        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> {
            for (Usuario usuario : App.listaUsuarios) {
                System.out.println(usuario);
                if (usuario.equals(App.usuario)) {
                    usuario.getContactos().remove(verContactos.contactoSeleccionado);

                    break;

                }
            }
        });
        Button btnEditar = new Button("Editar");
        botones.getChildren().addAll(btnEliminar, btnEditar);
        root.getChildren().add(botones);
        btnEditar.setOnAction(e -> {
            mostrarVentanaEditar();
        });
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Ver Contactos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void mostrarVentanaEditar() {
        try {
            VentanaEditar VentanaDetalles = new VentanaEditar();
            VentanaDetalles.start(new Stage());
        } catch (Exception ex) {
        }
    }

    private void mostrarImagenActual(String rutaImagen) {
        Image image = new Image(rutaImagen);
        imgv.setImage(image);
    }

}
