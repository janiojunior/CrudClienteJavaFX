package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TemplateController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	void handleCidade(ActionEvent event) throws IOException {
		Main.trocaTela(2);
	}

	@FXML
	void handleCliente(ActionEvent event) throws IOException {
		Main.trocaTela(1);
	}
}
