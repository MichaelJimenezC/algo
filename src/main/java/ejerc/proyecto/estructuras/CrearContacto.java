package ejerc.proyecto.estructuras;

import Objetos.Contacto;
import Objetos.ContactoEmpresa;
import Objetos.ContactoPersona;
import static ejerc.proyecto.estructuras.App.listaUsuarios;
import espol.utilidades.Archivos;
import espol.utilidades.DoubleLinkedList;
import espol.utilidades.LinkedList;
import java.io.File;
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
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class CrearContacto extends Application {

    TextField txt_nombre;
    TextField txt_numeroTelefono;
    TextField txt_apellido;
    TextField txt_direccion;
    TextField txt_email;
    TextField txt_paginaweb;
    TextField txt_cumpleanos;

    private ArrayList<Contacto> contactos = new ArrayList<>();
    private DoubleLinkedList<String> fotos = new DoubleLinkedList<>();
    private ListIterator<String> iterator = fotos.listIterator();
    private ImageView imgv = new ImageView();

    @Override
    public void start(Stage primaryStage) {

        imgv.setFitWidth(100);
        imgv.setFitHeight(100);

        Label label = new Label("Nuevo Contacto");
        Font fuente = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        label.setFont(fuente);

        VBox fieldsContainer = new VBox(10);
        fieldsContainer.setAlignment(Pos.CENTER);
        VBox vboxfotos = new VBox();

        HBox botones = new HBox();
        Button btnAgregar = new Button("Agregar");
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
        btnAgregar.setOnAction(e -> {
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecciona una imagen");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagenes", "*.png", "*.jpg", "*.jpeg"));

            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                // Asumiendo que "Img" es una carpeta en el mismo directorio que el directorio de salida del proyecto.
                Path destPath = Paths.get("Img" + File.separator + selectedFile.getName());

                // Verificar si el archivo ya existe en el directorio
                if (Files.exists(destPath)) {
                    // El archivo ya existe, puedes mostrar un mensaje o realizar alguna acción.
                    System.out.println("La imagen ya existe en el directorio.");
                } else {
                    try {
                        // El archivo no existe, copiarlo y agregarlo a la lista
                        Files.copy(selectedFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Reflejar la imagen en la UI
                    String rutaImagen = destPath.toUri().toString();
                    Image image = new Image(rutaImagen);
                    imgv.setImage(image);
                    fotos.add(rutaImagen);
                    System.out.println("se agregó");
                    if (iterator.hasNext()) {
                        iterator.next();
                    }

                }
            }
        });
        botones.getChildren().addAll(btnAtras, btnAgregar, btnAdelante);
        vboxfotos.getChildren().addAll(imgv, botones);
        HBox hboxNombre = createField("Nombre:");
        HBox hboxApellido = createField("Apellido:");
        HBox hboxNumero = createField("Numero:");
        HBox hboxDireccion = createField("Direccion:");
        HBox hboxEmail = createField("e-mail:");
        HBox hboxPagina = createField("Pagina Web:");
        HBox hboxCumpleanos = createField("Fecha Cumpleaños:");
        Map<String, LinkedList<String>> contenidosTextFields = new HashMap<>();
        VBox vBoxNombre = (VBox) hboxNombre.getChildren().get(1);
        TextField txtNombre = (TextField) vBoxNombre.getChildren().get(0);
        VBox vBoxTelefono = (VBox) hboxNumero.getChildren().get(1);
        TextField txtTelefono = (TextField) vBoxTelefono.getChildren().get(0);
        Button btn_guardar = new Button("Guardar Contacto");
        btn_guardar.setOnAction(e -> {
            if (!txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty()) {
                // Obtener el VBox principal
                VBox vboxPrincipal = (VBox) btn_guardar.getParent();

                // Obtener el segundo hijo que es el ScrollPane
                ScrollPane scrollPane = (ScrollPane) vboxPrincipal.getChildren().get(2);

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
                            if (!textField.getText().isEmpty()) {
                                contenidoVBox.addLast(textField.getText());
                            }

                        }

                        // Obtener el texto asociado al createField
                        String textoAsociado = ((Label) hbox.getChildren().get(0)).getText();
                        System.out.println(textoAsociado);
                        // Asociar el texto al contenido de los TextField en el mapa
                        contenidosTextFields.put(textoAsociado, contenidoVBox);
                    }
                }
                // Crear un objeto ContactoPersona usando los valores almacenados en el HashMap
                System.out.println(contenidosTextFields.get("Nombre:").size());
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
                        if (!usuario.getContactos().isEmpty()) {
                            if (!usuario.getContactos().contains(nuevoContactoPersona)) {
                                usuario.getContactos().add(nuevoContactoPersona);

                                break;
                            }
                        }else{
                            usuario.getContactos().add(nuevoContactoPersona);
                        }

                    }
                }
                Archivos.serializarListaUsuarios(App.listaUsuarios, "usuarios.ser");
                System.out.println("Se guardó archivo");
                mostrarAlerta();
                Stage stageGuardar = (Stage) btn_guardar.getScene().getWindow();

                // Cerrar el Stage del botón btn_guardar
                stageGuardar.close();

            }
        });

        fieldsContainer.getChildren().addAll(hboxNombre, hboxApellido, hboxNumero, hboxDireccion, hboxEmail, hboxPagina, hboxCumpleanos);

        // Agregar un ScrollPane alrededor del VBox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(fieldsContainer);
        scrollPane.setFitToWidth(true);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().addAll(label, vboxfotos, scrollPane, btn_guardar);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarAlerta() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Se ha creado con éxito el contacto.");

        alert.showAndWait();
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
            FileOutputStream fileOut = new FileOutputStream("usuarios.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(App.listaUsuarios);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void mostrarImagenActual(String rutaImagen) {
        Image image = new Image(rutaImagen);
        imgv.setImage(image);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
