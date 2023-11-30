package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoEmpresa;
import Objetos.ContactoPersona;
import espol.utilidades.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        VBox fieldsContainer = new VBox(10);
        fieldsContainer.setAlignment(Pos.CENTER);

        HBox hboxNombre = createField("Nombre: ");
        HBox hboxApellido = createField("Apellido: ");
        HBox hboxNumero = createField("Numero: ");
        HBox hboxDireccion = createField("Direccion: ");
        HBox hboxEmail = createField("e-mail: ");
        HBox hboxPagina = createField("Pagina Web: ");
        HBox hboxCumpleanos = createField("Fecha Cumpleaños: ");
        Map<String, LinkedList<String>> contenidosTextFields = new HashMap<>();

        Button btn_guardar = new Button("Guardar Contacto");
        btn_guardar.setOnAction(e -> {
            // Obtener el VBox principal
            VBox vboxPrincipal = (VBox) btn_guardar.getParent();
            // Obtener el segundo hijo que es el ScrollPane
            ScrollPane scrollPane = (ScrollPane) vboxPrincipal.getChildren().get(1);

            // Obtener el contenido del ScrollPane que contiene los HBox
            VBox contentVBox = (VBox) scrollPane.getContent();

            // Iterar sobre los HBox dentro del ScrollPane
            for (int i = 0; i < contentVBox.getChildren().size(); i++) {
                HBox hbox = (HBox) contentVBox.getChildren().get(i);

                // Verificar si el HBox tiene al menos dos hijos
                if (hbox.getChildren().size() > 1) {
                    // Obtener el segundo hijo del HBox que es el VBox con los TextField
                    VBox vboxConTextFields = (VBox) hbox.getChildren().get(1);

                    // Lista para almacenar los contenidos de los TextField para este VBox
                    LinkedList<String> contenidoVBox = new LinkedList<>();

                    // Iterar sobre los TextField dentro del VBox
                    for (int j = 0; j < vboxConTextFields.getChildren().size(); j++) {
                        TextField textField = (TextField) vboxConTextFields.getChildren().get(j);
                        // Agregar el contenido del TextField a la lista
                        contenidoVBox.addLast(textField.getText());
                    }

                    // Obtener el texto asociado al createField
                    String textoAsociado = ((Label) hbox.getChildren().get(0)).getText();

                    // Asociar el texto al contenido de los TextField en el mapa
                    contenidosTextFields.put(textoAsociado, contenidoVBox);
                }
            }
            // Crear un objeto ContactoPersona usando los valores almacenados en el HashMap
            String nombre = contenidosTextFields.get("Nombre:").getFirst();
            String apellido = contenidosTextFields.get("Apellido:").getFirst();
            LinkedList numeros = contenidosTextFields.get("Numero:");
            LinkedList direcciones = contenidosTextFields.get("Direccion:");
            LinkedList emails = contenidosTextFields.get("e-mail:");
            LinkedList redes = contenidosTextFields.get("Redes:");
            String fechaCumpleanos = contenidosTextFields.get("Fecha Cumpleaños:").getFirst();
            LinkedList fotos=new LinkedList<>();
            // Crear un objeto ContactoPersona
            ContactoPersona nuevoContactoPersona = new ContactoPersona(apellido, fechaCumpleanos, nombre, fotos, direcciones, emails, numeros, redes);

            contactos.add(nuevoContactoPersona);
            guardarContactosEnArchivo();
            System.out.println("Se guardó archivo");
        });

        fieldsContainer.getChildren().addAll(hboxNombre, hboxApellido, hboxNumero, hboxDireccion, hboxEmail, hboxPagina, hboxCumpleanos);

        // Agregar un ScrollPane alrededor del VBox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(fieldsContainer);
        scrollPane.setFitToWidth(true);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().addAll(label, scrollPane, btn_guardar);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createField(String labelText) {
        Label label = new Label(labelText);
        TextField textField = new TextField();
        textField.setOnKeyTyped(event -> {
            var input = event.getCharacter();
            if (!input.matches("[a-zA-Z]")) {
                event.consume(); // No permite la entrada si no es una letra
            }
        });

        VBox vboxTextField = new VBox(5);
        vboxTextField.getChildren().add(textField);

        VBox vboxButtons = new VBox(5);
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Obtener el VBox de botones
                VBox vboxBotones = (VBox) btnAgregar.getParent();
                // Obtener el VBox principal
                HBox hboxPrincipal = (HBox) vboxBotones.getParent();
                // Obtener el segundo VBox con el TextField
                VBox vboxConTextField = (VBox) hboxPrincipal.getChildren().get(1);

                // Agregar otro TextField al VBox
                TextField nuevoTextField = new TextField("Nuevo TextField");
                vboxConTextField.getChildren().add(nuevoTextField);
            }
        });
        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> {
            // Obtener el VBox de botones
            VBox vboxBotones = (VBox) btnEliminar.getParent();
            // Obtener el VBox principal
            HBox hboxPrincipal = (HBox) vboxBotones.getParent();
            // Obtener el segundo VBox con el TextField
            VBox vboxConTextField = (VBox) hboxPrincipal.getChildren().get(1);

            // Verificar si hay más de un hijo en el VBox antes de intentar eliminar
            if (vboxConTextField.getChildren().size() > 1) {
                // Eliminar el último hijo del VBox
                vboxConTextField.getChildren().remove(vboxConTextField.getChildren().size() - 1);
            }
        });
        vboxButtons.getChildren().addAll(btnAgregar, btnEliminar);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(label, vboxTextField, vboxButtons);

        return hbox;
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

    public static void main(String[] args) {
        launch(args);
    }
}
