package de.ulikoenig.rockpaperscissors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * artificial intelligence to play rock paper scissors
 * 
 * @author ukoenig
 *
 */
public class GameAI {
	private static final List<RockPaperScissors> VALUES = Collections
			.unmodifiableList(Arrays.asList(RockPaperScissors.values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	/**
	 * Get a move from AI
	 * 
	 * @return move calculated by AI
	 */
	public RockPaperScissors play() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}

}
