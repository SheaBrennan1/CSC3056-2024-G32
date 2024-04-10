package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RangeTest {
    
    private Range rangeObjectUnderTest;
    private Range negativeToInfinityRange;
    private Range zeroLengthRangeWithSpecialValues;
    private Range minValueToMaxValueRange;
    private Range justBelowMaxValueRange;
    private Range maxNegativeValueRange;
    private Range fullDoublePrecisionRange;
    private Range nullRange;
    private Range constraintRange;
    private Range intersectsRange;

    @Before
    public void setUp() throws Exception {
        rangeObjectUnderTest = new Range(-1,1);
        negativeToInfinityRange = new Range(-100, Double.POSITIVE_INFINITY); 
        zeroLengthRangeWithSpecialValues = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        minValueToMaxValueRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE); 
        justBelowMaxValueRange = new Range(Double.MAX_VALUE - 1, Double.MAX_VALUE); 
        maxNegativeValueRange = new Range(-Double.MAX_VALUE, -Double.MAX_VALUE / 2); 
        fullDoublePrecisionRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE); 
        nullRange = null;
        constraintRange = new Range(-10, 10);
        intersectsRange = new Range(5, 15);
    }

    @After
    public void tearDown() throws Exception {
        rangeObjectUnderTest = null;
        negativeToInfinityRange = null;
        zeroLengthRangeWithSpecialValues = null;
        minValueToMaxValueRange = null;
        justBelowMaxValueRange = null;
        maxNegativeValueRange = null;
        fullDoublePrecisionRange = null;
        nullRange = null;
        constraintRange = null;
        intersectsRange = null;
    }


    @Test
    public void testCentralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
    }

    //getLowerBound()
    @Test
    public void getLowerBoundForPositiveRangeOverlappingWithZeroInclusiveRange() {
        assertEquals("The lower bound of range -1 to 1 should be -1", -1, rangeObjectUnderTest.getLowerBound(), 0.0000001d);
    }

    @Test
    public void getLowerBoundForNegativeValueToSpecialValueRange() {
        assertEquals("The lower bound of a range from -100 to POSITIVE_INFINITY should be -100", -100, negativeToInfinityRange.getLowerBound(), 0.0000001d);
    }

    @Test
    public void getLowerBoundForZeroLengthRangeWithSpecialValues() {
        assertEquals("The lower bound of a zero-length range with POSITIVE_INFINITY should be POSITIVE_INFINITY", Double.POSITIVE_INFINITY, zeroLengthRangeWithSpecialValues.getLowerBound(), 0.0000001d);
    }
    
    @Test(expected = NullPointerException.class)
    public void getLowerBoundThrowsIllegalArgumentExceptionForNullRange() {
    	nullRange.getLowerBound();
    }

    @Test
    public void getLowerBoundReturnsMinValueForMinValueToMaxValueRange() {
        assertEquals("The lower bound of a range from Double.MIN_VALUE to Double.MAX_VALUE should be Double.MIN_VALUE", Double.MIN_VALUE, minValueToMaxValueRange.getLowerBound(), 0.0000001d);
    }

    @Test
    public void getLowerBoundJustBelowMaxValueForJustBelowMaxValueRange() {
        assertEquals("The lower bound just below the maximum double value", Double.MAX_VALUE - 1, justBelowMaxValueRange.getLowerBound(), 0.0000001d);
    }

    @Test
    public void getLowerBoundReturnsMaxNegativeValueForMaxNegativeValueRange() {
        assertEquals("The lower bound for a range starting at -Double.MAX_VALUE", -Double.MAX_VALUE, maxNegativeValueRange.getLowerBound(), 0.0000001d);
    }

    @Test
    public void getLowerBoundReturnsMaxNegativeValueForFullDoublePrecisionRange() {
        assertEquals("The lower bound for the full double precision range", -Double.MAX_VALUE, fullDoublePrecisionRange.getLowerBound(), 0.0000001d);
    }

    //getUpperBound()
    @Test
    public void getUpperBoundForPositiveRangeOverlappingWithZeroInclusiveRange() {
        assertEquals("The upper bound of range -1 to 1 should be 1", 1, rangeObjectUnderTest.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundForNegativeValueToSpecialValueRange() {
        assertEquals("The upper bound of a range from -100 to POSITIVE_INFINITY should be POSITIVE_INFINITY", Double.POSITIVE_INFINITY, negativeToInfinityRange.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundForZeroLengthRangeWithSpecialValues() {
        assertEquals("The upper bound of a zero-length range with POSITIVE_INFINITY should be POSITIVE_INFINITY", Double.POSITIVE_INFINITY, zeroLengthRangeWithSpecialValues.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundReturnsMaxValueForMinValueToMaxValueRange() {
        assertEquals("The upper bound of a range from Double.MIN_VALUE to Double.MAX_VALUE should be Double.MAX_VALUE", Double.MAX_VALUE, minValueToMaxValueRange.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundReturnsMaxValueForJustBelowMaxValueRange() {
        assertEquals("The upper bound should be Double.MAX_VALUE", Double.MAX_VALUE, justBelowMaxValueRange.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundReturnsNegativeHalfMaxValueForMaxNegativeValueRange() {
        assertEquals("The upper bound for a range ending at -Double.MAX_VALUE / 2", -Double.MAX_VALUE / 2, maxNegativeValueRange.getUpperBound(), 0.0000001d);
    }

    @Test
    public void getUpperBoundReturnsMaxValueForFullDoublePrecisionRange() {
        assertEquals("The upper bound for the full double precision range should be Double.MAX_VALUE", Double.MAX_VALUE, fullDoublePrecisionRange.getUpperBound(), 0.0000001d);
    }
    
    //constrain()
    @Test
    public void constrainValueBelowRangeOfLowerBound() {
        assertEquals("Value below range should be constrained to lower bound", -10, constraintRange.constrain(-15), 0.0000001d);
    }
    
    @Test
    public void constrainReturnSameForValueWithinRange() {
        assertEquals("Value within range should be unchanged", 5, constraintRange.constrain(5), 0.0000001d);
    }

    @Test
    public void constrainReturnUpperBoundForValueAboveRange() {
        assertEquals("Value above range should be constrained to upper bound", 10, constraintRange.constrain(15), 0.0000001d);
    }
    
    @Test
    public void constrainReturnUpperBoundForValueAtUpperBound() {
        assertEquals("Value at upper bound should be unchanged", 10, constraintRange.constrain(10), 0.0000001d);
    }

    @Test
    public void constrainShouldReturnLowerBoundForValueAtLowerBound() {
        assertEquals("Value at lower bound should be unchanged", -10, constraintRange.constrain(-10), 0.0000001d);
    }

    @Test
    public void constrainShouldReturnLowerBoundForValueJustBelowLowerBound() {
        assertEquals("Value just below lower bound should be constrained to lower bound", -10, constraintRange.constrain(-10.0001), 0.0000001d);
    }

    @Test
    public void constrainShouldReturnUpperBoundForValueJustAboveUpperBound() {
        assertEquals("Value just above upper bound should be constrained to upper bound", 10, constraintRange.constrain(10.0001), 0.0000001d);
    }
    
    @Test
    public void constrainShouldReturnInputForValueJustInsideLowerBoundary() {
        assertEquals("Value just inside lower boundary should remain unchanged", -9.999, constraintRange.constrain(-9.999), 0.0000001d);
    }
    
    @Test
    public void constrainShouldReturnLowerBoundWithNegativeInfinitySetAsTheConstrain() {
        assertEquals("Double.NEGATIVE_INFINITY should be constrained to lower bound", -10, constraintRange.constrain(Double.NEGATIVE_INFINITY), 0.0000001d);
    }
    
    @Test
    public void constrainShouldReturnUpperBoundWithPositiveInfinitySetAsTheConstrain() {
        assertEquals("Double.POSITIVE_INFINITY should be constrained to upper bound", 10, constraintRange.constrain(Double.POSITIVE_INFINITY), 0.0000001d);
    }
    
    //equals()
    @Test
    public void equalsWithSameBoundsShouldReturnTrue() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(1, 10);
        assertTrue("Two range objects with the same lower and upper bounds should be considered equal", range1.equals(range2));
    }

    @Test
    public void equalsWithDifferentBoundsShouldReturnFalse() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(2, 5);
        assertFalse("Two range objects with different lower and/or upper bounds should not be considered equal", range1.equals(range2));
    }

    @Test(expected = NullPointerException.class)
    public void equalsWithNullShouldThrowNullPointerException() {
        Range range1 = null;
        Range range2 = new Range(1, 10);
        assertFalse("A range object compared with null should not be considered equal", range1.equals(range2));
    }
    
    @Test(expected = NullPointerException.class)
    public void equalsWithBothRangesNullShouldThrowNullPointerException() {
        Range range1 = null;
        Range range2 = null;
        assertTrue("Comparing two null ranges should be considered equal", range1.equals(range2));
    }

    @Test
    public void equalsWithItselfShouldReturnTrue() {
        Range range1 = new Range(1, 10);
        assertTrue("A range object compared with itself should always be considered equal", range1.equals(range1));
    }

    @Test
    public void equalsWithExtremeValuesShouldReturnTrue() {
        Range range1 = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        Range range2 = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
        assertTrue("Two range objects with boundaries at extreme values should be considered equal", range1.equals(range2));
    }
    
    //intersects()
    @Test
    public void intersectsNoOverlapLowerShouldReturnFalse() {
        assertFalse("Should return false if no overlap and specified range is lower", intersectsRange.intersects(1, 4));
    }

    @Test
    public void intersectsNoOverlapHigherShouldReturnTrue() {
        assertFalse("Should return false if no overlap and specified range is higher", intersectsRange.intersects(16, 20));
    }

    @Test
    public void intersectsWithinShouldReturnTrue() {
        assertTrue("Should return true if specified range is within the Range object", intersectsRange.intersects(6, 14));
    }

    @Test
    public void intersectsEncompassingShouldReturnTrue() {
        assertTrue("Should return true if specified range encompasses the Range object", intersectsRange.intersects(1, 20));
    }

    @Test
    public void intersectsPartiallyOverlapLowerRangeShouldReturnTrue() {
        assertTrue("Should return true if specified range is partially lower but intersecting", intersectsRange.intersects(3, 10));
    }

    @Test
    public void intersectsPartiallyOverlapHigherRangeShouldReturnTrue() {
        assertTrue("Should return true if specified range is partially higher but intersecting", intersectsRange.intersects(10, 20));
    }

    //Lab 3 tests
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRangeConstructor_ThrowsIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Range(double, double): require lower (5.0) <= upper (1.0).");

        new Range(5.0, 1.0);
    }
    
    @Test
    public void testCombine_BothRangesNonNull() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(3.0, 7.0);

        Range expected = new Range(1.0, 7.0);

        Range result = Range.combine(range1, range2);

        assertNotNull("Resulting range should not be null", result);
        assertEquals("Lower bound of the combined range is incorrect", expected.getLowerBound(), result.getLowerBound(), 0.0000001);
        assertEquals("Upper bound of the combined range is incorrect", expected.getUpperBound(), result.getUpperBound(), 0.0000001);
    }
    
    @Test
    public void testCombine_BothRangesNonNullAndSameValues() {
        Range range1 = new Range(1.0, 1.0);
        Range range2 = new Range(1.0, 1.0);

        Range expected = new Range(1.0, 1.0);

        Range result = Range.combine(range1, range2);

        assertNotNull("Resulting range should not be null", result);
        assertEquals("Lower bound of the combined range is incorrect", expected.getLowerBound(), result.getLowerBound(), 0.0000001);
        assertEquals("Upper bound of the combined range is incorrect", expected.getUpperBound(), result.getUpperBound(), 0.0000001);
    }
    
    
    @Test
    public void testCombine_WithFirstRangeNull() {
        Range range2 = new Range(1.0, 5.0);

        Range result = Range.combine(null, range2);

        assertNotNull("Result should not be null when first range is null", result);
        assertEquals("The result should be equal to the second range when first range is null",
                            range2, result);
    }

    @Test
    public void testCombine_WithSecondRangeNull() {
        
        Range range1 = new Range(1.0, 5.0);

        Range result = Range.combine(range1, null);

        assertNotNull("Result should not be null when second range is null", result);
        assertEquals("The result should be equal to the first range when second range is null",
                            range1, result);
    }
    
    @Test
    public void testExpand_PositiveExpansion() {
        Range originalRange = new Range(2.0, 4.0);
        double lowerMargin = 0.25; // 25% of the range's length
        double upperMargin = 0.25; // 25% of the range's length
        Range expectedRange = new Range(1.5, 4.5); // Expected outcome

        Range expandedRange = Range.expand(originalRange, lowerMargin, upperMargin);

        assertNotNull("Expanded range should not be null", expandedRange);
        assertEquals("Lower bound of the expanded range is incorrect", 
                            expectedRange.getLowerBound(), 
                            expandedRange.getLowerBound(), 
                            0.0000001);
        assertEquals("Upper bound of the expanded range is incorrect", 
                            expectedRange.getUpperBound(), 
                            expandedRange.getUpperBound(), 
                            0.0000001);
    }
    
    @Test
    public void testShift_WithZeroCrossingDisallowed() {
        Range baseRange = new Range(-2.0, -1.0);
        double delta = 1.5;
        boolean allowZeroCrossing = false;
        Range expectedRange = new Range(-0.5, 0.0); // Expected outcome

        Range shiftedRange = Range.shift(baseRange, delta, allowZeroCrossing);

        assertNotNull("Shifted range should not be null", shiftedRange);
        assertEquals("Lower bound of the shifted range is incorrect", 
                            expectedRange.getLowerBound(), 
                            shiftedRange.getLowerBound(), 
                            0.0000001);
        assertEquals("Upper bound of the shifted range is incorrect", 
                            expectedRange.getUpperBound(), 
                            shiftedRange.getUpperBound(), 
                            0.0000001);
    }
    
    @Test
    public void testExpandToInclude_ValueBelowLowerBound() {
        Range range = new Range(2.0, 6.0);
        double value = 1.0; // Value is below the lower bound of the range

        Range result = Range.expandToInclude(range, value);

        assertEquals("Lower bound should be updated to include the new value", value, result.getLowerBound(), 0.0000001);
        assertEquals("Upper bound should remain unchanged", 6.0, result.getUpperBound(), 0.0000001);
    }
    
    @Test
    public void testExpandToInclude_ValueAboveUpperBound() {
        Range range = new Range(1.0, 4.0);
        double value = 6.0;
        Range result = Range.expandToInclude(range, value);
        assertEquals("The lower bound should remain unchanged", 1.0, result.getLowerBound(), 0.0000001);
        assertEquals("The new upper bound should be the value", value, result.getUpperBound(), 0.0000001);
    }
    
    @Test
    public void testHashCode_Equality() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);

        int hash1 = range1.hashCode();
        int hash2 = range2.hashCode();

        assertEquals("Equal Range objects must have the same hash code", hash1, hash2);
    }
    
    @Test
    public void testToString_Representation() {
        double lower = 1.0;
        double upper = 5.0;
        Range range = new Range(lower, upper);
        String expected = "Range[1.0,5.0]";

        String result = range.toString();

        assertEquals("String representation of range is incorrect", expected, result);
    }
    
    @Test
    public void testEquals_WithNonRangeObject() {
        Range range = new Range(1.0, 5.0);
        Object obj = new Object(); 

        assertFalse("Range should not be equal to a non-Range object", range.equals(obj));
    }
    
    @Test
    public void testEquals_WithDifferentUpperBound() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 6.0);

        assertFalse("Ranges with different upper bounds should not be equal", range1.equals(range2));
    }
    
    @Test
    public void testShift_AllowZeroCrossing() {
        Range baseRange = new Range(-5.0, 5.0);
        double delta = 10.0; // Shift amount that will move the range to the right
        boolean allowZeroCrossing = true;

        Range expectedRange = new Range(5.0, 15.0); // Expected shifted range

        Range shiftedRange = Range.shift(baseRange, delta, allowZeroCrossing);

        assertNotNull("Shifted range should not be null", shiftedRange);
        assertEquals("Lower bound of the shifted range is incorrect", 
                            expectedRange.getLowerBound(), 
                            shiftedRange.getLowerBound(), 
                            0.0000001);
        assertEquals("Upper bound of the shifted range is incorrect", 
                            expectedRange.getUpperBound(), 
                            shiftedRange.getUpperBound(), 
                            0.0000001);
    }

    
}
