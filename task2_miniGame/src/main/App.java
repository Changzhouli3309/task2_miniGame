package main;

import java.util.Random;
import java.util.Scanner;

public class App {

	private static Scanner scan = new Scanner(System.in);
	private static Random ran = new Random();
	static String[] checkN = { "1", "2", "3" };
	static String[] moveSet = { "rock", "peper", "scissors" }; // default moves

	public static void main(String[] args) {
		System.out.println("Welcome to Rock Paper Scissors mini game");
		
		System.out.println("Do you want to change names of moves? (y to change)");
		if ("y".equals(scan.nextLine().toLowerCase())) {
			renameMoves();
		}

		for (int i = 0; i < 7; i++) {// hard code for number of round to test
			System.out.println("\nRound " + (i + 1));

			for (int j = 0; j < moveSet.length; j++) {
				System.out.println((j + 1) + "-" + moveSet[j]);
			}
			
			//get player move
			int move1 = getCheckedInput("Your move: ");
			
			//get AI move
//			int move2 = 1; // hard code for test
			int move2 = getRandomNumber(1, 3); // random move for AI

			checkWin(move1, move2);
		}
	}

	/**
	 * Rename the three moves of the game
	 */
	static void renameMoves() {
		for (int i = 0; i < moveSet.length; i++) {
			System.out.print("new name for " + moveSet[i] + ": ");
			moveSet[i] = scan.nextLine().toLowerCase();
		}
	}

	/**
	 * check the move numbers and tell result.
	 * 
	 * @param move1: move number for player
	 * @param move2: move number for computer
	 */
	static void checkWin(int move1, int move2) {
		System.out.println("--------------------");
		System.out.println("You: " + moveSet[move1 - 1] + "\nComputer: " + moveSet[move2 - 1]);

		// count the result number
		int res = move1 - move2;
		if (res < 0) {
			res += 3;
		}

		// tell the winner
		if (res == 0) {
			System.out.println("Draw!");
		} else if (res == 1) {
			System.out.println("You Win!");
		} else {
			System.out.println("Computer Win!");
		}
	}

	/**
	 * get a random number(integer) in the limit
	 * 
	 * @param min: lowest number
	 * @param max: highest number
	 * @return random number in the limit
	 */
	static int getRandomNumber(int min, int max) {
		return ran.nextInt(max - min) + min;
	}

	/**
	 * keep asking for input until it is available
	 * 
	 * @param question
	 * @return move number
	 */
	static int getCheckedInput(String question) {
		while (true) {
			System.out.print(question);
			String s = scan.nextLine().toLowerCase();

			// check for available number input
			for (int i = 0; i < checkN.length; i++) {
				if (checkN[i].equals(s)) {
					return i + 1;
				}
			}

			// check for available move input
			for (int i = 0; i < moveSet.length; i++) {
				if (moveSet[i].equals(s)) {
					return i + 1;
				}
			}
			System.out.println("No available input. Try again\n");
		}
	}
}
