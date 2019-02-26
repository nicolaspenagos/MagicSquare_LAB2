package customExceptions;

@SuppressWarnings("serial")
public class PairMagicSquareException extends Exception{
	public PairMagicSquareException(){
		super("The order of the magic square cannot be pair");
	}
}
