package tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {

	public static Scanner scanner;
	public static TicTacToe game;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		char playerAvatar;
		char aiAvatar;
		int choice;
		Ai ai = new Ai();
		scanner = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe Game .");
		System.out.println();
		System.out.println("Please enter your name");
		name = scanner.next();
		System.out.println("Please choose an avatar for your game");
		playerAvatar = scanner.next().charAt(0);
		System.out.println();
		System.out.println("Please choose an avatar for me:");
		aiAvatar = scanner.next().charAt(0);
		game = new TicTacToe(playerAvatar, aiAvatar, name);
		System.out.println();
		// Printing game board
		System.out.println("Printing the Game Baord for your reference");
		System.out.println();
		game.printBoard();
		System.out.println();
		System.out.println();
		System.out.println("Printing the Game Index Baord for your reference");
		System.out.println();
		// printing index board
		game.printIndexBoard();
		System.out.println();
		
		while (game.isGameOver().equals("Not Over")) {
			if (game.currentMarker == game.PlayerMarker) {
				System.out.println("Enter your spot");
				choice = scanner.nextInt();
				game.playerTurn(choice);

			} else {
				int aichoice = ai.selectSpot(game);
				game.playerTurn(aichoice);
			}
			System.out.println("Printing the final Baord for your reference");
			System.out.println();
			game.printBoard();
			System.out.println();
			System.out.println();
		}
		System.out.println(game.isGameOver());

	}

}
