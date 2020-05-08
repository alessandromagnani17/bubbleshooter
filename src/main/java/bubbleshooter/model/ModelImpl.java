package bubbleshooter.model;

import java.util.List;
import bubbleshooter.model.bubble.Bubble;
import bubbleshooter.model.bubble.BubblesManager;
import bubbleshooter.model.game.GameStatus;
import bubbleshooter.model.game.mode.BasicMode;
import bubbleshooter.model.game.mode.GameMode;
import bubbleshooter.model.game.mode.SurvivalMode;

/**
 *The class which manage the logic of the game.
 *Implements the {@link Model} interface.
 */
public class ModelImpl implements Model {

    private GameMode gameMode;

    @Override
    public final void startBasicGame() {
        this.gameMode = new BasicMode();
        this.gameMode.start();
    }

    @Override
    public final void startSurvivalGame() {
        this.gameMode = new SurvivalMode();
        this.gameMode.start();
    }


    @Override
    public final void update(final double elapsed) {
        this.gameMode.update(elapsed);
    }

    @Override
    public final GameStatus getGameStatus() {
        return this.gameMode.getGameStatus();
    }

    @Override
    public final BubblesManager getGameObjectManager() {
        return this.gameMode.getGameObjectManager();
    }

    @Override
    public final List<Bubble> getBubbles() {
        return this.gameMode.getGameObjectManager().getAllBubbles();
    }

    @Override
    public final GameMode getLevel() {
        return this.gameMode;
    }
}
