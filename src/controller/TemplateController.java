package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Perfil;

public class TemplateController implements Initializable {
	public static Parent clienteView;
	public static Parent cidadeView;
	
    @FXML
    private ScrollPane scrollPane;
    
    @FXML
    private Label labelUsuario;

    @FXML
    private Button buttonCadastroCliente;

    @FXML
    private Button buttonCadastroCidade;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// abrindo a tela de login
		abrirTelaLogin();
		
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		try {
			cidadeView = FXMLLoader.load(Main.class.getResource("/view/CadastroCidade.fxml"));
			clienteView = FXMLLoader.load(Main.class.getResource("/view/CadastroCliente.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void abrirTelaLogin() {
		try {
	    	Stage stage = new Stage(StageStyle.TRANSPARENT);
	    	Parent parent = FXMLLoader.load(Main.class.getResource("/view/Login.fxml"));
	    	Scene scene = new Scene(parent, 600, 318);
	    	stage.setTitle("Login");
	    	stage.setScene(scene);
	    	stage.initModality(Modality.APPLICATION_MODAL);
	    	stage.showAndWait();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// atualizando a interface com o usuario logado
		labelUsuario.setText(Controller.getUsuarioLogado().getNome());
		
		// bloqueando botoes de conforme o perfil
		if (Controller.getUsuarioLogado().getPerfil().equals(Perfil.ADMINISTRADOR)) {
			buttonCadastroCidade.setDisable(false);
			buttonCadastroCliente.setDisable(false);
		} else if (Controller.getUsuarioLogado().getPerfil().equals(Perfil.CADASTRO)) {
			buttonCadastroCidade.setDisable(true); // desabilitando o cadastro de cidade
			buttonCadastroCliente.setDisable(false);
		}
		
	}

	@FXML
	void handleCidade(ActionEvent event) throws IOException {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().add(cidadeView);
		scrollPane.setContent(vbox);
	}

	@FXML
	void handleCliente(ActionEvent event) throws IOException {
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().add(clienteView);
		scrollPane.setContent(vbox);
	}
	
    @FXML
    void handleBloquear(ActionEvent event) {
    	abrirTelaLogin();
    }

}
