package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	private static BorderPane root;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void trocaTela(int numero) throws IOException {
		Parent clienteView = null;
		if (numero == 1) {
			clienteView = FXMLLoader.load(Main.class.getResource("/view/CadastroCliente.fxml"));
		} else if (numero == 2) {
			clienteView = FXMLLoader.load(Main.class.getResource("/view/CadastroCidade.fxml"));
		}
		
		// adicionando a tela inicial no template (parte central)
		ScrollPane scroll = (ScrollPane) root.getChildren().get(3);
		scroll.setFitToHeight(true);
		scroll.setFitToWidth(true);
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().add(clienteView);
		scroll.setContent(vbox);
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		root = FXMLLoader.load(getClass().getResource("/view/Template.fxml"));
		
		Parent clienteView = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
		
		// adicionando a tela inicial no template (parte central)
		ScrollPane scroll = (ScrollPane) root.getChildren().get(3);
		scroll.setFitToHeight(true);
		scroll.setFitToWidth(true);
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().add(clienteView);
		scroll.setContent(vbox);
		
		
		Scene scene = new Scene(root, 600, 600);
		
		primaryStage.setTitle("Cadastro de Cidade");
		primaryStage.setScene(scene);
		
		//Full Screen
//		primaryStage.setFullScreen(true);
		primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
		primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
		
		primaryStage.show();
	}

//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		
//		AnchorPane root = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
//		
//		Scene scene = new Scene(root, 600, 600);
//		
//		primaryStage.setTitle("CRUD de Clientes");
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}

}
