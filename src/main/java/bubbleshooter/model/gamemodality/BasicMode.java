package bubbleshooter.model.gamemodality;

public class BasicMode extends AbstractGameMode {

    private static final int BUBBLE_SCORE = 20;
	private static int WRONG_SHOTS_BEFORE_NEW_ROW = 5;


	@Override
	public void updateScore(double elapsed) {
		GameInfoManager infoManager = this.getGameInfoManager();
		infoManager.updateScore(infoManager.getDestroyedBubbles() * BUBBLE_SCORE);
	}

	@Override
	public boolean isTimeToNewRow(double elapsed) {
		GameInfoManager infoManager = this.getGameInfoManager();
		if (infoManager.getWrongShoots() == WRONG_SHOTS_BEFORE_NEW_ROW) {
			infoManager.clearWrongShoots();
			return true;
		}
		return false;
	}

}
