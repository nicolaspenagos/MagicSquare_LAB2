/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Universidad Icesi (Cali-Colombia)
* Algoritmos y porgramcion II
* @author Nicolas Penagos Montoya
* Java SE Development Kit 8 Update 121
**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import customExceptions.InvalidNegativeOrderMagicSquareException;
import customExceptions.PairMagicSquareException;

import java.util.Arrays;
import javafx.scene.control.Button;
import model.MagicSquare;

/**
 * This class is for test the MagicSquare class.
 */
class MagicSquareTest{
	
	private MagicSquare newMagicSquare; 
	
	//-------------------------------------
	// Scenarios
	//-------------------------------------
	
	/**
	 * This scenary is null, is going to be used for test the contructor in MagicSquare class.
	 */
	private void setUpScenary1() {
		
	}
	
	/**
	 * This scenary intances a magicSqaure object of order 3 .
	 */
	private void setUpScenary2() {
		int order=3;
		newMagicSquare = new MagicSquare(order);
	}
	
	/**
	 * This scenary intances a magicSqaure object of order 5 .
	 */
	private void setUpScenary3() {
		int order=5;
		newMagicSquare = new MagicSquare(order);
	}
	
	/**
	 * This scenary intances a magicSqaure object of order 7.
	 */
	private void setUpScenary4() {
		int order=7;
		newMagicSquare = new MagicSquare(order);
	}
	
	/**
	 * This scenary intances a magicSqaure object of order pair(2).
	 */
	private void setUpScenary5() {
		int order=2;
		newMagicSquare = new MagicSquare(order);
	}
	
	//-------------------------------------
	// ConstructorTest
	//-------------------------------------
	
	/**
	 * This method test if the constructor in magicSquare class, it checks if each value is assigned correctly.
	 */
	@Test
	void testMagicSquare() {
		setUpScenary1(); 
		int n=3;
		int magicSquareConstant = n*((n*n)+1)/2;
		int firstOption=0;
		MagicSquare newMagicSquare = new MagicSquare(n);
		assertNotNull("The new MagicSquare obcjet is null", newMagicSquare); 
		assertTrue("The n value of the matrix has the wrong value", n==newMagicSquare.getN());
		assertTrue("The lenght of the matrix has the wrong value", newMagicSquare.getMatrix().length==n&&newMagicSquare.getMatrix()[0].length==n);
		assertTrue("The magicConstnat has the wrong value", newMagicSquare.getMagicC()==magicSquareConstant);
		assertTrue("The option has the wrong value", newMagicSquare.getO()==firstOption);
		assertTrue("The matrix of buttons has the wrong size", newMagicSquare.getButton().length==n&&newMagicSquare.getButton()[0].length==n);
	}
	
	//-------------------------------------
	// GetterTests
	//-------------------------------------
	
	/**
	 * This method test if the get method is returning the correct value.
	 */
	@Test
	void testGetButton() {
		setUpScenary2(); 
		Button[][] bx = new Button[3][3];
		assertTrue("The getButton() method is returning the worng value", Arrays.deepEquals(bx,newMagicSquare.getButton()));
	}
	
	/**
	 * This method test if the get method is returning the correct value.
	 */
	@Test
	void testGetMatrix() {
		setUpScenary2(); 
		int[][] mx= new int[3][3];
		assertTrue("The getMatrix() method is returning the worng value", Arrays.deepEquals(mx,newMagicSquare.getMatrix()));
	}

	/**
	 * This method test if the get method is returning the correct value.
	 */
	@Test
	void testGetMagicC() {
		setUpScenary2(); 
		int gMc=3*((3*3)+1)/2;
		assertTrue("The getMatrix() method is returning the worng value", gMc==newMagicSquare.getMagicC());
	}
	
	/**
	 * This method test if the get method is returning the correct value.
	 */
	@Test
	void testGetN() {
		setUpScenary2(); 
		int n=3;
		assertTrue("The getMatrix() method is returning the worng value", n==newMagicSquare.getN());
	}
	
	/**
	 * This method test if the get method is returning the correct value.
	 */
	@Test
	void testGetO() {
		setUpScenary2(); 
		int option=0;
		assertTrue("The getMatrix() method is returning the worng value", option==newMagicSquare.getO());
	}
	
	//-------------------------------------
	// Setters
	//-------------------------------------
	
	/**
	 * This method test if the set method changing the value the correctly.
	 */
	@Test
	void testSetO(){
		setUpScenary2(); 
		int x=333;
		newMagicSquare.setO(x);
		assertTrue("The set method did not change the option correctly", newMagicSquare.getO()==x);
	}
	//-------------------------------------
	// MethodTests
	//-------------------------------------
	
	/**
	 * This method test if the checker method is assigning the correct option for a no pair magicSquare .
	 */
	@Test
	void testChecker() {
		
		setUpScenary2();
		try {
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker("xxx",MagicSquare.SE)==0);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.UC,MagicSquare.NO)==1);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.UC,MagicSquare.NE)==2);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.UC,"xxx")==10);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.DC,MagicSquare.SO)==3);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.DC,MagicSquare.SE)==4);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.DC,"xxx")==100);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.LC,MagicSquare.NO)==5);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.LC,MagicSquare.SO)==6);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.LC,"xxx")==1000);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.RC,MagicSquare.NE)==7);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.RC,MagicSquare.SE)==8);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.RC,"xxx")==10000);
		}catch(PairMagicSquareException e) {
    		System.out.println(""+e.getMessage());
    	}catch(InvalidNegativeOrderMagicSquareException e) {
    		System.out.println(""+e.getMessage());
    	}
		
		
	}
	
	/**
	 * This method test if the checker method is assigning the correct option for a no pair magicSquare .
	 */
	@Test
	void testCheker1() {
		setUpScenary5();
		try {
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.UC,MagicSquare.NO)==1000000);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.UC,MagicSquare.NE)==1000000);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.DC,MagicSquare.SO)==1000000);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.DC,MagicSquare.SE)==1000000);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.LC,MagicSquare.NO)==1000000);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.LC,MagicSquare.SO)==1000000);
		
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.RC,MagicSquare.NE)==1000000);
		assertTrue("The method checker is returning the wrong option", newMagicSquare.checker(MagicSquare.RC,MagicSquare.SE)==1000000);
		}catch(PairMagicSquareException e) {
    		System.out.println(""+e.getMessage());
    	}catch(InvalidNegativeOrderMagicSquareException e) {
    		System.out.println(""+e.getMessage());
    	}
	}
	
	/**
	 * This method test if the message method is assigning the correct message.
	 */
	@Test
	void testMessage() {
		setUpScenary2();
		newMagicSquare.setO(1000000);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("Error, (n) cannot to be pair nor one "));
		newMagicSquare.setO(1);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(2);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(3);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(4);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(5);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(6);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(7);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(8);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("The solution:"));
		newMagicSquare.setO(100);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("You can not use Down-center with that orientation"));
		newMagicSquare.setO(1000);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("You can not use Left-center with that orientation"));
		newMagicSquare.setO(10000);
		assertTrue("The method is returning the wrong message", newMagicSquare.message().equals("You can not use Right-center with that orientation"));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-West orientation for a 3x3 MagicSuqare.
	 */
	@Test 
	void testFillMatrixUCNO3() {
		setUpScenary2();
		int[][] expected = {{6,1,8},{7,5,3},{2,9,4}};
		int[][] obtained = newMagicSquare.fillMatrixUCNO();
		
		assertTrue("The result of the solved matrix for 3x3 UP CENTER NORTH-WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
		
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-West orientation for a 5x5 MagicSuqare..
	 */
	@Test 
	void testFillMatrixUCNO5() {
		setUpScenary3();
		int[][] expected = {{15,8,1,24,17},{16,14,7,5,23},{22,20,13,6,4},{3,21,19,12,10},{9,2,25,18,11}};
		int[][] obtained = newMagicSquare.fillMatrixUCNO();
		
		assertTrue("The result of the solved matrix for 5x5 UP CENTER NORTH-WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
		
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-West orientation for a 7x7 MagicSuqare.
	 */
	@Test 
	void testFillMatrixUCNO7() {
		setUpScenary4();
		int[][] expected = {{28,19,10,1,48,39,30},{29,27,18,9,7,47,38},{37,35,26,17,8,6,46},{45,36,34,25,16,14,5},{4,44,42,33,24,15,13},{12,3,43,41,32,23,21},{20,11,2,49,40,31,22}};
		int[][] obtained = newMagicSquare.fillMatrixUCNO();
		
		assertTrue("The result of the solved matrix for 7x7 UP CENTER NORTH-WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
		
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-East orientation for a 3x3 MagicSuqare.
	 */
	@Test 
	void testFillMatrixUCNE3() {
		setUpScenary2();
		int[][] expected = {{8,1,6},{3,5,7},{4,9,2}};
		int[][] obtained = newMagicSquare.fillMatrixUCNE();
		
		assertTrue("The result of the solved matrix for 3x3 UP CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-East orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixUCNE5() {
		setUpScenary3();
		int[][] expected = {{17,24,1,8,15},{23,5,7,14,16},{4,6,13,20,22},{10,12,19,21,3},{11,18,25,2,9}};
		int[][] obtained = newMagicSquare.fillMatrixUCNE();
		
		assertTrue("The result of the solved matrix for 5x5 UP CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Up-Center position with North-East orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixUCNE7() {
		setUpScenary4();
		int[][] expected = {{30,39,48,1,10,19,28},{38,47,7,9,18,27,29},{46,6,8,17,26,35,37},{5,14,16,25,34,36,45},{13,15,24,33,42,44,4},{21,23,32,41,43,3,12},{22,31,40,49,2,11,20}};
		int[][] obtained = newMagicSquare.fillMatrixUCNE();
		
		assertTrue("The result of the solved matrix for 7x7 UP CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-West orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSO3() {
		setUpScenary2();
		int[][] expected = {{2,9,4},{7,5,3},{6,1,8}};
		int[][] obtained = newMagicSquare.fillMatrixDCSO();
		
		assertTrue("The result of the solved matrix for 3x3 DOWN-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-West orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSO5() {
		setUpScenary3();
		int[][] expected = {{9,2,25,18,11},{3,21,19,12,10},{22,20,13,6,4},{16,14,7,5,23},{15,8,1,24,17}};
		int[][] obtained = newMagicSquare.fillMatrixDCSO();
		
		assertTrue("The result of the solved matrix for 5X5 DOWN-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-West orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSO7() {
		setUpScenary4();
		int[][] expected = {{20,11,2,49,40,31,22},{12,3,43,41,32,23,21},{4,44,42,33,24,15,13},{45,36,34,25,16,14,5},{37,35,26,17,8,6,46},{29,27,18,9,7,47,38},{28,19,10,1,48,39,30}};
		int[][] obtained = newMagicSquare.fillMatrixDCSO();
		
		assertTrue("The result of the solved matrix for 7x7 DOWN-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-East orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSE3() {
		setUpScenary2();
		int[][] expected = {{4,9,2},{3,5,7},{8,1,6}};
		int[][] obtained = newMagicSquare.fillMatrixDCSE();
		
		assertTrue("The result of the solved matrix for 3x3 UP DOWN-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-East orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSE5() {
		setUpScenary3();
		int[][] expected = {{11,18,25,2,9},{10,12,19,21,3},{4,6,13,20,22},{23,5,7,14,16},{17,24,1,8,15}};
		int[][] obtained = newMagicSquare.fillMatrixDCSE();
		
		assertTrue("The result of the solved matrix for 5X5 UP DOWN-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Down-Center position with South-East orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixDCSE7() {
		setUpScenary4();
		int[][] expected = {{22,31,40,49,2,11,20},{21,23,32,41,43,3,12},{13,15,24,33,42,44,4},{5,14,16,25,34,36,45},{46,6,8,17,26,35,37},{38,47,7,9,18,27,29},{30,39,48,1,10,19,28}};
		int[][] obtained = newMagicSquare.fillMatrixDCSE();
		
		assertTrue("The result of the solved matrix for 7X7 UP DOWN-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));

	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with South-East orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCSE3() {
		setUpScenary2();
		int[][] expected = {{4,3,8},{9,5,1},{2,7,6}};
		int[][] obtained = newMagicSquare.fillMatrixRCSE();
		
		assertTrue("The result of the solved matrix for 3x3 UP RIGHT-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));	
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with South-East orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCSE5() {
		setUpScenary3();
		int[][] expected = {{11,10,4,23,17},{18,12,6,5,24},{25,19,13,7,1},{2,21,20,14,8},{9,3,22,16,15}};
		int[][] obtained = newMagicSquare.fillMatrixRCSE();
		
		assertTrue("The result of the solved matrix for 5x5 UP RIGHT-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with South-East orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCSE7() {
		setUpScenary4();
		int[][] expected = {{22,21,13,5,46,38,30},{31,23,15,14,6,47,39},{40,32,24,16,8,7,48},{49,41,33,25,17,9,1},{2,43,42,34,26,18,10},{11,3,44,36,35,27,19},{20,12,4,45,37,29,28}};
		int[][] obtained = newMagicSquare.fillMatrixRCSE();
		
		assertTrue("The result of the solved matrix for 7x7 UP RIGHT-CENTER SOUTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with North-East orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCNE3() {
		setUpScenary2();
		int[][] expected = {{2,7,6},{9,5,1},{4,3,8}};
		int[][] obtained = newMagicSquare.fillMatrixRCNE();
		
		assertTrue("The result of the solved matrix for 3x3 UP RIGHT-CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with North-East orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCNE5() {
		setUpScenary3();
		int[][] expected = {{9,3,22,16,15},{2,21,20,14,8},{25,19,13,7,1},{18,12,6,5,24},{11,10,4,23,17}};
		int[][] obtained = newMagicSquare.fillMatrixRCNE();
		
		assertTrue("The result of the solved matrix for 5x5 UP RIGHT-CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Right-Center position with North-East orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixRCNE7() {
		setUpScenary4();
		int[][] expected = {{20,12,4,45,37,29,28},{11,3,44,36,35,27,19},{2,43,42,34,26,18,10},{49,41,33,25,17,9,1},{40,32,24,16,8,7,48},{31,23,15,14,6,47,39},{22,21,13,5,46,38,30}};
		int[][] obtained = newMagicSquare.fillMatrixRCNE();
		
		assertTrue("The result of the solved matrix for 7x7 UP RIGHT-CENTER NORTH EAST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with South-West orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCSO3() {
		setUpScenary2();
		int[][] expected = {{8,3,4},{1,5,9},{6,7,2}};
		int[][] obtained = newMagicSquare.fillMatrixLCSO();
		
		assertTrue("The result of the solved matrix for 3x3 UP LEFT-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with South-West orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCSO5() {
		setUpScenary3();
		int[][] expected = {{17,23,4,10,11},
			{24,5,6,12,18},{1,7,13,19,25},{8,14,20,21,2},{15,16,22,3,9}};
		int[][] obtained = newMagicSquare.fillMatrixLCSO();
		
		assertTrue("The result of the solved matrix for 5x5 UP LEFT-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with South-West orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCSO7() {
		setUpScenary4();
		int[][] expected = {{30,38,46,5,13,21,22},{39,47,6,14,15,23,31},{48,7,8,16,24,32,40},{1,9,17,25,33,41,49},{10,18,26,34,42,43,2},{19,27,35,36,44,3,11},{28,29,37,45,4,12,20}};
		int[][] obtained = newMagicSquare.fillMatrixLCSO();
		
		assertTrue("The result of the solved matrix for 7x7 UP LEFT-CENTER SOUTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with North-West orientation for a 3x3 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCNO3() {
		setUpScenary2();
		int[][] expected = {{6,7,2},{1,5,9},{8,3,4}};
		int[][] obtained = newMagicSquare.fillMatrixLCNO();
		
		assertTrue("The result of the solved matrix for 3x3 UP LEFT-CENTER NORTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	}
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with North-West orientation for a 5x5 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCNO5() {
		setUpScenary3();
		int[][] expected = {{15,16,22,3,9},{8,14,20,21,2},{1,7,13,19,25},{24,5,6,12,18},{17,23,4,10,11}};
		int[][] obtained = newMagicSquare.fillMatrixLCNO();
		
		assertTrue("The result of the solved matrix for 5x5 UP LEFT-CENTER NORTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	} 
	
	/**
	 * This method tests if the fillMatrix method is returnig the correct solution in a Left-Center position with North-West orientation for a 7x7 MagicSuqare.
	 */
	@Test
	void testFillMatrixLCNO7() {
		setUpScenary4();
		int[][] expected = {{28,29,37,45,4,12,20},{19,27,35,36,44,3,11},{10,18,26,34,42,43,2},{1,9,17,25,33,41,49},{48,7,8,16,24,32,40},{39,47,6,14,15,23,31},{30,38,46,5,13,21,22}};
		int[][] obtained = newMagicSquare.fillMatrixLCNO();
		
		assertTrue("The result of the solved matrix for 7x7  UP LEFT-CENTER NORTH WEST matrix is incorrect", Arrays.deepEquals(expected, obtained));
	} 
	
	/**
	 * This method tests if the method ok is returnig the correct value.
	 */
	@Test
	void testOk() {
		setUpScenary2();
		newMagicSquare.setO(10);
		assertTrue("The method checker is not returning the correct value, the magicSquare cannot be solved",!newMagicSquare.ok());
		
		newMagicSquare.setO(100);
		assertTrue("The method checker is not returning the correct value, the magicSquare cannot be solved",!newMagicSquare.ok());
		
		newMagicSquare.setO(1000);
		assertTrue("The method checker is not returning the correct value, the magicSquare cannot be solved",!newMagicSquare.ok());
	
		newMagicSquare.setO(10000);
		assertTrue("The method checker is not returning the correct value, the magicSquare cannot be solved",!newMagicSquare.ok());
		
		newMagicSquare.setO(1000000);
		assertTrue("The method checker is not returning the correct value, the magicSquare cannot be solved",!newMagicSquare.ok());
	}
}


