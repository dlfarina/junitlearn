package TestJUnit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.Arrays;

import junit.framework.Assert;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

import MyObjects.Calculator;
import junit.framework.*;

public class TestCalc {
	
	@Test
	public void testAddToIdentity ()
	{
		Calculator calc = new Calculator();
		double a = 0d;
		double b = 12d;
		double expected = a + b;
		double result = calc.add( a, b );
		Assert.assertEquals( expected, result );
	}
	
	@Test
	public void testAdd ()
	{
		Calculator calc = new Calculator();
		double a = 10d;
		double b = 12d;
		double expected = a + b;
		double result = calc.add( a, b );
		Assert.assertEquals( expected, result );
	}
	
	@Test
	public void testSubstract ()
	{
		Calculator calc = new Calculator();
		double a = 1000d;
		double b = 111;
		double expected = a - b;
		double result = calc.substract(a, b);
		assertThat(result, equalTo(expected));
	}
	
	@Test
	public void testMultiply()
	{
		Calculator calc = new Calculator();
		double a = 3000d;
		double b = 9000d;
		double result = calc.multiply(a, b);
		double expected = a * b;
		assertThat(result, is(equalTo(expected)));
	}
	
	
}
