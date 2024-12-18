package projects;
import java.util.*;
public class Tic_Tac_Toe {
	char board[][];
	int player;
	
	public Tic_Tac_Toe() {
		board = new board[3][3];
		player = 1;
		start();
	}
	
	public void start() {
		for(int i : board)
			for(int j : board)
				board[i][j] = '';
	}
	
	public void print() {
		for(int i : board) {
			for(int j : board)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
	
	public boolean moveValid(int r, int c) {
		if( (r>=0&&r<3) && (c>=0&&c<3) && (board[r][c] == ''))
			return true;
		return false;
	}
	
	public void move(int r, int c) {
		if(moveValid(r,c)) {
			if(player == 1)
				board[r][c] = 'X';
			else
				board[r][c] = 'O';
		}
		else {
			System.out.println("Invalid Move!.");
			System.exit(0);
		}	
	}
	
	public boolean win() {
		
//		for(int i: board) {
//			char k = board[][];
//			for(int j: board) {
//				if(board[ ][])
//			}
//		}
		
	}
	
}
