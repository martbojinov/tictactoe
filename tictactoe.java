package tictactoe;
import java.io.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class tictactoe {
	
	private int[][] grid;		// 0 = EMPTY; 1 = X; 2 = O;
	private boolean turn_order;	// true = X turn; false = 0 turn;
	
	// constructor
	public tictactoe() {
		grid = new int[3][3];
		turn_order = flipCoin();
		
		return;
	}
	
	
	@Override
	public String toString() {
	    return 	Arrays.toString(grid[0]) + "\n" + 
	    		Arrays.toString(grid[1]) + "\n" + 
				Arrays.toString(grid[2]) + 
				"\nturn: " + turn_order + "\n";
	}
	
	
	public void gameUI() {
		JFrame window = new JFrame("Tic Tac Toe");
		
		// create label to denote whose turn it is
		JLabel l1 = new JLabel("test");
		l1.setBounds(  0, 300, 300, 25);
		window.add(l1);
		
		// create 9 buttons (grid in tictactoe)
		JButton b11 = new JButton("b11");	// first row
		JButton b12 = new JButton("b12");
		JButton b13 = new JButton("b13");
		JButton b21 = new JButton("b21");	// second row
		JButton b22 = new JButton("b22");
		JButton b23 = new JButton("b23");
		JButton b31 = new JButton("b31");	// third row
		JButton b32 = new JButton("b32");
		JButton b33 = new JButton("b33");
		
		// define button size and where they go on the window
		b11.setBounds(  0,   0, 100, 100);	// first row
		b12.setBounds(100,   0, 100, 100);
		b13.setBounds(200,   0, 100, 100);
		b21.setBounds(  0, 100, 100, 100);	// second row
		b22.setBounds(100, 100, 100, 100);
		b23.setBounds(200, 100, 100, 100);
		b31.setBounds(  0, 200, 100, 100);	// third row
		b32.setBounds(100, 200, 100, 100);
		b33.setBounds(200, 200, 100, 100);
		
		// add buttons to window
		window.add(b11);	// first row
		window.add(b12);
		window.add(b13);
		window.add(b21);	// second row
		window.add(b22);
		window.add(b23);
		window.add(b31);	// third row
		window.add(b32);
		window.add(b33);
		
		// action handling pushing the buttons
		b11.addActionListener(e -> buttonClick(b11, l1, 0, 0));
		b12.addActionListener(e -> buttonClick(b12, l1, 0, 1));
		b13.addActionListener(e -> buttonClick(b13, l1, 0, 2));
		b21.addActionListener(e -> buttonClick(b21, l1, 1, 0));
		b22.addActionListener(e -> buttonClick(b22, l1, 1, 1));
		b23.addActionListener(e -> buttonClick(b23, l1, 1, 2));
		b31.addActionListener(e -> buttonClick(b31, l1, 2, 0));
		b32.addActionListener(e -> buttonClick(b32, l1, 2, 1));
		b33.addActionListener(e -> buttonClick(b33, l1, 2, 2));
		
		
		window.setSize(317, 375);
		window.setLayout(null);
		window.setVisible(true);
		
		return;
    }
	
	
	// flips a coin for T/F. Used to choose which side will go first.
	public boolean flipCoin() {
		Random r = new Random();
		int flip = r.nextInt(2);
		if (flip == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// return whose side it is
	public boolean getSide() {
		return turn_order;
	}
	
	
	// manually choose which turn is going. true = X turn; false = 0 turn;
	public void overrideSide(boolean s) {
		turn_order = s;
		
		return;
	}
	
	
	// place either X or O onto the grid. X or O is chosen based on the current turn order.
	public int placeToken(int row, int col) {
		if (grid[row][col] == 0) {	// valid move
			int placed_val;
			if (turn_order == true) {	// true = X turn
				placed_val = 1;
			} else {					// false = 0 turn
				placed_val = 2;
			}
			grid[row][col] = placed_val;
			turn_order = !turn_order;
			
			return placed_val;	// 1 or 2
			 
		} else {	// invalid move
			return 0;
		}
	}
	
	
	// update text box to indicate whose turn it is ( true = X turn; false = 0 turn; )
	public void updateTurnLabel(JLabel l) {
		if (turn_order == true) {
			l.setText("It is X's turn.");
		} else {
			l.setText("It is O's turn.");
		}
		
		return;
	}
	
	
	// logic for when a button is clicked
	public void buttonClick(JButton b, JLabel l, int row, int col) {
		
		System.out.println("Button " + row + col + " pushed!");
		int tok = placeToken(row, col);
		
		if (tok == 1) {
			b.setText("X");
		} else {
			b.setText("O");
		}
		updateTurnLabel(l);
		
		System.out.println(this);
		
		return;
	}

	public static void main(String[] args) {
		
		tictactoe ttt = new tictactoe();
		
		ttt.gameUI();
		
		System.out.println(ttt);
		// System.out.println(ttt.placeToken(0, 0));
		System.out.println(ttt);
	
	}

}
