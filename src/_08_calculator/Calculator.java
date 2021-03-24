package _08_calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Calculator implements ActionListener {
	JTextField f1 = new JTextField(20);
	JTextField f2 = new JTextField(20);
	JButton b1 = new JButton("add");
	JButton b2 = new JButton("sub");
	JButton b3 = new JButton("mul");
	JButton b4 = new JButton("div");
	JLabel answer = new JLabel();
	JFrame j = new JFrame();
	public void run() {
		
		answer.setFont(new Font("Times", Font.BOLD, 30));
//		answer.setForeground(new Color(68,85,90));
		j.setTitle("Simple Calculator");
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		
		p1.add(f2);
		p1.add(f1);
		p.add(p1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		JPanel p2 = new JPanel();
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p.add(p2);
		JPanel p3 = new JPanel();
		p3.add(answer);
		p.add(p3);
		j.add(p);
		j.setVisible(true);
		j.pack();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String i1 = f1.getText();
		String i2 = f2.getText();
		
		if (i1.length() == 0 || i2.length() == 0) {
			JOptionPane.showMessageDialog(null, "You did not enter anything in one of the boxes, try again.");
		}
		for (int i = 0; i < i1.length(); i++) {
			if (Character.isDigit(i1.charAt(i)) == false) {
				JOptionPane.showMessageDialog(null, "You put a " + i1.charAt(i) + " instead of a digit");
			}
		}for (int i = 0; i < i2.length(); i++) {
			if (Character.isDigit(i2.charAt(i)) == false) {
				JOptionPane.showMessageDialog(null, "You put a " + i2.charAt(i) + " instead of a digit");
			}
		}double d1 = Double.parseDouble(i1);
		double d2 = Double.parseDouble(i2);
		if (e.getSource() == b1) {
			answer.setText("" + (d1 + d2));
		}if (e.getSource() == b2) {
			answer.setText("" + (d1 - d2));
		}if (e.getSource() == b3) {
			answer.setText("" + (d1 * d2));
		}if (e.getSource() == b4) {
			answer.setText("" + (d1 / d2));
		}j.pack();
	}
}
