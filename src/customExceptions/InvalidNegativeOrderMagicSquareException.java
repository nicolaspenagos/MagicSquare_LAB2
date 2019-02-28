/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* @author Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

package customExceptions;

/**
 * This class represents the custom exception InvalidNegativeOrderMagicSquareException created for the correct operarion of the project MagicSquare.
 */
@SuppressWarnings("serial")
public class InvalidNegativeOrderMagicSquareException extends Exception{
	
	//-------------------------------------
	//Constructor
	//-------------------------------------
	
	/**
   	* This method allows to instantiate InvalidNegativeOrderMagicSquareException
    */
	public InvalidNegativeOrderMagicSquareException(int x) {
		super(x+"is a negative number and cannot be an order of a magicSquare");
	}
	
}
