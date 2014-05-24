package MyObjects;

import java.util.*;

/*
 * @author		Dany L. Farina (dlfarina@gmail.com)
 */
public class StringThings
{
	
	private HashMap<Character,Integer> createHist()
	{
		return new HashMap<Character,Integer>();
	}
	
	private HashMap<Character, Integer> createHist( String a )
	{
		HashMap<Character, Integer> hist = createHist();
		addToHist( a, hist );
		return hist;
	}
	
	private void addToHist ( String str, HashMap<Character, Integer> hist )
	{
		addToHist( str, hist, 0, str.length() );
	}
	
	private void addToHist ( String str, HashMap<Character, Integer> hist, int startIdx, int length )
	{
		for ( int i=0; i<length; i++ )
		{
			int count = 1;
			char c = str.charAt(i);
			if ( hist.containsKey(c) )
				count += hist.get(c);
				
			hist.put(c, count);
		}
	}
	
    /** 
     * Returns true if both provided Strings contain the same letters
     * the same number of times, regardless of their order.
     * @param a       	First string to check
     * @param b         Second string to check
     * @return          <code>true</code> if both Strings are anagrams,
     * 					i.e., if they have the same letters in the same
     * 					quantities, regardless of their order. 
     *                  <code>false</code> otherwise.
     * @since           1.0
     */	public boolean isAnagram ( String a, String b )
	{
		if ( a == null && b == null ) return true;
		if ( a.length() != b.length() ) return false;
		
		HashMap<Character, Integer> histA = createHist(a);
		HashMap<Character, Integer> histB = createHist(b);
		
		if ( histA.size() != histB.size() ) return false;

		for ( Character c : histA.keySet())
		{
			if ( !histB.containsKey(c)) return false;
			if ( histB.get(c) != histA.get(c) ) return false;
		}
		
		return true;
	}
	
	/**
	 * Returns true if any substring of <code>whereToSearch</code> is an
	 * anagram of <code>whatWord</code>.
	 * @param whereToSearch	String where possible anagrams of
	 * 						<code>whatWord</code> are to be looked for.
	 * @param whatWord		String whose anagrams are to be search inside
	 * 						of String <code>whereToSearch</code>
	 * @return				<code>true</code> if <code>whereToSearch</code>
	 * 						contains an anagram of String <code>whatWord</code>.
	 * 						<code>false</code>, otherwise.
	 */
	public boolean containsAnagram ( String whereToSearch, String whatWord )
	{
		if ( whatWord == null || whatWord.isEmpty() ) return true;
		if ( whereToSearch.length() < whatWord.length() ) return false;
		
		HashMap<Character, Integer> aHist = createHist( whatWord );

		HashMap<Character, Integer> cHist = createHist();
		addToHist( whereToSearch, cHist, 0, whatWord.length() );
		
		int i=0;
		while ( true )
		{
			boolean same = true;
			
			for ( Character ch : aHist.keySet() )
			{
				same = ( cHist.containsKey(ch) && (cHist.get(ch) == aHist.get(ch)) );
				if ( !same ) break;
			}
			
			if ( same ) return true;

			if ( i >= whereToSearch.length() - whatWord.length()) break;

			char c = whereToSearch.charAt(i);
			int newCount = cHist.get(c) - 1;
			if ( newCount == 0 ) cHist.remove(c);
			else cHist.put(c, newCount);
			
			c = whereToSearch.charAt(i+whatWord.length());
			newCount = 1;
			if ( cHist.containsKey(c)) newCount += cHist.get(c);
			cHist.put(c,  newCount);
			
			i++;
		}
		return false;
	}
}
