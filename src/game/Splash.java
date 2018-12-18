package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Splash extends JPanel{
	JLabel label = null;
		public Splash() {
			this.setLayout(new BorderLayout());
			label = new JLabel();
			
			JLabel la = new JLabel(new ImageIcon("res/splash.png"));
			this.add(la,BorderLayout.CENTER);
		}
		
	
}
