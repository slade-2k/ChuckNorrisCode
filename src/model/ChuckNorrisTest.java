/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author iho
 *
 */
public class ChuckNorrisTest {

	@Test
	public void whenInputIsNullThenOutputShouldReturnNull() {
		ChuckNorris chuckNorris = new ChuckNorris(null);
		String encodedMessage = chuckNorris.encode();
		assertNull(encodedMessage);
	}
	
	@Test
	public void whenInputIsEmptyThenOutputShouldReturnAnEmptyString() {
		ChuckNorris chuckNorris = new ChuckNorris("");
		String encodedMessage = chuckNorris.encode();
		assertEquals("", encodedMessage);
	}
	
	@Test
	public void whenInputIsCThenEncodeShouldReturnEncodedString() {
		ChuckNorris chuckNorris = new ChuckNorris("C");
		String encodedMessage = chuckNorris.encode();
		assertEquals("0 0 00 0000 0 00", encodedMessage);
	}
	
	@Test
	public void whenInputIsCCThenEncodeShouldReturnEncodedString() {
		ChuckNorris chuckNorris = new ChuckNorris("CC");
		String encodedMessage = chuckNorris.encode();
		assertEquals("0 0 00 0000 0 000 00 0000 0 00", encodedMessage);
	}
	
	@Test
	public void whenInputIsSixBitCharacterThenEncodeShouldReturnEncodedString() {
		ChuckNorris chuckNorris = new ChuckNorris("%");
		String encodedMessage = chuckNorris.encode();
		assertEquals("00 0 0 0 00 00 0 0 00 0 0 0", encodedMessage);
	}
	
	@Test
	public void whenInputIsTestStringThenEncodeShouldReturnEncodedString() {
		String expected = "0 0 00 0000 0 0000 00 0 0 0 00 000 0 000 00 0 0 0 00 0 0 000 00 000 0 0000 00 0 0 0 00 0 0 00 00 0 0 0 00 00000 0 0 00 00 0 000 00 0 0 00 00 0 0 0000000 00 00 0 0 00 0 0 000 00 00 0 0 00 0 0 00 00 0 0 0 00 00 0 0000 00 00 0 00 00 0 0 0 00 00 0 000 00 0 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 000 00 000 0 0 00 0 0 00 00 0 0 000000 00 0000 0 0000 00 00 0 0 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 00 00 0 0 0 00 000 0 00 00 0000 0 0000 00 00 0 00 00 0 0 0 00 000000 0 00 00 00 0 0 00 00 0 0 00 00000 0 00 00 0 0 0 00 0 0 0000 00 00 0 0 00 0 0 00000 00 00 0 0000 00 00 0 00 00 0 0 000 00 0 0 0 00 00 0 0 00 000000 0 00 00 00000 0 0 00 00000 0 00 00 0000 0 000 00 0 0 000 00 0 0 00 00 00 0 0 00 000 0 0 00 00000 0 000 00 0 0 00000 00 0 0 0 00 000 0 00 00 0 0 0 00 00 0 0000 00 0 0 0 00 00 0 00 00 00 0 0 00 0 0 0 00 0 0 0 00 00000 0 000 00 00 0 00000 00 0000 0 00 00 0000 0 000 00 000 0 0000 00 00 0 0 00 0 0 0 00 0 0 0 00 0 0 000 00 0";
		String testString = "Chuck Norris' keyboard has 2 keys: 0 and white space.";
		ChuckNorris chuckNorris = new ChuckNorris(testString);
		String encodedMessage = chuckNorris.encode();
		assertEquals(expected, encodedMessage);
	}
	
}