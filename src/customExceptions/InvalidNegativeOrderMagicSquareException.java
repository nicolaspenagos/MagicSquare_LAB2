package customExceptions;

@SuppressWarnings("serial")
public class InvalidNegativeOrderMagicSquareException extends Exception{
	public InvalidNegativeOrderMagicSquareException(int x) {
		super(x+"is a negative number and cannot be an order of a magicSquare");
	}
	
}
