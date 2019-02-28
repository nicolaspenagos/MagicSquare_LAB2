/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* @author Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

package customExceptions;

/**
 * This class represents the custom exception PairMagicSquareException created for the correct operarion of the project MagicSquare.
 */
@SuppressWarnings("serial")
public class PairMagicSquareException extends Exception{
	//-------------------------------------
	//Constructor
	//-------------------------------------
	
	/**
   	* This method allows to instantiate PairMagicSquareException
    */
	public PairMagicSquareException(){
		super("The order of the magic square cannot be pair");
	}
}
