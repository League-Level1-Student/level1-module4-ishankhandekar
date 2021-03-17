package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nastySurprise implements ActionListener{
	JButton b1 = new JButton("Treat");
	JButton b2 = new JButton("Trick");
	public void run() {
		JFrame j = new JFrame();
		JPanel p = new JPanel();
		j.add(p);
		p.add(b1);
		p.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		j.pack();
		j.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent l) {
		// TODO Auto-generated method stub
		if (l.getSource() == b2) {
			showPictureFromTheInternet("http://www.petsworld.in/blog/wp-content/uploads/2014/09/cute-white-puppy.jpg");
		}else if(l.getSource() == b1) {
			showPictureFromTheInternet("https://i.pinimg.com/564x/59/bc/5c/59bc5cd82b07f5923cf24f06e5de8885.jpg");
		}
		
	}private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
}
