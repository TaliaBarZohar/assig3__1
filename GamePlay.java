//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622
package assig3_1;
import java.util.Random;

public class GamePlay {

	private boolean coin_available_;
	private int rounds_counter_;
	
//Default constructor
	public GamePlay() {
		this.coin_available_ = true;
		this.rounds_counter_ = 0;
	}

//MakeCoinAvail function
	public synchronized void makeCoinAvail(boolean val) {
		coin_available_ = val;
		if (coin_available_ == true)
		//We will wake up all Threads in the wait () state
			notifyAll();
	}

//FilpCoin function
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

//GetNumOfRounds function 
	public synchronized int getNumOfRounds() {
		return rounds_counter_;
	}
}
