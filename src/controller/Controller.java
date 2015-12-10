package controller;

import java.util.Scanner;

import model.ChuckNorris;

public class Controller {

	public static void main(String args[]) {
		Controller controller = new Controller();
		ChuckNorris chuckNorris = new ChuckNorris(controller.getUserInput());
		System.out.println(chuckNorris.encode());
	}

	private String getUserInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

}
