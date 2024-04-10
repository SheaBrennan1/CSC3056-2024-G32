package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

	private Values2D values2D;
	private Values2D emptyValues2D;
	private double[] doubleArray;
	private double[][] doubleArray2D;
	private double[] largeDoubleArray;
	private double[] smallDoubleArray;

	@Before
	public void setUp() {
		values2D = new DefaultKeyedValues2D();
		((DefaultKeyedValues2D) values2D).addValue(0, 0, 0);
		((DefaultKeyedValues2D) values2D).addValue(2.5, 1, 0);
		((DefaultKeyedValues2D) values2D).addValue(1, 0, 1);
		((DefaultKeyedValues2D) values2D).addValue(10, 1, 1);
		((DefaultKeyedValues2D) values2D).addValue(5, 0, 2);
		((DefaultKeyedValues2D) values2D).addValue(-3, 1, 2);

		emptyValues2D = new DefaultKeyedValues2D();
		doubleArray = new double[] { -1.0, 0.0, 3.0, 5.5 };
		doubleArray2D = new double[][] { { -1, 0, 3, 5.5 }, { -1, 0, 3.5 } };
		largeDoubleArray = new double[] { Double.MAX_VALUE };
		smallDoubleArray = new double[] { -Double.MAX_VALUE };
	}

	@After
	public void tearDown() {
		values2D = null;
		emptyValues2D = null;
	}

	// Tests for calculateColumnTotal
	@Test
	public void calculateColumnTotalWithValidDataAndValidColumn() {
		assertEquals("Expected column total incorrect.", 11.0, DataUtilities.calculateColumnTotal(values2D, 1),
				0.0000001d);
	}

	@Test
	public void calculateColumnTotalWithValidDataAndFirstColumn() {
		assertEquals("Expected column total incorrect.", 2.5, DataUtilities.calculateColumnTotal(values2D, 0),
				0.0000001d);
	}

	@Test
	public void calculateColumnTotalWithValidDataAndColumnOutOfUpperRange() {
		try {
			assertEquals("Expected column total for column out of range to be 0.", 0.0,
					DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
		} catch (Exception e) {
			fail("Exception thrown: " + e.getClass() + ". Expected outcome was: " + 0.0);
		}
	}

	@Test
	public void calculateColumnTotalWithValidDataAndColumnOutOfLowerRange() {
		try {
			assertEquals("Expected column total for column out of range to be 0.", 0.0,
					DataUtilities.calculateColumnTotal(values2D, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception thrown: " + e.getClass() + ". Expected outcome was: " + 0.0);
		}
	}

	@Test
	public void calculateColumnTotalWithNullDataAndValidColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateColumnTotalWithNullDataAndFirstColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateColumnTotalWithNullDataAndColumnOutOfUpperRange() {
		try {
			DataUtilities.calculateColumnTotal(null, 4);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateColumnTotalWithNullDataAndColumnOutOfLowerRange() {
		try {
			DataUtilities.calculateColumnTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateColumnTotalWithEmptyDataAndValidColumn() {
	    double actualColumnTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 1);
	    assertEquals("Column total should return 0.0 with invalid input", 0.0, actualColumnTotal, 0.0000001d);
	}


	@Test
	public void calculateColumnTotalWithEmptyDataAndFirstColumn() {
	    double actualColumnTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 0);
	    assertEquals("Column total should return 0.0 with invalid input", 0.0, actualColumnTotal, 0.0000001d);
	}

	@Test
	public void calculateColumnTotalWithEmptyDataAndColumnOutOfUpperRange() {
	    double actualColumnTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 3);
	    assertEquals("Column total should return 0.0 with invalid input", 0.0, actualColumnTotal, 0.0000001d);
	}

	@Test
	public void calculateColumnTotalWithEmptyDataAndColumnOutOfLowerRange() {
	    double actualColumnTotal = DataUtilities.calculateColumnTotal(emptyValues2D, -1);
	    assertEquals("Column total should return 0.0 with invalid input", 0.0, actualColumnTotal, 0.0000001d);
	}

	// Tests for calculateRowTotal
	@Test
	public void calculateRowTotalWithValidDataAndValidRow() {
		assertEquals("Expected row total incorrect.", 9.5, DataUtilities.calculateRowTotal(values2D, 1),
				0.0000001d);
	}

	@Test
	public void calculateRowTotalWithValidDataAndFirstRow() {
		assertEquals("Expected row total incorrect.", 6, DataUtilities.calculateRowTotal(values2D, 0),
				0.0000001d);
	}

	@Test
	public void calculateRowTotalWithValidDataAndRowOutOfUpperRange() {
		try {
			assertEquals("Expected row total for row out of range to be 0.", 0.0,
					DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
		} catch (Exception e) {
			fail("Exception thrown: " + e.getClass() + ". Expected outcome was: " + 0.0);
		}
	}

	@Test
	public void calculateRowTotalWithValidDataAndRowOutOfLowerRange() {
		try {
			assertEquals("Expected row total for row out of range to be 0.", 0.0,
					DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);
		} catch (Exception e) {
			fail("Exception thrown: " + e.getClass() + ". Expected outcome was: " + 0.0);
		}
	}

	@Test
	public void calculateRowTotalWithNullDataAndValidRow() {
		try {
			DataUtilities.calculateRowTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateRowTotalWithNullDataAndFirstRow() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateRowTotalWithNullDataAndColumnOutOfUpperRange() {
		try {
			DataUtilities.calculateRowTotal(null, 4);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateRowTotalWithNullDataAndColumnOutOfLowerRange() {
		try {
			DataUtilities.calculateRowTotal(null, -1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void calculateRowTotalWithEmptyDataAndValidRow() {
	    double actualRowTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 1);
	    assertEquals("Row total should return 0.0 with invalid input", 0.0, actualRowTotal, 0.0000001d);
	}


	@Test
	public void calculateRowTotalWithEmptyDataAndFirstColumn() {
	    double actualRowTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 0);
	    assertEquals("Row total should return 0.0 with invalid input", 0.0, actualRowTotal, 0.0000001d);
	}

	@Test
	public void calculateRowTotalWithEmptyDataAndColumnOutOfUpperRange() {
	    double actualRowTotal = DataUtilities.calculateColumnTotal(emptyValues2D, 3);
	    assertEquals("Row total should return 0.0 with invalid input", 0.0, actualRowTotal, 0.0000001d);
	}

	@Test
	public void calculateRowTotalWithEmptyDataAndColumnOutOfLowerRange() {
	    double actualRowTotal = DataUtilities.calculateColumnTotal(emptyValues2D, -1);
	    assertEquals("Row total should return 0.0 with invalid input", 0.0, actualRowTotal, 0.0000001d);
	}

	// Tests for createNumberArray
	@Test
	public void createNumberArrayWithValidData() {
	    Number[] expected = new Number[] { -1.0, 0.0, 3.0, 5.5 };
	    Number[] actual = DataUtilities.createNumberArray(doubleArray);
	    assertArrayEquals("Expected Number array does not match.", expected, actual);
	}

	@Test
	public void createNumberArrayWithNullData() {
		try { 
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

	@Test
	public void createNumberArrayWithEmptyData() {
		Number[] expected = new Number[] {};
	    Number[] actual = DataUtilities.createNumberArray(new double[] {});
	    assertArrayEquals("Expected Number array does not match.", expected, actual);
	}
	
	@Test
	public void createNumberArrayWithLargeData() {
	    Number[] expected = new Number[] { Double.MAX_VALUE };
	    Number[] actual = DataUtilities.createNumberArray(largeDoubleArray);
	    assertArrayEquals("Expected Number array does not match.", expected, actual);
	}
	
	@Test
	public void createNumberArrayWithSmallData() {
	    Number[] expected = new Number[] { -Double.MAX_VALUE };
	    Number[] actual = DataUtilities.createNumberArray(smallDoubleArray);
	    assertArrayEquals("Expected Number array does not match.", expected, actual);
	}

	// Tests for createNumberArray2D
	@Test
	public void createNumberArray2DWithValidData() {
		Number[][] expected = new Number[][] { { -1.0, 0.0, 3.0, 5.5 }, { -1.0, 0.0, 3.5 } };
		assertArrayEquals("Expected 2D Number array does not match.", expected,
				DataUtilities.createNumberArray2D(doubleArray2D));
	}

	@Test
	public void createNumberArray2DWithBothNullData() {
		try { 
			DataUtilities.createNumberArray2D(new double[][] {null, null});
		fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	} catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	}
	}
	
	@Test
	public void createNumberArray2DWithOneNullData() {
		try { 
			DataUtilities.createNumberArray2D(new double[][] {{ -1.0, 0.0, 3.0, 5.5}, null});
		fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	} catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	}
	}

	@Test
	public void createNumberArray2DWithBothEmptyData() {
		Number[][] expected = new Number[][] { {}, {} };
		assertArrayEquals("Expected 2D Number array does not match.", expected,
				DataUtilities.createNumberArray2D(new double[][] {{},{}}));
	}
	
	@Test
	public void createNumberArray2DWithOneEmptyData() {
		Number[][] expected = new Number[][] { {}, { -1.0, 0.0, 3.0, 5.5 } };
		assertArrayEquals("Expected 2D Number array does not match.", expected,
				DataUtilities.createNumberArray2D(new double[][] {{},{ -1.0, 0.0, 3.0, 5.5 }}));
	}
	
	@Test
	public void createNumberArray2DWithLargeData() {
		Number[][] expected = new Number[][] { {Double.MAX_VALUE}, { Double.MAX_VALUE} };
		assertArrayEquals("Expected 2D Number array does not match.", expected,
				DataUtilities.createNumberArray2D(new double[][] {largeDoubleArray,largeDoubleArray}));
	}
	
	@Test
	public void createNumberArray2DWithSmallData() {
		Number[][] expected = new Number[][] { {-Double.MAX_VALUE}, { -Double.MAX_VALUE } };
		assertArrayEquals("Expected 2D Number array does not match.", expected,
				DataUtilities.createNumberArray2D(new double[][]{smallDoubleArray,smallDoubleArray}));
	}



	// Tests for getCumulativePercentages
	@Test
	public void getCumulativePercentagesWithValidData() {

		DefaultKeyedValues values = new DefaultKeyedValues();

		values.addValue(new Integer(0), 5.0);
		values.addValue(new Integer(1), 10.0);
		values.addValue(new Integer(2), 5.0);

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals("Expected cumulative percentage incorrect for first item.", 0.25,
				result.getValue(new Integer(0)).doubleValue(), 0.0000001d);
		assertEquals("Expected cumulative percentage incorrect for second item.", 0.75,
				result.getValue(new Integer(1)).doubleValue(), 0.0000001d);
		assertEquals("Expected cumulative percentage incorrect for third item.", 1.00,
				result.getValue(new Integer(2)).doubleValue(), 0.0000001d);
	}
	
	@Test
	public void getCumulativePercentagesWithOneEntryValidData() {

		DefaultKeyedValues values = new DefaultKeyedValues();

		values.addValue(new Integer(0), 1);

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals("Expected cumulative percentage incorrect for first item.", 1.00,
				result.getValue(new Integer(0)).doubleValue(), 0.0000001d);
	}

	@Test
	public void getCumulativePercentagesWithNullData() {
		try { 
			DataUtilities.getCumulativePercentages(null);
		fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
	} catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	}
	}

	@Test
	public void getCumulativePercentagesWithEmptyData() {
	    KeyedValues emptyKeyedValues = new DefaultKeyedValues();
	    KeyedValues result = DataUtilities.getCumulativePercentages(emptyKeyedValues);
	    assertNotNull("Result should not be null", result);
	    assertEquals("Result should be empty if input is empty", 0, result.getItemCount());
	}

}
