//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622
package assig3_1;

public class Gamer extends Thread {

	
	private int goodFlipsCounter;
	GamePlay gamePlay;

	// Parameter constructor
	public Gamer(GamePlay gamerPlay) {
		this.gamePlay = gamerPlay;
	}

	// run function
	public void run() {
		while (gamePlay.getNumOfRounds() <= 10 && !Thread.interrupted()) {
			play();
		}
	}

	// play function
	public void play() {
		goodFlipsCounter += gamePlay.filpCoin();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// getSorce function
	public int getSorce() {
		return goodFlipsCounter;
	}

}
