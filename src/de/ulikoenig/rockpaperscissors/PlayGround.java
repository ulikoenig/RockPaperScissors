package de.ulikoenig.rockpaperscissors;

public class PlayGround {
	/**
	 * Plays a game with the ai
	 * 
	 * @param humanChoice
	 *            Choice of the human player
	 * @return result of the game
	 */
	public GameResult play(RockPaperScissors humanChoice) {
		if (humanChoice == null) throw new NullPointerException();
		GameAI ai = new GameAI();
		RockPaperScissors aiChoice = ai.play();
		Result result = calculateResult(humanChoice, aiChoice);
		return new GameResult(humanChoice, aiChoice, result);
	}

	/**
	 * Calcultes the result of the game
	 * 
	 * @param humanChoice
	 *            Choice of the human player
	 * @param aiChoice
	 *            choice of the ai player
	 * @return result of the Game
	 */
	public Result calculateResult(RockPaperScissors humanChoice, RockPaperScissors aiChoice) {
		switch (humanChoice) {
		case ROCK:
			if (aiChoice == RockPaperScissors.ROCK)
				return Result.NOWINNER;
			if (aiChoice == RockPaperScissors.PAPER)
				return Result.AIWINS;
			if (aiChoice == RockPaperScissors.SCISSORS) // if is not necessary. Stays for better readability
				return Result.HUMANWINS;
			break;
		case PAPER:
			if (aiChoice == RockPaperScissors.ROCK)
				return Result.HUMANWINS;
			if (aiChoice == RockPaperScissors.PAPER)
				return Result.NOWINNER;
			if (aiChoice == RockPaperScissors.SCISSORS) // if is not necessary. Stays for better readability
				return Result.AIWINS;
			break;
		case SCISSORS:
			if (aiChoice == RockPaperScissors.ROCK)
				return Result.AIWINS;
			if (aiChoice == RockPaperScissors.PAPER)
				return Result.HUMANWINS;
			if (aiChoice == RockPaperScissors.SCISSORS) // if is not necessary. Stays for better readability
				return Result.NOWINNER;
			break;

		default:
			break;
		}
		// This should never happen.
		throw new RuntimeException("calculateResult method is broken.");
	}

}
