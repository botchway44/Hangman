package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuUI extends JPanel{
	JLabel label = null;
		public MainMenuUI() {
			this.setLayout(new BorderLayout());
			
			label = new JLabel();
			
			JLabel la = new JLabel(new ImageIcon("res/background.jpg"));
			
			JPanel buttons_panel = new JPanel();
			buttons_panel.setOpaque(false);
			buttons_panel.add(new JButton("Start Game"));
			
			this.add(la);
			this.add(buttons_panel);
		}
		
	
}
