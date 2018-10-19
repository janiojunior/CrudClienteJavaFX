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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cidade;
import model.Cliente;
import repository.CidadeRepository;
import repository.ClienteRepository;

public class CidadeListController implements Initializable {

	private Cidade cidade;
	private Stage stage;
	private Parent parent;

	@FXML
	private TableView<Cidade> tvListagem;

	@FXML
	private TableColumn<Cidade, Integer> tcId;

	@FXML
	private TableColumn<Cidade, String> tcNome;

	@FXML
	private TableColumn<Cidade, String> tcEstado;

	@FXML
	private TableColumn<Cidade, String> tcPais;

	@FXML
	private Label lbNome;

	@FXML
	private TextField tfPesquisar;

	@FXML
	private Button btPesquisar;
	
	public void abrir() {
    	stage = new Stage();
		Scene scene = new Scene(parent, 600, 500);
		stage.setTitle("Consulta de Cidade");
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// configurando as colunas das tabelas conforme os atributos da classe Cidade
		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		tcPais.setCellValueFactory(new PropertyValueFactory<>("pais"));

	}

	@FXML
	void handleMouseClicked(MouseEvent event) {
		// verificando se eh o botao principal
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			// verificando a quantidade de cliques
			if (event.getClickCount() == 2) {
				//preenche a cidade 
				cidade = tvListagem.getSelectionModel().getSelectedItem();
				// fechar a tela
				getStage().close();
			}
		}
	}
	
	public Cidade getCidadeSelecionada() {
		return cidade;
	}

	@FXML
	void handlePesquisar(ActionEvent event) {
		
		CidadeRepository repository = 
				new CidadeRepository(JPAFactory.getEntityManager());
		List<Cidade> lista = repository.getCidades(tfPesquisar.getText());
		
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
