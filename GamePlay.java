package assig3_1;

import java.util.Random;

public class GamePlay {

	private boolean coin_available_;
	private int rounds_counter_;

	public GamePlay() {
		this.coin_available_ = true;
		this.rounds_counter_ = 0;
	}

//makeCoinAvail function
	public synchronized void makeCoinAvail(boolean val) {
		// synchronized(gamer1)
		coin_available_ = val;
		if (coin_available_ == true)
			notifyAll();

	}

//filpCoin function
	public synchronized int filpCoin() {
		try {
			while (!this.coin_available_) {
				System.out.println((Thread.currentThread().getName()) + " is waiting for coin");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		makeCoinAvail(false);
		System.out.println((Thread.currentThread().getName()) + " is flipping coin");
		rounds_counter_++;
		int rand = new Random().nextInt(2);
		System.out.println("The random number is: " + rand);
		makeCoinAvail(true);
		return rand;
	}

//getNumOfRounds function 
	public synchronized int getNumOfRounds() {
		return rounds_counter_;
	}

}
