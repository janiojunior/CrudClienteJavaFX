package factory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import listcontroller.UsuarioListController;

public class UsuarioListControllerFactory {
	
	public static UsuarioListController getInstance() throws IOException {
    	FXMLLoader loader = new FXMLLoader(UsuarioListControllerFactory.class.getResource("/view/ListagemUsuario.fxml"));
    	Parent root = loader.load();
    	
    	// obtendo o controlador 
    	UsuarioListController listagem = loader.getController();
    	listagem.setParent(root);
    	
    	return listagem;
	}

}