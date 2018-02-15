package de.ulikoenig.rockpaperscissors.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.ulikoenig.rockpaperscissors.GameAI;
import de.ulikoenig.rockpaperscissors.RockPaperScissors;

class GameAITest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPlay() {
		GameAI gameai = new GameAI();
		RockPaperScissors answer = gameai.play();
		assertTrue((answer == RockPaperScissors.ROCK) | (answer == RockPaperScissors.PAPER)
				| (answer == RockPaperScissors.SCISSORS));
	}

}
