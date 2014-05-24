package TestJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

import org.hamcrest.core.CombinableMatcher;

import MyObjects.Calculator;
import MyObjects.StringThings;

public class TestStringThings {

	private static String STR_EMPTY = "";
	
	@Test
	public void acceptNullAnagramOfNull()
	{
		StringThings st = new StringThings();
		assertTrue(st.isAnagram(null, null));
	}
	
	@Test
	public void acceptEmptyAnagramOfEmpty()
	{
		StringThings st = new StringThings();
		assertTrue(st.isAnagram(STR_EMPTY, STR_EMPTY));
	}
	
	@Test
	public void rejectDifferentLengths()
	{
		StringThings st = new StringThings();
		assertFalse( st.isAnagram( "aaa", "aa" ) );
	}
	
	@Test
	public void rejectDifferentLetters()
	{
		StringThings st = new StringThings();
		assertFalse(st.isAnagram( "abc", "abd" ));
	}
	
	@Test
	public void acceptValidAnagram()
	{
		StringThings st = new StringThings();
		assertTrue(st.isAnagram("abcdef",  "fedcba"));
	}
	
	@Test
	public void acceptNullContainedAnagram()
	{
		StringThings st = new StringThings();
		
		String container = "3j4pg3";
		String anagram = null;
		
		assertTrue( st.containsAnagram(container, anagram) );
	}
	
	@Test
	public void acceptEmptyContainedAnagram()
	{
		StringThings st = new StringThings();
		
		String container = "3j4pg3";
		String anagram = STR_EMPTY;
		
		assertTrue( st.containsAnagram(container, anagram) );
	}

	@Test
	public void acceptValidSameLengthContainedAnagram()
	{
		StringThings st = new StringThings();
		
		String container = "3j4pg3";
		String anagram = "pjg433";
		
		assertTrue( st.containsAnagram(container, anagram) );
	}
	
	@Test
	public void rejectShorterContainer()
	{
		StringThings st = new StringThings();
		
		String container = "abcd";
		String anagram = "abced";
		
		assertFalse( st.containsAnagram(container, anagram));
	}
	
	@Test
	public void acceptValidContainedAnagram()
	{
		StringThings st = new StringThings();
		
		String container = "akjgea;rkg;4";
		String anagram = ";rekag";
		
		assertTrue( st.containsAnagram(container,  anagram));
	}
	
	@Test
	public void rejectInvalidContainedAnagram()
	{
		StringThings st = new StringThings();
		
		String container = "akjgea;rkg;4";
		String anagram = ";reuag";
	
		assertFalse( st.containsAnagram(container, anagram));
	}
	
}
