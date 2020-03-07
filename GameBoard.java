public class GameBoard{
	private int numEntries;
	GameEntry[] board;
	
	public GameBoard(int capacity){
		board = new GameEntry[capacity];
	}
	
	public void setEntries(int ent){
		numEntries = ent;
	}
	
	public void addEntry(GameEntry e){
		int newScore = e.getScore();
		
		if(numEntries < board.length || newScore > board[numEntries-1].getScore()){
			if(numEntries < board.length){
				numEntries++;
			}
			int j = numEntries-1;
			
			while(j > 0 && board[j-1].getScore() < newScore){
				board[j] = board[j-1];
				j--;
			}
			board[j] = e;
		}
	}
	
	public GameEntry removeEntry(int i) throws IndexOutOfBoundsException{
		if(i < 0 || i >= numEntries){
			throw new IndexOutOfBoundsException("Invalid entry : "+i);
		}
		GameEntry temp = board[i];
		
		for(int j = i; j < numEntries-1; j++){
			board[j] = board[j+1];
		}
		board[numEntries-1] = null;
		numEntries--;
		return temp;
	}
	
	public String toString(){
		String results = "Entry"+1+": "+board[0]+",  ";
		for(int i = 1; i < numEntries+1; i++ ){
			results = results +"Entry"+i+2+": "+board[i+1]+", ";
			//return results;
		}
		return results;
	}
}