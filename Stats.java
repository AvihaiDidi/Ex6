package application;

import javafx.scene.text.Text;

public class Stats implements StatListener {
	
	private Text curPlayer, p1Score, p2Score;
	
	public Stats(Text curPlayer, Text p1Score, Text p2Score) {
		this.curPlayer = curPlayer;
		this.p1Score = p1Score;
		this.p2Score = p2Score;
	}

	@Override
	public void updateStat(int curPlayer, int p1Score, int p2Score) {
		this.curPlayer.setText(Integer.toString(curPlayer));
		this.p1Score.setText(Integer.toString(p1Score));
		this.p2Score.setText(Integer.toString(p2Score));
	}

}
