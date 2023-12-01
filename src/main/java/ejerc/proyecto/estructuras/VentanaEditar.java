/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoPersona;
import espol.utilidades.Archivos;
import espol.utilidades.DoubleLinkedList;
import espol.utilidades.LinkedList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Michael
 */
public class VentanaEditar extends Application {

    /**
     * @param args the command line arguments
     */
    private VBox root = new VBox();
    private DoubleLinkedList<String> fotos = verContactos.contactoSeleccionado.getFoto();
    private ListIterator<String> iterator = fotos.listIterator();
    private ImageView imgv = new ImageView();

    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) {
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
            HBox hboxNombre = new HBox();
            Label lNombre = new Label("Nombre:");
            TextField lblNombre = new TextField(cp.getNombre());
            hboxNombre.getChildren().addAll(lNombre, lblNombre);
            HBox hboxApellido = new HBox();
            Label lApellido = new Label("Apellido:");
            TextField lblApellido = new TextField(cp.getApellido());
            hboxApellido.getChildren().addAll(lApellido, lblApellido);
            VBox vboxNombre=new VBox();
            VBox vboxApellido=new VBox();
            VBox vboxTelefonos = new VBox();
            VBox vboxEmails = new VBox();
            VBox vboxDirecciones = new VBox();
            VBox vboxCum = new VBox();
            vboxNombre.getChildren().add(hboxNombre);
            vboxApellido.getChildren().add(hboxApellido);
            if (!cp.getNumerosTelefonicos().isEmpty()) {
                for (String telefono : cp.getNumerosTelefonicos()) {
                    TextField lblt = new TextField();
                    Label tx = new Label("Numero:");
                    lblt.setText(telefono);
                    HBox data = new HBox();
                    data.getChildren().addAll(tx, lblt);
                    vboxTelefonos.getChildren().add(data);

                }

            }
            if (!cp.getEmailPersonal().isEmpty()) {
                for (String email : cp.getEmailPersonal()) {
                    TextField lblt = new TextField();
                    Label tx = new Label("e-mail:");
                    lblt.setText(email);
                    HBox data = new HBox();
                    data.getChildren().addAll(tx, lblt);
                    vboxEmails.getChildren().add(data);

                }

            }
            if (!cp.getDireccion().isEmpty()) {
                for (String direccion : cp.getDireccion()) {
                    TextField lblt = new TextField();
                    Label tx = new Label("Direcion:");
                    lblt.setText(direccion);
                    HBox data = new HBox();
                    data.getChildren().addAll(tx, lblt);
                    vboxDirecciones.getChildren().add(data);

                }

            }
            HBox hboxCum = new HBox();
            Label lCum = new Label("Fecha Cumpleaños:");
            TextField lblCum = new TextField(cp.getFechaCumpleanos());
            hboxCum.getChildren().addAll(lCum, lblCum);
            vboxCum.getChildren().add(hboxCum);
            root.getChildren().addAll(vboxNombre, vboxApellido, vboxTelefonos, vboxEmails, vboxDirecciones, vboxCum);

        }
        HBox botones = new HBox();
        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            TextField txtNombre = (TextField)((HBox) ((VBox) root.getChildren().get(1)).getChildren().get(0)).getChildren().get(1);
            VBox vboxTelefonos = (VBox) root.getChildren().get(3);
            TextField txtTelefono = (TextField) ((HBox) vboxTelefonos.getChildren().get(0)).getChildren().get(1);
            if (!txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty()) {
                // Obtener el VBox principal
                VBox vboxPrincipal = (VBox) ((HBox) btnGuardar.getParent()).getParent();
                Map<String, LinkedList<String>> contenidosTextFields = new HashMap<>();

                // Iterar sobre los HBox dentro del ScrollPane
                for (int i = 1; i < vboxPrincipal.getChildren().size() - 1; i++) {
                    VBox vbox = (VBox) vboxPrincipal.getChildren().get(i);
                    HBox hbox1 = (HBox) vbox.getChildren().get(0);

                    LinkedList<String> contenidoVBox = new LinkedList<>();

                    // Iterar sobre los TextField dentro del VBox
                    for (int j = 0; j < vbox.getChildren().size(); j++) {
                        HBox hbox = (HBox) vbox.getChildren().get(j);

                        TextField textField = (TextField) hbox.getChildren().get(1);
                        // Agregar el contenido del TextField a la lista
                        if (!textField.getText().isEmpty()) {
                            contenidoVBox.addLast(textField.getText());
                        }

                    }

                    // Obtener el texto asociado al createField
                    String textoAsociado = ((Label) hbox1.getChildren().get(0)).getText();
                    // Asociar el texto al contenido de los TextField en el mapa
                    contenidosTextFields.put(textoAsociado, contenidoVBox);

                }
                // Crear un objeto ContactoPersona usando los valores almacenados en el HashMap
                String nombre = contenidosTextFields.get("Nombre:").getFirst();
                String apellido = "";
                if (!contenidosTextFields.get("Apellido:").isEmpty()) {
                    apellido = contenidosTextFields.get("Apellido:").getFirst();
                }

                LinkedList<String> numeros = contenidosTextFields.get("Numero:");
                LinkedList<String> direcciones = contenidosTextFields.get("Direccion:");
                LinkedList<String> emails = contenidosTextFields.get("e-mail:");
                LinkedList<String> redes = contenidosTextFields.get("Redes:");
                String fechaCumpleanos = "";
                if (!contenidosTextFields.get("Fecha Cumpleaños:").isEmpty()) {
                    fechaCumpleanos = contenidosTextFields.get("Fecha Cumpleaños:").getFirst();
                }

                // Crear un objeto ContactoPersona
                ContactoPersona nuevoContactoPersona = new ContactoPersona(apellido, fechaCumpleanos, nombre, fotos, direcciones, emails, numeros, redes);

                for (Usuario usuario : App.listaUsuarios) {
                    System.out.println(usuario);
                    if (usuario.equals(App.usuario)) {
                        int indice = usuario.getContactos().indexOf(c);
                        usuario.getContactos().set(indice, nuevoContactoPersona);

                        break;

                    }
                }
                Archivos.serializarListaUsuarios(App.listaUsuarios, "usuarios.ser");
                System.out.println("Se guardó archivo");
                mostrarAlerta();
                Stage stageGuardar = (Stage) btnGuardar.getScene().getWindow();

                // Cerrar el Stage del botón btn_guardar
                stageGuardar.close();

            }
        });
        Button btnCancelar = new Button("Cancelar");
        botones.getChildren().addAll(btnGuardar, btnCancelar);
        root.getChildren().add(botones);
        btnCancelar.setOnAction(e -> {

        });
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Ver Contactos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void mostrarAlerta() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Se ha editado con éxito el contacto.");

        alert.showAndWait();
    }

    private void mostrarImagenActual(String rutaImagen) {
        Image image = new Image(rutaImagen);
        imgv.setImage(image);
    }

}
