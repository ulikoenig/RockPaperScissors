package de.ulikoenig.rockpaperscissors;

/**
 * Contains the result of a Game
 * @author ukoenig
 *
 */
public class GameResult {
	
	/**
	 * Create a gameresult
	 * @param humanChoice Choice of the human player
	 * @param aiChoice Choice of the ai player
	 * @param result result of the game
	 */
	
	public GameResult(RockPaperScissors humanChoice, RockPaperScissors aiChoice, Result result) {
		super();
		this.humanChoice = humanChoice;
		this.aiChoice = aiChoice;
		this.result = result;
	}

	private RockPaperScissors humanChoice;
	private RockPaperScissors aiChoice;
	private Result result;

	public RockPaperScissors getHumanChoice() {
		return humanChoice;
	}

	public RockPaperScissors getAiChoice() {
		return aiChoice;
	}

	public boolean humanWins() {
		return result == Result.HUMANWINS;
	}

	public boolean aiWins() {
		return result == Result.AIWINS;
	}

	public boolean noWinner() {
		return result == Result.NOWINNER;
	}

	public Result getResult() {
		return result;
	}

	/**
	 * Returns the result as human readable
	 * 
	 */
	@Override
	public String toString() {
		String result = "You choose: " + humanChoice + ". AI choose " + aiChoice + ". ";
		if (this.humanWins()) {
			result += "You WIN!";
		} else if (this.aiWins()) {
			result += "You LOOSE!";
		} else if (this.noWinner()) {
			result += "There is no winner.";
		}
		result += "\n\n";

		return result;
	}

}
