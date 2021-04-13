package _11_whack_a_mole;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class whack_a_mole implements ActionListener {
	int whackCount = 0;
	Random randy = new Random();
	JFrame j = new JFrame();
	Date timeAtBeginning = new Date();
	JPanel p = new JPanel();
	public void run() {
		
		j.setVisible(true);
		p.setPreferredSize(new Dimension(200,300));
		j.add(p);
		
		
		drawButtons( randy.nextInt(15));
		j.pack();
	}public void drawButtons(int random) {
		JButton[] buttons = new JButton[15];
		for (int i = 0; i < buttons.length; i++) {
			if (i != random) {
				buttons[i] = new JButton("      ");
			}else {
				buttons[i] = new JButton("mole");
				
			}
			
		}
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			p.add(buttons[i]);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent l) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton)(l.getSource());
		if (buttonPressed.getText().equals("mole")) {
			j.remove(p);
			p = new JPanel();
			p.setPreferredSize(new Dimension(200,300));
			drawButtons(randy.nextInt(15));
			j.add(p);
			j.pack();
			whackCount++;
			if (whackCount == 10) {
				endGame(timeAtBeginning,whackCount);
				System.exit(0);
			}
			playSound("ding.wav");
		}else {
			j.remove(p);
			
			p = new JPanel();
			p.setPreferredSize(new Dimension(200,300));
			drawButtons(randy.nextInt(15));
			j.add(p);
			j.pack();
			
			speak("missed!");
		}
	}
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }private void endGame(Date timeAtStart, int molesWhacked) { 
        Date timeAtEnd = new Date();
        JOptionPane.showMessageDialog(null, "Your whack rate is "
                + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                      + " moles per second.");
    }
    private void playSound(String fileName) { 
        AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
        sound.play();
    }
}
