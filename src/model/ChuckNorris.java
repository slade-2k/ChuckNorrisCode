package model;

public class ChuckNorris {

	private String input = null;
	private StringBuilder chuckNorris = new StringBuilder();
	private char[] binaryChars;

	public ChuckNorris(String input) {
		this.input = input;	
	}
	
	public String encode() {
		if(this.input == null){
			return null;
		}
		
		byte[] asciiArray = stringToAscii(this.input);
		
		String binaryString = asciiToBinary(asciiArray);
		
		return binaryToChuckNorris(binaryString);
	}

	private byte[] stringToAscii(String input) {
		byte[] asciiChars = input.getBytes();
		return asciiChars;
	}

	private String asciiToBinary(byte[] asciiChar) {
		StringBuilder binaryString = new StringBuilder();
		
		for (int x = 0; x < asciiChar.length; x++) {
			int sizeNeeded = 7;
			while(Integer.toBinaryString(asciiChar[x]).length() < sizeNeeded){
				binaryString.append("0");
				sizeNeeded--;
			}
			binaryString.append(Integer.toBinaryString(asciiChar[x]));
		}
		return binaryString.toString();
	}

	private String binaryToChuckNorris(String binary) {
		binaryChars = binary.toCharArray();
		
		for (int y = 0; y < binaryChars.length; y++) {
			if (binaryChars[y] == '0') {
				chuckNorris.append("00 0");
				y = this.countSameCharacters(y, '0');
				
			} else if (binaryChars[y] == '1') {
				chuckNorris.append("0 0");
				y = this.countSameCharacters(y, '1');
			}
		}
		return chuckNorris.toString();
	}
	
	private int countSameCharacters(int y, char lastDigit){

		for (int z = y + 1; z < binaryChars.length; z++) {
			if (binaryChars[z] == lastDigit) {
				this.chuckNorris.append('0');
				y++;
			} else {
				this.chuckNorris.append(' ');
				break;
			}
		}
		return y;
	}

}
