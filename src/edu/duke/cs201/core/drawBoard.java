package edu.duke.cs201.core;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import edu.duke.cs201.core.parseText;

public class drawBoard implements Runnable{
	JFrame f;
	Thread t = null;
	JPanel panel;

	public drawBoard() {
		f = new JFrame("mineSweeper");
		t = new Thread(this);
		t.start();
		panel = new JPanel();
		f.add(panel);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
	}

	public void run() {
		try {
			while (true) {
				parseText pt = new parseText("../resources/board.txt");
				char [][]chars = pt.parseFile();
				int size = chars.length;
				for (int i=0; i<size; i++) {
					for (int j=0; j<size; j++) {
						if (chars[i][j] == '*') {
							ImageIcon icon_blank = new ImageIcon("../resources/blank.png");
							JLabel label_blank = new JLabel(icon_blank);
							panel.add(label_blank);
						}
						else if (chars[i][j] == 'F') {
							ImageIcon icon_flag = new ImageIcon("../resources/flag.png");
							JLabel label_flag = new JLabel(icon_flag);
							panel.add(label_flag);
						}
						else if (chars[i][j] == 'X') {
							ImageIcon icon_bomb = new ImageIcon("../resources/bomb.png");
							JLabel label_bomb = new JLabel(icon_bomb);
							panel.add(label_bomb);
						}
						else {
							ImageIcon icon_num = new ImageIcon("../resources/numbers/"+ Character.toString(chars[i][j]) + ".png");
							JLabel label_num = new JLabel(icon_num);
							panel.add(label_num);
						}
					}
				}
				panel.setLayout(new GridLayout(size, size));
				f.pack();
				t.sleep(100);
				panel.removeAll();
			}
		} catch (Exception e) {}
	}


	public static void main(String args[]) {
		new drawBoard();
	}
}
