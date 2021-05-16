import java.util.ArrayList;
import java.util.Random;

public class World {
	Bug[][] board;
	
	public World() {
		board = createBoard();
	}
	
	public Bug[][] createBoard(){
		
		Random random = new Random();
		int countOfAnts = 100;
		int countOfDBs = 5;
		
		Bug[][] board = new Bug[20][20];
		
		int k = random.nextInt(20);
		int m = random.nextInt(20);
		
		while(countOfAnts > 0) {
			if(board[k][m] == null) {
				board[k][m] = new Ant();
				countOfAnts--;
			}
			
			k = random.nextInt(20);
			m = random.nextInt(20);
		}
		
		while(countOfDBs > 0) {
			if(board[k][m] == null) {
				board[k][m] = new DoodleBug();
				countOfDBs--;
			}
			
			k = random.nextInt(20);
			m = random.nextInt(20);
		}
		
		return board;
	}
	
	public boolean move(Bug bug, int x, int y, int k, int m) {
		if(bug instanceof Ant && board[k][m] == null) {
			board[k][m] = board[x][y];
			board[x][y] = null;
			bug.setStep();
			return true;
		}
		else if(bug instanceof DoodleBug && board[k][m] == null) {
			board[k][m] = board[x][y];
			board[x][y] = null;
			bug.setStep();
			bug.notEat();
			return true;
		}
		else if(bug instanceof DoodleBug && board[k][m] instanceof Ant) {
			board[k][m] = board[x][y];
			board[x][y] = null;
			bug.setStep();
			bug.eat();
			return true;
		}
		return false;
	}
	
	public boolean breed(Bug bug, int k, int m) {
		if(bug instanceof Ant && board[k][m] == null) {
			board[k][m] = new Ant();
			bug.resetStep();
			return true;
		}
		else if(bug instanceof DoodleBug && board[k][m] == null) {
			board[k][m] = new DoodleBug();
			bug.resetStep();
			return true;
		}
		
		return false;
	}

	public void printBoard() {
		
		System.out.println();
		System.out.println("*****------------------------------*****");
		System.out.println("Count of DoodleBugs: " + this.placeOfDBs().length);
		System.out.println("Count of Ants: " + this.placeOfAnts().length);
		System.out.println("*****------------------------------*****");
		System.out.println();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == null) {
					System.out.print("-");
				}else if(board[i][j] instanceof Ant){
					System.out.print("O");
				}else if(board[i][j] instanceof DoodleBug){
					System.out.print("X");
				}
				
				if(j != board.length-1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
	}
	
	public int[][] placeOfDBs() {
		
		int[][] result = null;
		
		ArrayList<int[]> arr = new ArrayList<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] instanceof DoodleBug) {
						arr.add(new int[] {i, j});
				}
			}
		}
		
		result = new int[arr.size()][2];
		
		for (int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
		
		return result;
	}
	
	public int[][] placeOfAnts() {
		
		int[][] result = null;
		
		ArrayList<int[]> arr = new ArrayList<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] instanceof Ant) {
						arr.add(new int[] {i, j});
				}
			}
		}
		
		result = new int[arr.size()][2];
		
		for (int i = 0; i < arr.size(); i++) {
			result[i] = arr.get(i);
		}
		
		return result;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
