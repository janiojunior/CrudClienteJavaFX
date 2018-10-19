package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import factory.CidadeListControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import listcontroller.CidadeListController;
import model.Cidade;

public class CidadeController extends Controller<Cidade> implements Initializable{
	
	private Cidade cidade;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEstado;

    @FXML
    private TextField tfPais;
    
    @FXML
    private Button btLimpar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btAlterar;

    @FXML
    private Button btIncluir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		atualizarBotoes();
	}
    
    
    @FXML
    void handleIncluir(ActionEvent event) {
		getCidade().setNome(tfNome.getText());
		getCidade().setEstado(tfEstado.getText());
		getCidade().setPais(tfPais.getText());

		super.save(getCidade());
		handleLimpar(event);    	
    }
    
    @FXML
    void handleAlterar(ActionEvent event) {
		getCidade().setNome(tfNome.getText());
		getCidade().setEstado(tfEstado.getText());
		getCidade().setPais(tfPais.getText());

		super.save(getCidade());
		handleLimpar(event);    
    }

    @FXML
    void handleExcluir(ActionEvent event) {
    	super.remove(getCidade());
    	handleLimpar(event);  
    }


    @FXML
    void handleLimpar(ActionEvent event) {
    	cidade = null;
    	tfNome.clear();
    	tfEstado.clear();
    	tfPais.clear();
    	atualizarBotoes();
    }
    
	private void atualizarBotoes() {
		btIncluir.setDisable(getCidade().getId() != null);
		btAlterar.setDisable(getCidade().getId() == null);
		btExcluir.setDisable(getCidade().getId() == null);
	}

	public Cidade getCidade() {
		if (cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
    @FXML
    void handleMouseClickedNome(MouseEvent event) throws IOException {
    	
    	CidadeListController listagem = CidadeListControllerFactory.getInstance();
    	listagem.abrir();
		// setando a cidade
		setCidade(listagem.getCidadeSelecionada());
    	
    	
		// atualizando a interface
		tfNome.setText(getCidade().getNome());
		tfEstado.setText(getCidade().getEstado());
		tfPais.setText(getCidade().getPais());

		atualizarBotoes();
    }


}
