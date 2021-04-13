package _06_book_of_illusions;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** We’re going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {
	
	JLabel l;
	String ImageName = "opticalIllution1.jpg";
	// 1. Make a JFrame variable and initialize it using "new JFrame()"
	JFrame j = new JFrame();
	public void run() {
		// 2. make the frame visible
		j.setVisible(true);
		// 3. set the size of the frame
		j.setSize(300, 300);
		// 4. find 2 images and save them to your project’s _06_book_of_illusions folder
		
		// 5. make a variable to hold the location of your image. e.g. "illusion.jpg"
		
		// 6. create a variable of type "JLabel" but don’t initialize it yet
		
		// 7. use the "loadImage..." methods below to initialize your JLabel
		l = loadImageFromComputer(ImageName);
		// 8. add your JLabel to the frame
		j.add(l);
		// 9. call the pack() method on the frame
		j.pack();
		// 10. add a mouse listener to your frame (hint: use *this*)
		j.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		// 11. Print "clicked!" to the console when the mouse is pressed
		System.out.println("clicked");
		if (ImageName == "opticalIllution1.jpg") {
			ImageName = "optiacalIllution2.jpg";
		}else if(ImageName == "opticalIllution2") {
			ImageName = "opticalIllution1";
		}
		// 12. remove everything from the frame that was added earlier
		
		j.remove(l);
		// 13. load a new image like before (this is more than one line of code)
		l = loadImageFromComputer(ImageName);
		j.add(l);
		// 14. pack the frame
		j.pack();
	}

	// [OPTIONAL] 15. goad your users with some annoying or witty pop-ups

	/*
	 * To use this method, the image must be placed in your Eclipse project under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}


