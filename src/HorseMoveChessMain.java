import java.util.Scanner;

public class HorseMoveChessMain {
	
	
	static long count = 0;
	private static Scanner in;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int sizeBoard = 0;
		
		in = new Scanner(System.in);
		writeln("Enter size of board");
		
		try {
			sizeBoard = in.nextInt();
			if (sizeBoard <5) {
				throw new Exception("Size must be >= 5");
			}
		}catch (Exception e) {
			throw new Exception("Please enter number");
		}
		
		int[][] desk = new int[sizeBoard][sizeBoard]; 
		
		for (int i=0; i<sizeBoard; i++) {
			 for (int j=0; j<sizeBoard; j++) {
				 desk[i][j] = 0;
			 }
		}
		
		step(4, 4, sizeBoard, desk, 0);
		writeln("Success!!!");
		for (int i=0; i<sizeBoard; i++) {
			 for (int j=0; j<sizeBoard; j++) {
				 write(desk[i][j]+ "   ");
			 }
			 writeln("");
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean step(int x0, int y0, int sizeBoard, int[][] desk, int nstep) {
		
		// horse can move:
		
		int[][] xy = new int[8][2];
		xy[0][0] = -1;
		xy[0][1] = -2;
		
		xy[1][0] = -2;
		xy[1][1] = -1;
		
		xy[2][0] = -2;
		xy[2][1] = 1;
		
		xy[3][0] = 1;
		xy[3][1] = -2;
		
		xy[4][0] = -1;
		xy[4][1] = 2;
		
		xy[5][0] = 2;
		xy[5][1] = -1;
		
		xy[6][0] = 1;
		xy[6][1] = 2;
		
		xy[7][0] = 2;
		xy[7][1] = 1;
		
		count++;
		if (count % 50000000 == 1) {
			writeln (count+" ");
			for (int i=0; i<sizeBoard; i++) {
				 for (int j=0; j<sizeBoard; j++) {
					 write(desk[i][j]+ " ");
				 }
				 writeln("");
			}
			
		}
		
		if ((x0 < 0) || (x0 >sizeBoard-1) || (y0 < 0) || (y0 >sizeBoard-1) ) return false;   // Going out of the board
		if (desk[x0][y0] !=0)  return false;        			// Field already passed
		desk[x0][y0] = ++nstep;                    				// Mark a free field
		if (nstep == sizeBoard*sizeBoard) return true;      	// All fields are marked - success
		for (int i=0; i<8; i++)
		     if (step(x0+xy[i][0], y0+xy[i][1], sizeBoard, desk, nstep))
			  return true;                           // Search for a successful move
		nstep--;                                     // one step back
		desk[x0][y0] = 0;                              // clear piont
		return false;                            // Sequence not found
		
		
		
	}
	
	
	public static void writeln(String text) {
		System.out.println(text);
	}
	
	public static void write(String text) {
		System.out.print(text);
	}

}
