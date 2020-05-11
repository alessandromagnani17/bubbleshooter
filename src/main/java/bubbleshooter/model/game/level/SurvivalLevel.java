package bubbleshooter.model.game.level;

import bubbleshooter.model.game.GameInfoManager;

public class SurvivalLevel extends AbstractLevel {

	private static final int ONE_SECOND_SCORE = 20;
	private static final int TIME_BEFORE_NEXT_ROW = 10;

	private double timeLeft;

	public SurvivalLevel() {
		this.setCurrentGameType(LevelType.SURVIVALMODE);
		this.timeLeft = TIME_BEFORE_NEXT_ROW;
	}

	@Override
	public final void updateScore(final double elapsed) {
		final GameInfoManager infoManager = this.getGameInfoManager();
		infoManager.updateScore(infoManager.getGameTime() * ONE_SECOND_SCORE);
	}

	@Override
	public final boolean isTimeToNewRow(final double elapsed) {
		this.timeLeft -= elapsed;
		if (this.timeLeft <= 0) {
			this.timeLeft = TIME_BEFORE_NEXT_ROW;
			return true;
		}
		return false;
	}
}
