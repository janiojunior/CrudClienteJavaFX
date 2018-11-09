package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Perfil;
import model.Usuario;

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
    	// Construir um Repositorio ( UsuarioRepository.java )
    	// public Usuario verificarLogin(String usuario, String senha)
    	
    	//retornou um usuario
    	Usuario usuario = new Usuario();
    	usuario.setNome("Joao da Silva");
    	usuario.setPerfil(Perfil.CADASTRO);
    	
    	// setando o usuario logado
    	Controller.setUsuarioLogado(usuario);
    	
    	Button button = (Button) event.getSource();
    	Stage stage = (Stage)button.getScene().getWindow();
    	stage.close();
    	
    }

}
