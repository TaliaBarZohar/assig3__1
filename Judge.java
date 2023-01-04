//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622
package assig3_1;

public class Judge extends Thread {
	GamePlay gamePlay;

	// Parameter Constructor
	public Judge(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
	}

	// GameJudge function
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
