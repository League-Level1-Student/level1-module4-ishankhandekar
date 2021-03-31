package _05_typing_tutor;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	Date timeAtStart = new Date();
	char currentLetter;
	int countCharacters = 0;
	int correctCharacters = 0;
	JFrame frame = new JFrame();
	
	JPanel panel = new JPanel();
	JLabel displayCurrentLetter = new JLabel();
	void setup(){
		
		currentLetter = generateRandomLetter();
		
		
		frame.setVisible(true);
        frame.addKeyListener(this);
       
       
        displayCurrentLetter.setText(Character.toString(currentLetter));
        displayCurrentLetter.setFont(displayCurrentLetter.getFont().deriveFont(28.0f));
    	displayCurrentLetter.setHorizontalAlignment(JLabel.CENTER);
    	 displayCurrentLetter.setVisible(true);
    	 displayCurrentLetter.setSize(500, 500);
    	 panel.add(displayCurrentLetter);
    	frame.add(panel);
    	frame.pack();
        }
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	@Override
	
	public void keyPressed(KeyEvent l) {
		// TODO Auto-generated method stub
		if (countCharacters == 75) {
			showTypingSpeed(correctCharacters);
			System.exit(0);
		}
		if (l.getKeyChar() == currentLetter) {
			panel.setBackground(Color.green);
			
			correctCharacters++;
		}else {
			panel.setBackground(Color.red);
			
		}
		
		countCharacters++;
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		currentLetter = generateRandomLetter();
		displayCurrentLetter.setText(" ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayCurrentLetter.setText(Character.toString(currentLetter));
	}
	@Override
	public void keyTyped(KeyEvent l) {
		// TODO Auto-generated method stub
		System.out.println("You Pressed '" + l.getKeyChar() + "'" );
		frame.pack();
	}
	
    
	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	    Date timeAtEnd = new Date();
	    long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	    long gameInSeconds = (gameDuration / 1000) % 60;
	    double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	    int charactersPerMinute = (int) (charactersPerSecond * 60);
	    JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute.");
	} 
}
