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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class TemplateController implements Initializable {
	public static Parent clienteView;
	public static Parent cidadeView;
	
    @FXML
    private ScrollPane scrollPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		try {
			cidadeView = FXMLLoader.load(Main.class.getResource("/view/CadastroCidade.fxml"));
			clienteView = FXMLLoader.load(Main.class.getResource("/view/CadastroCliente.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
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
}
