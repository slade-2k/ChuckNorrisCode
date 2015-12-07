package controller;

import java.util.Scanner;

public class Controller {

	public static void main(String args[]) {
		Controller controller = new Controller();
		controller.getUserInput();
	}

	public void stringToAscii(String inputMsg) {
		byte[] asciiChar = inputMsg.getBytes();
		asciiToBinary(asciiChar);

	}

	public void asciiToBinary(byte[] asciiChar) {
		// String[] asciiArray = asciiChar.toString();
		StringBuilder binaryString = new StringBuilder();
		for (int x = 0; x < asciiChar.length; x++) {
			if (Integer.toBinaryString(asciiChar[x]).length() < 7) {
				binaryString.append("0" + Integer.toBinaryString(asciiChar[x]));
			} else {
				binaryString.append(Integer.toBinaryString(asciiChar[x]));
			}
		}
		System.out.println("Binär: " + binaryString);
		binaryToChuckNorris(binaryString.toString());
	}

	public void binaryToChuckNorris(String binary) {
		StringBuilder chuckNorris = new StringBuilder();
		char[] binaryChars = binary.toCharArray();
		for (int y = 0; y < binaryChars.length; y++) {
			if (binaryChars[y] == '0') {
				chuckNorris.append("00 0");
				for (int z = y + 1; z < binaryChars.length; z++) {
					if (binaryChars[z] == '0') {
						chuckNorris.append('0');
						y++;
					} else {
						chuckNorris.append(' ');
						z = binaryChars.length;
					}
				}
			} else if (binaryChars[y] == '1') {
				chuckNorris.append("0 0");
				for (int z = y + 1; z < binaryChars.length; z++) {
					if (binaryChars[z] == '1') {
						chuckNorris.append('0');
						y++;
					} else {
						chuckNorris.append(' ');
						z = binaryChars.length;
					}
				}
			}
		}
		System.out.print("ChuckNorrisCode: " + chuckNorris);
	}

	public void getUserInput() {
		Scanner in = new Scanner(System.in);
		stringToAscii(in.nextLine());
	}

}
