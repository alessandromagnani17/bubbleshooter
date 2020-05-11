package gameover;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import bubbleshooter.model.game.GameOverChecker;
import bubbleshooter.model.game.level.BasicLevel;
import bubbleshooter.model.game.level.Level;
import bubbleshooter.model.game.level.SurvivalLevel;

/**
 * JUnit Test class to test the {@link GameOverChecker} of the Game.
 */
public class TestGameOver {

    private static final int BUBBLE_POSITION_TRUE  = 500;
    private static final int BUBBLE_POSITION_FALSE = 0;

    private Level basicMode = new BasicLevel();
    private Level survivalMode = new SurvivalLevel();

    /**
     * Method to test if {@link GameOverChecker} launch a GameOver
     * to the basic mode.
     */
    @Test
    public final void testBasicGameOver() {
        GameOverChecker gameOverChecker = new GameOverChecker(this.basicMode);
        assertTrue(gameOverChecker.isGameOver(BUBBLE_POSITION_TRUE));
        assertFalse(gameOverChecker.isGameOver(BUBBLE_POSITION_FALSE));
     }

    /**
     * Method to test if {@link GameOverChecker} launch a GameOver
     * to the survival mode.
     */
    @Test
    public final void testSurvivalGameOver() {
        GameOverChecker gameOverChecker = new GameOverChecker(this.survivalMode);
        assertTrue(gameOverChecker.isGameOver(BUBBLE_POSITION_TRUE));
        assertFalse(gameOverChecker.isGameOver(BUBBLE_POSITION_FALSE));
     }

}
