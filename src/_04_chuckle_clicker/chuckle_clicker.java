package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chuckle_clicker implements ActionListener {
	JButton jokeButton = new JButton("joke");
	JButton punchButton = new JButton("punchline");
	public void run() {
		JFrame j = new JFrame();
		JPanel p = new JPanel();
		j.add(p);
		
		jokeButton.addActionListener(this);
		punchButton.addActionListener(this);
		p.add(jokeButton);
		p.add(punchButton);
		j.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jokeButton) {
			JOptionPane.showMessageDialog(null, "");
		}else if(e.getSource() == punchButton) {
			JOptionPane.showMessageDialog(null, "");
		}
	}
}
