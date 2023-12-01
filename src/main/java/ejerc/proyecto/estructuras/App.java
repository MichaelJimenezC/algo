package ejerc.proyecto.estructuras;

import espol.utilidades.Archivos;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Usuario usuario = null;
    public static ArrayList<Usuario> listaUsuarios = Archivos.deserializarListaUsuarios("usuarios.ser");

    @Override
    public void start(Stage stage) throws Exception {
        Button btn_registrarse = new Button(" Registrarse ");
        Button btn_inicio = new Button(" Iniciar Sesión ");
        Label lbl_cuenta = new Label("Aun no tienes una cuenta? Registrate");
        Font fuente_lbl = Font.font("Verdana", FontWeight.EXTRA_BOLD, 10);
        lbl_cuenta.setFont(fuente_lbl);
        BorderPane root = new BorderPane();
        Label lbl_menu = new Label("Lista De Contactos");
        Font fuente = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
        lbl_menu.setFont(fuente);
        BorderPane.setAlignment(lbl_menu, Pos.CENTER);
        VBox btn_botones = new VBox();
        btn_botones.getChildren().addAll(btn_inicio, btn_registrarse, lbl_cuenta);
        btn_botones.setAlignment(Pos.CENTER);
        btn_botones.setSpacing(10);
        Button btn_salir = new Button("X Salir");
        btn_salir.setStyle("-fx-background-color: red; -fx-text-fill: white;");
//        FileInputStream input = new FileInputStream("Imagenes/Imagen menu contactos.png");
//        Image image = new Image(input);
//        ImageView imageView = new ImageView("image");
//        root.getChildren().add(imageView);
        root.setTop(lbl_menu);
        root.setBottom(btn_salir);
        root.setCenter(btn_botones);
        btn_salir.setOnMouseClicked(e -> stage.close());
        btn_inicio.setOnMouseClicked(e -> {
            Stage stageGuardar = (Stage) btn_inicio.getScene().getWindow();
            stageGuardar.close();
            mostrarVentanaInicioSesion();

        });
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Inicio");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void mostrarVentanaRegistro() {
        try {
            Registro VentanaCrearCli = new Registro();
            VentanaCrearCli.start(new Stage());
        } catch (Exception ex) {
        }
    }

    public void mostrarVentanaInicioSesion() {
        try {
            InicioSesion VentanaInicioSesion = new InicioSesion();
            VentanaInicioSesion.start(new Stage());
        } catch (Exception ex) {
        }
    }

    public static ArrayList<Usuario> crearListaUsuarios(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                lineas.add(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo, estamos en el metodo de crear lista de usuarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lineas.size(); i++) {
            String[] ListaLineas = lineas.get(i).split(",");
            String user = ListaLineas[0];
            System.out.println(user);
            String password = ListaLineas[1];
            System.out.println(password);
            usuarios.add(new Usuario(user, password));

        }
        return usuarios;
    }

    public static Usuario verificarUsuario(String user, String contra) {
        System.out.println(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.getUser());
            System.out.println(usuario.getPassword());
            if (usuario.getUser().equals(user) && usuario.getPassword().equals(contra)) {

                System.out.println(usuario);
                System.out.println("Usuario verificado");
                return usuario;
            }
        }
        return null;
    }

}
