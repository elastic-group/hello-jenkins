package org.example;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FailingTest
{
    @Test
    public void testIntentionalFailure()
    {
        assertTrue( false);
    }
}
