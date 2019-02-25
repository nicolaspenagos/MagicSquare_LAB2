/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* Author: Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

package userinterface;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import model.MagicSquare;

/**
* This class represents the  MagicSquare Controller.
*/
public class MagicSquareController {
	
	
	/**
	 * Is association with the MagicSquare of the controller
	 */
	private MagicSquare mS1; 
	
    @FXML // fx:id="splitPane"
    private SplitPane splitPane; // Value injected by FXMLLoader

    @FXML // fx:id="txtF1"
    private TextField txtF1;// Value injected by FXMLLoader

    @FXML // fx:id="comboBox1"
    private ComboBox<?> comboBox1;// Value injected by FXMLLoader

    @FXML // fx:id="comboBox2"
    private ComboBox<?> comboBox2;// Value injected by FXMLLoader

    @FXML // fx:id="lbResult"
    private Label lbResult;// Value injected by FXMLLoader
    
    @FXML // fx:id="scrollPane"
    private ScrollPane scrollPane;// Value injected by FXMLLoader
    
    @FXML // fx:id="lbMC"
    private Label lbMC;// Value injected by FXMLLoader
    
    /**
	 * Is empty grid that will be desplayed.
	 */
    GridPane grid1=new GridPane();
    
    /**
   	 * Is grid that will be desplayed with the solution of the MagicSquare.
   	 */
    GridPane grid = new GridPane();
    
    /**
   	 * Is the method that will show the the solution on the sceen.
   	 * pre: grid2 != null.
   	 * pre: grid scrollPane != null.
   	 * pre: comboBox1 != null.
   	 * pre: comboBox2 != null.
   	 * pre: mS1 != null.
   	 * pre: lbResult != null.
   	 * pre: lbMC != null.
   	 * @param event. It is when the user press the button.
   	 */
    @FXML
    void solveButton(ActionEvent event) {
    	GridPane grid2=new GridPane();
    	grid=grid2;
    	scrollPane.setContent(grid1);
    	int matrixSize = Integer.parseInt(txtF1.getText());
    	String option1 = String.valueOf(comboBox1.getValue());
    	String option2 = String.valueOf(comboBox2.getValue()); 
    	mS1 = new MagicSquare(matrixSize);
    	mS1.checker(option1, option2);
    	lbResult.setText(mS1.message());
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setHgap(10);
    	grid.setGridLinesVisible(true);
    	boolean pair=(matrixSize%2==0)?true:false; 
    
    	
    	if(!pair&&mS1.ok()) {
    		lbMC.setText("The magic constant is: "+mS1.getMagicC());
	    	for(int i=0; i<matrixSize; i++) {
	    		grid.addRow(i);
	    		grid.addColumn(i);
	    	}
	 		int[][] m=null;
	 		
	    	if(option1.equals(MagicSquare.UC)&&option2.equals(MagicSquare.NO)) {
	    		m = mS1.fillMatrixUCNO();
	    	}else if(option1.equals(MagicSquare.UC)&&option2.equals(MagicSquare.NE)){
	    		m = mS1.fillMatrixUCNE();
	    	}else if(option1.equals(MagicSquare.DC)&&option2.equals(MagicSquare.SO)) {
	    		m = mS1.fillMatrixDCSO();
	    	}else if(option1.equals(MagicSquare.DC)&&option2.equals(MagicSquare.SE)) {
	    		m = mS1.fillMatrixDCSE();
	    	}else if(option1.equals(MagicSquare.LC)&&option2.equals(MagicSquare.NO)) {
	    		m=mS1.fillMatrixLCNO();
	    	}else if(option1.equals(MagicSquare.LC)&&option2.equals(MagicSquare.SO)) {
	    		m=mS1.fillMatrixLCSO();
	    	}else if(option1.equals(MagicSquare.RC)&&option2.equals(MagicSquare.NE)) {
	    		m=mS1.fillMatrixRCNE();
	    	}else if(option1.equals(MagicSquare.RC)&&option2.equals(MagicSquare.SE)) {
	    		m=mS1.fillMatrixRCSE();
	    	}
	    
	    	for(int i=0; i<matrixSize; i++) {
	    		
	    		for(int j=0; j<matrixSize; j++){
	    			Button bx=new Button(); 
	    			bx.setAlignment(Pos.CENTER);
	    			bx.setId(i+" "+j);
	    			mS1.getButton()[i][j]=bx; 
	    			bx.setOnMousePressed(new EventHandler<Event>() {

						@Override
						public void handle(Event arg0) {
							
							changeColor(bx.getId());
						}
	    				
	    			});
	    			grid.add(bx, j, i);
	    			bx.setText(""+m[i][j]);
	    		}
	    	} 
	    	scrollPane.setContent(grid);
	    	
    	}else{
    		lbMC.setText(" ");
    		
    	    scrollPane.setContent(grid1);
    	}
    }
    
    /** The method allows to change the color of the row and column selected 
     * pre: msB != null
     * @param nBx It is a string that contains the positions of the button 
     */
    public void changeColor(String nBx) {
    	String[] parts=nBx.split(" ");
    	int ii=Integer.parseInt(parts[0]); 
    	int jj=Integer.parseInt(parts[1]); 
    	Button[][] msB=mS1.getButton();
    	
    	for(int i=0; i<msB.length; i++) {
    		msB[ii][i].setStyle("-fx-background-color: #00ff00");
    	}
    	
    	for(int i=0; i<msB.length; i++) {
    		msB[i][jj].setStyle("-fx-background-color: #00ff00");
    	}
    	int y=msB.length;
    	grid.addRow(y);
    	grid.addColumn(y);
    	Label lb=new Label("= "+mS1.getMagicC()+" ");
    	Label lb1=new Label("= "+mS1.getMagicC()+" ");
    	grid.add(lb, jj, y);
    	grid.add(lb1, y, ii);
    }

}