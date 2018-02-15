package de.ulikoenig.rockpaperscissors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		RockPaperScissorsGame game = new RockPaperScissorsGame();

		game.run();
	}

	private Scanner scanner;
	private PlayGround playGround = new PlayGround();

	/**
	 * Start game, give greetings to user and run game loop
	 */
	private void run() {
		System.out.println("Welcome to Rock, Paper Sciccors!");
		scanner = new Scanner(System.in);
		while (true) {
			gameLoop();
		}
	}

	/**
	 * Game loop: Game will continue until unser quits
	 */
	private void gameLoop() {

		System.out.println("New round. Please choose: [1] Rock, [2] Paper, [3] Sciccors. Press [0] to Quit.");
		try {
			int choice = scanner.nextInt();
			if (choice == 0) {
				System.out.println("Bye bye.");
				System.exit(0);
			}
			RockPaperScissors humanChoice = null;
			if (choice == 1) {
				humanChoice = RockPaperScissors.ROCK;
			} else if (choice == 2) {
				humanChoice = RockPaperScissors.PAPER;
			} else if (choice == 3) {
				humanChoice = RockPaperScissors.SCISSORS;
			} else
				throw new InputMismatchException();
			GameResult gameResult = playGround.play(humanChoice);
			System.out.println(gameResult);

		} catch (java.util.InputMismatchException e) {
			System.out.flush();
			System.err.println(
					"Please enter only the numbers 0, 1, 2, 3 and hit enter.");
			System.err.flush();
			// clear wrong input
			if (scanner.hasNext()) {
				scanner.next();
			}
		}
	}

}
