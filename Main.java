package assig3_1;

public class Main {

	public static void main(String[] args) {
		GamePlay gamePlay = new GamePlay();
		Gamer gamer1 = new Gamer(gamePlay);
		Gamer gamer2 = new Gamer(gamePlay);
		Judge judge = new Judge(gamePlay);

		judge.start();
		gamer1.start();
		gamer2.start();
		
		try {
			gamer1.join();
			gamer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		judge.interrupt();
		if (gamer1.getSorce() > gamer2.getSorce())
			System.out.println(gamer1.getName() + " wins");
		else if (gamer1.getSorce() == gamer2.getSorce())
			System.out.println("tie");
		else
			System.out.println(gamer2.getName() + " wins");

	}

}
