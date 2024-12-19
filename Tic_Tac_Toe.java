package projects.Projects;
import java.util.*;
public class Tic_Tac_Toe {
	Scanner sc=new Scanner(System.in);
	char board[][];
	boolean player;
	public Tic_Tac_Toe() {
		board = new char[3][3];
		player = true;
		start();
	}
	
	public void start() {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j] = ' ';
	}
	
	public void print() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
	
	public boolean moveValid(int r, int c) {
		if( (r>=0&&r<3) && (c>=0&&c<3) && (board[r][c] == ' '))
			return true;
		return false;
	}
	
	public void move(int r, int c) {
		if(moveValid(r,c)) {
			if(player == true)
				board[r][c] = 'X';
			else
				board[r][c] = 'O';
		}
		else {
			System.out.println("Invalid Move!. Try again.");
		}	
	}
	
	public boolean win() {
		
		for(int i=0;i<3;i++) {
			if( (board[i][0] == board[i][1]) && (board[i][1] == board[i][2]) )
				return true;
			if( (board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) )
				return true;
		}
		
		if( ( board[0][0] == board[1][1] ) && ( board[1][1] == board[2][2] ) )
			return true;
		if( ( board[0][2] == board[1][1] ) && ( board[1][1] == board[2][0] ) )
			return true;
		return false;
	}
	
	public boolean full() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == ' ')
					return false;
			}
		}
		return true;
	}
	
	public boolean draw() {
		if(full() && !win())
			return true;
		return false;
	}
	
	public void play() {
		int r,c;
		start();
		while(!draw() && !win() ) {
			print();
			System.out.println("Enter next move of player " + (player ? 1 : 2));
			r = sc.nextInt();
			c = sc.nextInt();
			move(r,c);
			if( draw() ) {
				print();
				System.out.println("Match Drawn.");
				break;
			}
			if( win() ) {
				print();
				System.out.println("Match won by player " + (player ? 1 : 2));
				break;
			}
			player = !player;
		}
	}
	
	public static void main(String[] args) {
		Tic_Tac_Toe t = new Tic_Tac_Toe();
		t.play();
	}

}
