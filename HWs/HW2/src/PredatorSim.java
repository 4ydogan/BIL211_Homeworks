import java.util.Random;
import java.util.Scanner;

public class PredatorSim {
	public static void main(String[] args) {
		World world = new World();
		Scanner scan = new Scanner(System.in);
		while(world.placeOfAnts().length > 0) {
			System.out.println("Press Enter to move to the next time step");
			if(scan.nextLine().equals("")) {
				step(world);
				world.printBoard();
			}
		}
		scan.close();
	}
	
	public static void step(World world) {
		stepDBs(world);
		stepAnts(world);
		breedDBs(world);
		breedAnts(world);
		starveDBs(world);
	}
	
	public static boolean isThereAnt(World world, int x, int y) {
		
		Bug[][] board = world.board;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				try{
					if(board[x+i][y+j] instanceof Ant)
						return true;
				}catch (Exception e) {}
			}
		}
		
		return false;
	}
	
	public static int[] findPlaceAnt(World world, int x, int y) {
		
		int[] arr = new int[2];
		
		Bug[][] board = world.board;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				try{
					if(board[x+i][y+j] instanceof Ant)
						return new int[]{x+i, y+j};
				}catch (Exception e) {}
			}
		}
		
		return arr;
	}
	
	public static void stepDBs(World world) {
		
		Random random = new Random();
		int x = 0;
		int y = 0;
				
		Bug[][] board = world.board;
		int[][] placeDBs = world.placeOfDBs();
				
		for (int i = 0; i < placeDBs.length; i++) {
			if(isThereAnt(world, placeDBs[i][0], placeDBs[i][1])) {	
				int[] arr = findPlaceAnt(world, placeDBs[i][0], placeDBs[i][1]);
				world.move(board[placeDBs[i][0]][placeDBs[i][1]], placeDBs[i][0], placeDBs[i][1], arr[0], arr[1]);
			}
			
			else {
				x = random.nextInt(3)-1;
				y = 0;
				if(x == 0) {
					y = random.nextInt(3)-1;
				}
				if(y == 0) {
					x = random.nextInt(3)-1;
				}
				
				int k = placeDBs[i][0] + x;
				int m = placeDBs[i][1] + y;
				boolean ctrl = false;
				int time = 0;
				do{
					time++;
					
					try{
						ctrl = world.move(board[placeDBs[i][0]][placeDBs[i][1]], placeDBs[i][0], placeDBs[i][1], k, m);
					}catch(Exception e) {
						x = random.nextInt(3)-1;
						y = 0;
						if(x == 0) {
							y = random.nextInt(3)-1;
						}
						if(y == 0) {
							x = random.nextInt(3)-1;
						}
						k = placeDBs[i][0] + x;
						m = placeDBs[i][1] + y;
					}
//					System.out.println("*****------------------------------*****");
//					world.printBoard();
				}while(ctrl == false && time < 50);
			}
		}
	}

	public static void stepAnts(World world) {
		
		Random random = new Random();
		int x = 0;
		int y = 0;
				
		Bug[][] board = world.board;
		int[][] placeAnts = world.placeOfAnts();
		
		for (int i = 0; i < placeAnts.length; i++) {
			
			x = random.nextInt(3)-1;
			y = 0;
			if(x == 0) {
				y = random.nextInt(3)-1;
			}
			if(y == 0) {
				x = random.nextInt(3)-1;
			}
			
			int k = placeAnts[i][0] + x;
			int m = placeAnts[i][1] + y;
			boolean ctrl = false;
			int time = 0;
			do{
				time++;
				
				try{
					ctrl = world.move(board[placeAnts[i][0]][placeAnts[i][1]], placeAnts[i][0], placeAnts[i][1], k, m);
				}catch(Exception e) {
					x = random.nextInt(3)-1;
					y = 0;
					if(x == 0) {
						y = random.nextInt(3)-1;
					}
					if(y == 0) {
						x = random.nextInt(3)-1;
					}
					k = placeAnts[i][0] + x;
					m = placeAnts[i][1] + y;
				}
//					System.out.println("*****------------------------------*****");
//					world.printBoard();
			}while(ctrl == false && time < 50);
		}
	}

	public static void breedDBs(World world) {
		Random random = new Random();
		int x = 0;
		int y = 0;
				
		Bug[][] board = world.board;
		int[][] placeDBs = world.placeOfDBs();
		
		for (int i = 0; i < placeDBs.length; i++) {
			if(board[placeDBs[i][0]][placeDBs[i][1]].getStep() == 8) {
				x = random.nextInt(3)-1;
				y = 0;
				if(x == 0) {
					y = random.nextInt(3)-1;
				}
				if(y == 0) {
					x = random.nextInt(3)-1;
				}
				
				int k = placeDBs[i][0] + x;
				int m = placeDBs[i][1] + y;
				boolean ctrl = false;
				int time = 0;
				do{
					time++;
					
					try{
						ctrl = world.breed(board[placeDBs[i][0]][placeDBs[i][1]], k, m);
					}catch(Exception e) {
						x = random.nextInt(3)-1;
						y = 0;
						if(x == 0) {
							y = random.nextInt(3)-1;
						}
						if(y == 0) {
							x = random.nextInt(3)-1;
						}
						k = placeDBs[i][0] + x;
						m = placeDBs[i][1] + y;
					}
//					System.out.println("*****------------------------------*****");
//					world.printBoard();
				}while(ctrl == false && time < 50);
			}
		}
	}

	public static void breedAnts(World world) {
		Random random = new Random();
		int x = 0;
		int y = 0;
				
		Bug[][] board = world.board;
		int[][] placeAnts = world.placeOfAnts();
	
		for (int i = 0; i < placeAnts.length; i++) {
			if(board[placeAnts[i][0]][placeAnts[i][1]].getStep() >= 3) {
				x = random.nextInt(3)-1;
				y = 0;
				if(x == 0) {
					y = random.nextInt(3)-1;
				}
				if(y == 0) {
					x = random.nextInt(3)-1;
				}
				
				int k = placeAnts[i][0] + x;
				int m = placeAnts[i][1] + y;
				boolean ctrl = false;
				int time = 0;
				do{
					time++;
					
					try{
						ctrl = world.breed(board[placeAnts[i][0]][placeAnts[i][1]], k, m);
					}catch(Exception e) {
						x = random.nextInt(3)-1;
						y = 0;
						if(x == 0) {
							y = random.nextInt(3)-1;
						}
						if(y == 0) {
							x = random.nextInt(3)-1;
						}
						k = placeAnts[i][0] + x;
						m = placeAnts[i][1] + y;
					}
//					System.out.println("*****------------------------------*****");
//					world.printBoard();
				}while(ctrl == false && time < 50);
			}
		}
	}

	public static void starveDBs(World world) {
				
		Bug[][] board = world.board;
		int[][] placeDBs = world.placeOfDBs();
		
		
		for (int i = 0; i < placeDBs.length; i++) {
			if(board[placeDBs[i][0]][placeDBs[i][1]].getEaten() == 10) {
				board[placeDBs[i][0]][placeDBs[i][1]] = null;
			}
		}
	}
}
