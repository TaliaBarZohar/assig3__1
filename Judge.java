package assig3_1;

public class Judge extends Thread {
	GamePlay gamePlay;

	// Constructor
	public Judge(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	// gameJudge function
	public void run() {
		
		try {
			while (!Thread.interrupted()) {
				gamePlay.makeCoinAvail(false);
				Thread.sleep(1000);
				gamePlay.makeCoinAvail(true);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			return;
		}
	}

}
