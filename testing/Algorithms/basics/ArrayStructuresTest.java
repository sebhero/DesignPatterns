package Algorithms.basics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sebastian Börebäck on 2016-01-17.
 */
public class ArrayStructuresTest {


	private ArrayStructures theArrayStr;
	private int arrSize= 10;

	@Before
	public void setUp() throws Exception {
		theArrayStr = new ArrayStructures();
		theArrayStr.generateRandomArray();


	}

	@Test
	public void testGenerateRandomArray() throws Exception {
		//Given
		//random number is 10-20
		int expected =10;
		int expectDelta = 10;

		//when
		theArrayStr.generateRandomArray();

		//Then
		for (int i = 0; i < arrSize; i++) {
			Assert.assertEquals(expected,theArrayStr.getValueAtIndex(i),expectDelta);
		}
	}


	@Test
	public void testInsertValue() throws Exception {
		//Given
		int exptect = 55;
		//When
		theArrayStr.insertValue(55);
		arrSize++;
		//Then
		Assert.assertEquals(exptect,theArrayStr.getValueAtIndex(arrSize-1));
	}


	@Test
	public void testGetValueAtIndex() throws Exception {
		//Given
		int expected =10;
		theArrayStr.generateRandomArray();
		//When
		int answear = theArrayStr.getValueAtIndex(9);
		//Then
		Assert.assertEquals(expected,answear,9);
	}

	@Test
	public void testDoesArrayContainThisValue() throws Exception {
		//Given
		int inserted = 20;
		theArrayStr.insertValue(inserted);
		//When
		boolean answear = theArrayStr.doesArrayContainThisValue(inserted);
		boolean answearFalse = theArrayStr.doesArrayContainThisValue(999);
		//Then
		Assert.assertTrue(answear);
		Assert.assertFalse(answearFalse);
	}

	@Test
	public void testDeleteIndex() throws Exception {
		//Given
		int inserted = 99;
		theArrayStr.insertValue(inserted);
		int exptected99 = theArrayStr.getValueAtIndex(arrSize);
		Assert.assertEquals(exptected99,theArrayStr.getValueAtIndex(arrSize));
		//When
		theArrayStr.deleteIndex(arrSize);
		//Then
		Assert.assertNotEquals(exptected99,theArrayStr.getValueAtIndex(arrSize));

	}



	@Test
	public void testLinearSearchForValue() throws Exception {
		//Given
		int inserted =11;
		String exptected = 1+" ";

		//When
		String answear = theArrayStr.linearSearchForValue(inserted);
		//Then
		Assert.assertEquals(exptected,answear);

	}
}