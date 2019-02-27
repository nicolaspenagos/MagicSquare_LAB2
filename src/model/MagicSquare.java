/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* @author Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

package model;

import customExceptions.InvalidNegativeOrderMagicSquareException;
import customExceptions.PairMagicSquareException;
import javafx.scene.control.Button;

/**
 * This class represents the  MagicSquare.
 */
public class MagicSquare {
	
	//------------------------------------- 
	// Constants 
	//------------------------------------- 
	/**
	 * Start position located on the top center of the magicSquare.
	 */
	public final static String UC="Up-center";
	
	/**
 	 * Start position located on the down center of the magicSquare.
 	 */
	public final static String DC="Down-center";
	
	/**
	 * Start position located on the right center of the magicSquare.
	 */
	public final static String RC="Right-center";
	
	/**
  	 * Start position located on the left center of the magicSquare.
	 */
	public final static String LC="Left-center";
	
	/**
	 * North West way to fill and solve the magicSquare
	 */
	public final static String NO="NW";
	
	/**
	 * North East way to fill and solve the magicSquare
	 */
	public final static String NE="NE";
	
	/**
     * South West way to fill and solve the magicSquare
	 */
	public final static String SE="SE";
	
	/**
	 * South West way to fill and solve the magicSquare
	 */
	public final static String SO="SW";
	
	//-------------------------------------
	//Atributtes
	//-------------------------------------
	/**
	 * It is the size of the matrix 
	 */
	private int n;
	
	/**
	 * It is the matrix that will contain the magicSquare numbers 
	 */
	private int[][] matrix; 
	
	/**
	 * It is the result the sum of the all numbers of the matrix
	 */
	private int magicConstant;
	
	/**
	 * It represents the users choice 
	 */
	private int option;
	
	/**
	 * It the matrix that will contains the buttons of the interface 
	 */
	private Button[][] buttons; 
	
	//-------------------------------------
	//Constructor
	//-------------------------------------
	
	/** The method allows to instantiate a MagicSquare object 
     * @param nx It is the size of the magicSquare. nx != 0, nx has to be greater than 0, nx %2 != 0.
     * post: A MagicSquare object is instantiate. 
     * post: A buttons matrix is instantiate. 
     */
	public MagicSquare(int nx){
			n = nx; 
			matrix= new int[n][n];
			magicConstant=n*((n*n)+1)/2;
			option=0; 
			buttons=new Button[nx][nx];
	}
	
	//-------------------------------------
	//Getters 
	//-------------------------------------
	
	/** The method allows to obtain the buttons of the interface.
     * @return Buttons[][] the buttons matrix.
     */
	public Button[][] getButton() {
		return buttons; 
	}
	
	/** The method allows to obtain the matrix of the MagicSquare.
     * @return int[][] the matrix.
     */
	public int[][] getMatrix(){
		return matrix;
	}
	
	/** The method allows to obtain the magicConstant.
     * @return int the magicConstant atributte.
     */
	public int getMagicC() {
		return magicConstant; 
	}
	
	/** The method allows to obtain size of the matrix.
     * @return int the size of the matrix
     */
	public int getN() {
		return n; 
	}
	
	/** The method allows to obtain the option.
     * @return int option.
     */
	public int getO() {
		return option; 
	}
	//-------------------------------------
	// Setters 
	//-------------------------------------
	
	/** The method allows to set the option.
     */
	public void setO(int x) {
		option=x;
	}
	
	//-------------------------------------
	// Methods
	//-------------------------------------
	
	/** The method allows to determinate if the startPosition and the orientation are compatible, and returns an option that will be used in the fillMatrix() method.
	 * @param startPosition It is the start position of the magicSquare.
	 * @param orientation It is the orientantion of how the magicSquare will be filled.
     * @return int The option of the magicSquare.
	 * @throws PairMagicSquareException 
     */
	public int checker(String startPosition, String orientation) throws PairMagicSquareException,InvalidNegativeOrderMagicSquareException  {

		
			if(n%2==0) {
				throw new PairMagicSquareException();
			}else if(n<0) {
				throw new InvalidNegativeOrderMagicSquareException(n);
			} else {
			if(startPosition.equalsIgnoreCase(UC)) {
				if(orientation.equalsIgnoreCase(NO)) {
					option = 1; 
				}else if(orientation.equalsIgnoreCase(NE)) {
					option = 2; 
				}else {
					option = 10;
				}
			}

			if(startPosition.equalsIgnoreCase(DC)) {
				if(orientation.equalsIgnoreCase(SO)) {
					option = 3; 
				}else if(orientation.equalsIgnoreCase(SE)) {
					option = 4; 
				}else {
					option = 100;
				}
			}

			if(startPosition.equalsIgnoreCase(LC)) {
				if(orientation.equalsIgnoreCase(NO)) {
					option = 5; 
				}else if(orientation.equalsIgnoreCase(SO)) {
					option = 6; 
				}else {
					option = 1000;
				}
			}

			if(startPosition.equalsIgnoreCase(RC)) {
				if(orientation.equalsIgnoreCase(NE)) {
					option = 7; 
				}else if(orientation.equalsIgnoreCase(SE)) {
					option = 8; 
				}else {
					option = 10000;
				}
			}
		}

		return option; 
	}
	
	/** The method show the options .
	 * pre: O.
     * @return String The a message to be showed on the screen.
     */

	public String message() {
		String msg="You can not use Up-center with that orientation";
		if(option==1000000) {
			msg= "Error, (n) cannot to be pair nor one nor negative";
		}


		if(option==1||option==2||option==3||option==4||option==5||option==6||option==7||option==8) {
			msg="The solution:"; 
		}else if(option==100) {
			msg="You can not use Down-center with that orientation";
		}else if(option == 1000) {
			msg="You can not use Left-center with that orientation";
		}else if(option == 10000) {
			msg="You can not use Right-center with that orientation";
		}

		return msg; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is UP-CENTER and NO.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixUCNO() {
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0; 
		y=nx;

		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a; 
				a++;
			}else {
				x=xB+1;
				y=yB;
				
				if(x<0) {

					x=n-1; 
					xB=x;
				}
				if(n-1<x) {

					x=0; 
					xB=x;
				}					
				solvedMatrix[x][y]=a;
				a++;
			}
			
			xB=x;
			yB=y;
			x--;
			y--; 

			if(x<0) {
				x=n-1; 
			}
			if(y<0) {
				y=n-1;
			}

			if(n-1<x) {
				x=0; 
			}
			if(n-1<y) {
				y=0;
			}		
		}
		
		return solvedMatrix; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is UP-CENTER and NE.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixUCNE(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0; 
		

		y=nx; 
		
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB+1][yB]==0) {
					x=xB+1;
					y=yB;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x--;
			y++;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
			
			
		}
	
		
		return solvedMatrix; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is DOWN-CENTER and SO.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixDCSO(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0; 
		
		y=nx;
		x=n-1;
		
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB-1][yB]==0) {
					x=xB-1;
					y=yB;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x++;
			y--;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix; 
	}

	/** The method fills the matrix with the solution of the magicSquare when the orientation is DOWN-CENTER and SE.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixDCSE(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0;
		
		y=nx;
		x=n-1;
		
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB-1][yB]==0) {
					x=xB-1;
					y=yB;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x++;
			y++;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is LEFT-CENTER and NO.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixLCNO(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0;
		x=nx;	
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB][yB+1]==0) {
					x=xB;
					y=yB+1;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x--;
			y--;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix;
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is LEFT-CENTER and SO.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixLCSO(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0;
		
		x=nx;	
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB][yB+1]==0) {
					x=xB;
					y=yB+1;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x++;
			y--;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is RIGHT-CENTER and NE.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixRCNE(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0;
		
		x=nx;
		y=n-1;
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB][yB-1]==0) {
					x=xB;
					y=yB-1;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x--;
			y++;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix; 
	}
	
	/** The method fills the matrix with the solution of the magicSquare when the orientation is RIGHT-CENTER and SE.
	 * pre: matrix != null.
     * @return int[][] A matrix with the soutions of the magicSquare.
     */
	public int[][] fillMatrixRCSE(){
		int[][] solvedMatrix=matrix; 
		int a=1;
		int x=0;
		int y=0;
		int nx=((int) (n/2+0.5));
		int xB=0;
		int yB=0;
		x=nx;
		y=n-1;
		while(a<=n*n) {
			if(solvedMatrix[x][y]==0) {
				solvedMatrix[x][y]=a;
				a++;
			}else {
				if(solvedMatrix[xB][yB-1]==0) {
					x=xB;
					y=yB-1;
					if(x<0) {
						x=n-1;
					}
					if(n-1<x) {
						x=0;
					}
					solvedMatrix[x][y]=a;
					a++;
				}
			}
			xB=x;
			yB=y;
			x++;
			y++;
			
			if(x<0) {
				x=n-1;
			}
			if(n-1<x) {
				x=0;
			}
			if(y<0) {
				y=n-1;
			}
			if(n-1<y) {
				y=0;
			}
		}
		return solvedMatrix; 
	}
		
	
	/** The method helps the solveButton in controller class to know either deploy a matrix or not.
     * @return boolean true for yes, false for not. 
     */
	public boolean ok() {
		boolean isOk=(option==0||option==10||option==100||option==1000||option==10000||option==1000000)?false:true;;
		return isOk;
	}


}