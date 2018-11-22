package listcontroller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioListController implements Initializable {

	private Usuario usuario;
	private Stage stage;
	private Parent parent;

	@FXML
	private TableView<Usuario> tvListagem;

	@FXML
	private TableColumn<Usuario, Integer> tcId;

	@FXML
	private TableColumn<Usuario, String> tcNome;

	@FXML
	private TableColumn<Usuario, String> tcLogin;

	@FXML
	private TableColumn<Usuario, String> tcSenha;
	
	@FXML
	private TableColumn<Usuario, String> tcPerfil;

	@FXML
	private Label lbNome;

	@FXML
	private TextField tfPesquisar;

	@FXML
	private Button btPesquisar;
	
	public void abrir() {
    	stage = new Stage();
		Scene scene = new Scene(parent, 600, 600);
		stage.setTitle("Consulta de Usuario");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// configurando as colunas das tabelas conforme os atributos da classe Usuario
		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
		tcSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		tcPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));

	}

	@FXML
	void handleMouseClicked(MouseEvent event) {
		// verificando se eh o botao principal
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// verificando a quantidade de cliques
			if (event.getClickCount() == 2) {
				//preenche a usuario 
				usuario = tvListagem.getSelectionModel().getSelectedItem();
				// fechar a tela
				getStage().close();
			}
		}
	}
	
	public Usuario getUsuarioSelecionada() {
		return usuario;
	}

	@FXML
	void handlePesquisar(ActionEvent event) {
		
		UsuarioRepository repository = 
				new UsuarioRepository(JPAFactory.getEntityManager());
		List<Usuario> lista = repository.getUsuarios(tfPesquisar.getText());
		
		if (lista.isEmpty()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("Informação");
			alerta.setHeaderText(null);
			alerta.setContentText("A consulta não retornou dados.");
			alerta.show();
		}
		tvListagem.setItems(FXCollections.observableList(lista));

	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
}
