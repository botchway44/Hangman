package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Core {

	public static void setIcon(String directory, JFrame frame) {
	
		BufferedImage img=null;
	
		try {
			img=ImageIO.read(new File(directory));
		}catch(IOException e) {
			
		}
		frame.setIconImage(img);
}
	public static ImageIcon creatImageIcon(String path) {
	java.net.URL imgUrl = Splash.class.getResource(path);
	System.out.println(imgUrl);
	if(imgUrl != null) return new ImageIcon(imgUrl);
	return null;
	}
	
	public static void play(String filename)
	{
	    try
	    {
	      if(!MP3.isPlaying) {
		      MP3 mp3 = new MP3(filename);
		      mp3.play();
	      }
	      
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
}

