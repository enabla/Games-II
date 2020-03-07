import java.security.SecureRandom;
import java.util.Scanner;

public class GamePlay{
	public static void main(String[] args){
		SecureRandom results = new SecureRandom();
		Scanner input = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Enter the number of scores to be stored:");
		int numScores = input.nextInt();
		GameBoard play = new GameBoard(numScores);
		System.out.println();
		
		System.out.println("Enter the total number of plays.");
		int totalPlays = input.nextInt();
		play.setEntries(totalPlays);
		
		for(int i = 0; i < numScores-1; i++){
			int nameNo = 1 + results.nextInt(totalPlays);
			String nm = "Name"+nameNo;
			int points = 1 + results.nextInt(totalPlays);
			GameEntry thisPlay = new GameEntry(nm, points);
			play.addEntry(thisPlay);
		}
		
		for(int j = 0; j < numScores; j++){
			
				System.out.println(play);
			
		}
	}
}