package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Util;
import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Perfil;
import model.Usuario;
import repository.UsuarioRepository;

public class LoginController extends Controller<Usuario> implements Initializable{

	@FXML
    private TextField tfUsuario;

    @FXML
    private PasswordField tfSenha;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void handleCancelar(ActionEvent event) {
    	System.exit(-1);
    }

    @FXML
    void handleEntrar(ActionEvent event) {
    	
    	UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
    	Usuario usuario = repository.getUsuario(tfUsuario.getText(), 
    											Util.encrypt(tfSenha.getText()));
    	if (usuario == null) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Aviso");
    		alert.setHeaderText(null);
    		alert.setContentText("Usuário ou Senha Invalido.");
    		alert.showAndWait();
    	} else { 
	    	// setando o usuario logado
	    	Controller.setUsuarioLogado(usuario);
	    	
	    	Button button = (Button) event.getSource();
	    	Stage stage = (Stage)button.getScene().getWindow();
	    	stage.close();
    	}
    }

	@Override
	public boolean validate() {
		return true;
	}

}
