package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import factory.UsuarioListControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import listcontroller.UsuarioListController;
import model.Perfil;
import model.Sexo;
import model.Usuario;

public class UsuarioController extends Controller<Usuario> implements Initializable {

	private Usuario usuario;

	@FXML
	private TextField tfNome;

	@FXML
	private TextField tfLogin;

	@FXML
	private TextField tfSenha;

	@FXML
	private Button btLimpar;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btAlterar;

	@FXML
	private Button btIncluir;

	@FXML
	private ComboBox<Perfil> cbPerfil;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// adicionando o conteudo do combobox
		cbPerfil.getItems().addAll(Perfil.values());
		// sobreescrevendo o método que mostra o conteudo do combobox
		cbPerfil.setCellFactory(c -> new ListCell<Perfil>() {
			@Override
			protected void updateItem(Perfil item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty)
					setText(null);
				else
					setText(item.getLabel());
			}
		});
		// seobrescreendo o método que mostra o conteudo selecionado
		cbPerfil.setButtonCell(new ListCell<Perfil>() {
			@Override
			protected void updateItem(Perfil item, boolean empty) {
				super.updateItem(item, empty);

				if (item == null || empty)
					setText(null);
				else
					setText(item.getLabel());
			}
		});

		atualizarBotoes();
	}

	@FXML
	void handleIncluir(ActionEvent event) {
		getUsuario().setNome(tfNome.getText());
		getUsuario().setLogin(tfLogin.getText());
		getUsuario().setSenha(tfSenha.getText());
		getUsuario().setPerfil(cbPerfil.getValue());

		super.save(getUsuario());
		handleLimpar(event);
	}

	@FXML
	void handleAlterar(ActionEvent event) {
		getUsuario().setNome(tfNome.getText());
		getUsuario().setLogin(tfLogin.getText());
		getUsuario().setSenha(tfSenha.getText());
		getUsuario().setPerfil(cbPerfil.getValue());


		super.save(getUsuario());
		handleLimpar(event);
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		super.remove(getUsuario());
		handleLimpar(event);
	}

	@FXML
	void handleLimpar(ActionEvent event) {
		usuario = null;
		tfNome.clear();
		tfLogin.clear();
		tfSenha.clear();
		cbPerfil.setValue(null);
		atualizarBotoes();
	}

	private void atualizarBotoes() {
		btIncluir.setDisable(getUsuario().getId() != null);
		btAlterar.setDisable(getUsuario().getId() == null);
		btExcluir.setDisable(getUsuario().getId() == null);
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@FXML
	void handleMouseClickedNome(MouseEvent event) throws IOException {

		UsuarioListController listagem = UsuarioListControllerFactory.getInstance();
		listagem.abrir();
		// setando a usuario
		setUsuario(listagem.getUsuarioSelecionada());

		// atualizando a interface
		tfNome.setText(getUsuario().getNome());
		tfLogin.setText(getUsuario().getLogin());
		tfSenha.setText(getUsuario().getSenha());
		cbPerfil.setValue(getUsuario().getPerfil());

		atualizarBotoes();
	}

}
