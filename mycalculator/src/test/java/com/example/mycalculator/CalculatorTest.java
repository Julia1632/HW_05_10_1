package com.example.mycalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class CalculatorTest {

    private ICalculator mCalculator;
    private ICalculator mMockCalculator;

    @Before
    public void setUp() {
        mCalculator = spy(Calculator.class);
        mMockCalculator=mock(Calculator.class);

    }
    @Test
    public void testAdd() {
        when(mCalculator.plus(Matchers.anyDouble(),Matchers.anyDouble())).thenReturn(5.0);
        Double d_result = mCalculator.plus(1,2);

        assertEquals(d_result.toString(), "5.0");

        Integer i_result=(int) mMockCalculator.plus(1,2);
        assertSame(i_result, 0);




    }


}