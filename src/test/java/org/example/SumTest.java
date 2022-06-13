package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SumTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Sum sum = new Sum();
        int [] arr = new int[] {1, 2, 3};
        assertEquals(6, sum.sumNumbers(arr));
        System.out.println("PINEAPPLE");
    }
}
