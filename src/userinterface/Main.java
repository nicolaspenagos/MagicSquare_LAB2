/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* @author Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

package userinterface;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
* This class represents the  Main.
*/
public class Main extends Application{
	
	/** Is is the main method
	* @param args.
	*/
	public static void main(String[] args) {
		launch(args);

	}
	
	/** Is is the method that loads the fxml file on the screens.
	* @param stage.
	*/
	@Override
	public void start(Stage stage) throws Exception {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("MagicSquare3.fxml"));
		Scene scene = new Scene(root); 
		stage.setTitle("MagicSquare");
		stage.setScene(scene);
		stage.show(); 
		}catch(NullPointerException e){
			System.out.print("The fxml file does not exit");
		}
		
	}

}