package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Graphics  extends JFrame{
private static JButton btn;
private static JTextField txt;
static JFrame frame;


public Graphics(){
	 //frame= new JFrame();
	
	this.setSize(1200,950);
	this.setResizable(true);
	this.setTitle("HangMan Game");
	FlowLayout fl = new FlowLayout();
	fl.setAlignment(FlowLayout.CENTER);
	this.setLayout(fl);
	Core.setIcon("res/hmlogo.png",this);
	
	JPanel screen = new JPanel();
	
	screen.add(new Splash());//set the logo on the screen
	this.add(screen);
	this.setVisible(true);
	
	//sleep for few Seconds
	try {
		Thread.sleep(2000);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	//clear everything on the screen
	screen.removeAll();
	screen.invalidate();
	screen.repaint();
	
	//add the menu to the screen
	screen.add(new HangmanUI());//set the logo on the screen
	
	screen.repaint();
	this.setVisible(true);
}	

}

