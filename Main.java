//Talia yarin bar zohar Id: 318257060  
//Sagi stav Id: 316584622
package assig3_1;

public class Main {

	public static void main(String[] args) {
		//Creating instance
		GamePlay gamePlay = new GamePlay();
		//Creating threads 
		Gamer gamer1 = new Gamer(gamePlay);
		Gamer gamer2 = new Gamer(gamePlay);
		Judge judge = new Judge(gamePlay);
		
		//start the Threads
		judge.start();
		gamer1.start();
		gamer2.start();
		
		try {
			gamer1.join();
			gamer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Creating a thread-initiated interruption
		judge.interrupt();
		//Check who won the game
		if (gamer1.getSorce() > gamer2.getSorce())
			System.out.println(gamer1.getName() + " wins");
		else if (gamer1.getSorce() == gamer2.getSorce())
			System.out.println("tie");
		else
			System.out.println(gamer2.getName() + " wins");

	}

}
