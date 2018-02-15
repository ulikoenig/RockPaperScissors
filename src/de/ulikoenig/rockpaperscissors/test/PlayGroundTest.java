package de.ulikoenig.rockpaperscissors.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.ulikoenig.rockpaperscissors.GameResult;
import de.ulikoenig.rockpaperscissors.PlayGround;
import de.ulikoenig.rockpaperscissors.Result;
import de.ulikoenig.rockpaperscissors.RockPaperScissors;

class PlayGroundTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPlay() {
		PlayGround playGround = new PlayGround();
		// to test all branches in random environment, some iterations are needed
		for (int i = 0; i < 100; i++) {
			playAGame(playGround, RockPaperScissors.ROCK);
			playAGame(playGround, RockPaperScissors.PAPER);
			playAGame(playGround, RockPaperScissors.SCISSORS);
		}
	}

	@Test
	void testCalculateResult() {
		PlayGround playGround = new PlayGround();

		assertEquals(Result.NOWINNER, playGround.calculateResult(RockPaperScissors.ROCK, RockPaperScissors.ROCK));
		assertEquals(Result.AIWINS, playGround.calculateResult(RockPaperScissors.ROCK, RockPaperScissors.PAPER));
		assertEquals(Result.HUMANWINS, playGround.calculateResult(RockPaperScissors.ROCK, RockPaperScissors.SCISSORS));

		assertEquals(Result.HUMANWINS, playGround.calculateResult(RockPaperScissors.PAPER, RockPaperScissors.ROCK));
		assertEquals(Result.NOWINNER, playGround.calculateResult(RockPaperScissors.PAPER, RockPaperScissors.PAPER));
		assertEquals(Result.AIWINS, playGround.calculateResult(RockPaperScissors.PAPER, RockPaperScissors.SCISSORS));

		assertEquals(Result.AIWINS, playGround.calculateResult(RockPaperScissors.SCISSORS, RockPaperScissors.ROCK));
		assertEquals(Result.HUMANWINS, playGround.calculateResult(RockPaperScissors.SCISSORS, RockPaperScissors.PAPER));
		assertEquals(Result.NOWINNER,
				playGround.calculateResult(RockPaperScissors.SCISSORS, RockPaperScissors.SCISSORS));

	}

	private void playAGame(PlayGround playGround, RockPaperScissors choice) {
		GameResult result = playGround.play(choice);
		assertNotNull(result);
		result.getAiChoice();
		result.getHumanChoice();
		if (result.aiWins()) {
			assertFalse(result.humanWins());
			assertFalse(result.noWinner());
		}
		if (result.noWinner()) {
			assertFalse(result.aiWins());
			assertFalse(result.humanWins());
		}
		if (result.humanWins()) {
			assertFalse(result.aiWins());
			assertFalse(result.noWinner());
		}
	}

}
