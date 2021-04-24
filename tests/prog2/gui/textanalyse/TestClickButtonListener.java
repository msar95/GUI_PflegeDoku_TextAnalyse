package prog2.gui.textanalyse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestClickButtonListener {

	ClickButtonListener test;
	TextAnalyse testGui;

	@Before
	public void initalizingAndResettingOuts() {
		testGui = new TextAnalyse();// Damit JLabel result != null
		test = new ClickButtonListener(10);
		TextAnalyse.nums = "";
	}

	@Test
	// good case
	public void testIfConstructorParameterGetsProperlyConvertedIntoStringClass() {
		assertEquals(test.getIndex(), "10");
	}

	@Test
	// bad case
	public void testIfConstructorParamterGetsProperlyConvertedIntoStringClassByTestingWithInteger() {
		assertNotEquals(test.getIndex(), 5);
	}

	// good case
	@Test
	public void testIfAddNumbersMethodAddsTheCorrectStringToTheStringNums() {
		test.addNumbers("3");
		assertEquals(TextAnalyse.nums, "3");
	}

	// bad case
	@Test
	public void testIfAddNumbersMethodDoesNotTakeFalseStringValuesAndReturnsThem() {
		test.addNumbers("5");
		assertNotSame(TextAnalyse.nums, "3");
	}
	
	@Test
	public void testIf21CharactersAreProperlyAddedToNumsStringAndThatAnAdditionalNumberWillThrowAnException() {
		test.addNumbers("012345678901234567890");
		assertTrue(TextAnalyse.nums.length() == TextAnalyse.maxLength);
		
		try {
			test.addNumbers("1");
			fail();
		} catch (IllegalArgumentException e) {
		assertEquals(e.getClass(), IllegalArgumentException.class);
		}
	}
	
	
}