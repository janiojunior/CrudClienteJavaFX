package factory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import listcontroller.CidadeListController;

public class CidadeListControllerFactory {
	
	public static CidadeListController getInstance() throws IOException {
    	FXMLLoader loader = new FXMLLoader(CidadeListControllerFactory.class.getResource("/view/ListagemCidade.fxml"));
    	Parent root = loader.load();
    	
    	// obtendo o controlador 
    	CidadeListController listagem = loader.getController();
    	listagem.setParent(root);
    	
    	return listagem;
	}

}
