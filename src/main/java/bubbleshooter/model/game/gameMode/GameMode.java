package bubbleshooter.model.game.gameMode;

import java.util.List;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubbleFactory;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.bubble.ShootingBubble;
import bubbleshooter.model.bubble.SwitchBubble;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridHelper;
import bubbleshooter.model.bubble.bubbleGrid.BubbleGridManager;
import bubbleshooter.model.collision.CollisionController;
import bubbleshooter.model.game.GameInfoManager;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.GameType;

/**
 * Represents the game. 
 * It's responsible to initialize all {@link Bubble}s and create new row of bubbles 
 */

public interface GameMode {

	/**
	 * starts selected game and initialize all bubbles
	 */
	void start();

	/**
	 * updates the game
	 * 
	 * @param elapsed
	 */
	void update(final double elapsed);

	/**
	 * loads the {@link ShootingBubble}
	 */
	void loadShootingBubble();

	/**
	 * loads the {@link SwitchBubble}
	 */
	void loadSwitchBubble();

	/**
	 * gets the {@link BubblesManager}
	 * 
	 * @return {@link BubblesManager}
	 */
	BubblesManager getBubblesManager();

	/**
	 * sets current {@link GameType}
	 * 
	 * @param the {@link GameType}
	 */
	void setCurrentGameType(final GameType gameType);

	/**
	 * sets the {@link GameStatus}
	 * 
	 * @param the {@link GameStatus}
	 */
	void setGameStatus(final GameStatus status);

	/**
	 * gets the {@link GameStatus}
	 * 
	 * @return the {@link GameStatus}
	 */
	GameStatus getGameStatus();

	/**
	 * gets the {@link BubblesManager}
	 * 
	 * @return {@link BubblesManager}
	 */
	BubbleGridManager getGridManager();

	/**
	 * gets the {@link BubbleGridHelper}
	 * 
	 * @return the {@link BubbleGridHelper}
	 */
	BubbleGridHelper getGridHelper();

	/**
	 * gets the {@link CollisionController}
	 * 
	 * @return the {@link CollisionController}
	 */
	CollisionController getCollisionController();

	/**
	 * returns a list of current {@link Bubble}s
	 * 
	 * @return a {@link List} of all {@link Bubble}s
	 */
	List<Bubble> getCurrentBubbles();

	/**
	 * gets the {@link GameInfoManager}
	 * 
	 * @return the {@link GameInfoManager}
	 */
	GameInfoManager getGameInfoManager();

	/**
	 * gets the current {@link GameType}
	 * 
	 * @return the {@link GameType}
	 */
	GameType getCurrentGameType();

	/**
	 * gets the {@link BubbleFactory}
	 * 
	 * @return the {@link BubbleFactory}
	 */
	BubbleFactory getBubbleFactory();

	/**
	 * gets the number of rows of {@link Bubble}s at the beginning of the game
	 * 
	 * @return the number of rows
	 */
	int getNumRows();

	/**
	 * gets the number of {@link Bubble}s per row at the beginning of the game
	 * 
	 * @return the number of {@link Bubble}s per row
	 */
	int getBubblesPerRow();
}
