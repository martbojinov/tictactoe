package tictactoe;
import java.io.*;
import javax.swing.*;

public class tictactoe {
	
	public static void buttonClick(JButton b, String s) {
		System.out.println("Button " + s + " pushed!");
		b.setText("pushed");
		
		return;
	}

	public static void main(String[] args) {
		
		JFrame window = new JFrame("Tic Tac Toe");
		
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
		b11.addActionListener(e -> buttonClick(b11, "b11"));
		b12.addActionListener(e -> buttonClick(b12, "b12"));
		b13.addActionListener(e -> buttonClick(b13, "b13"));
		b21.addActionListener(e -> buttonClick(b21, "b21"));
		b22.addActionListener(e -> buttonClick(b22, "b22"));
		b23.addActionListener(e -> buttonClick(b23, "b23"));
		b31.addActionListener(e -> buttonClick(b31, "b31"));
		b32.addActionListener(e -> buttonClick(b32, "b32"));
		b33.addActionListener(e -> buttonClick(b33, "b33"));
		
		
		window.setSize(317, 340);
		window.setLayout(null);
		window.setVisible(true);
		
		

	}

}
