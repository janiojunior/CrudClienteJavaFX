package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/CadastroCidade.fxml"));
		
		Scene scene = new Scene(root, 600, 600);
		
		primaryStage.setTitle("Cadastro de Cidade");
		primaryStage.setScene(scene);
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
