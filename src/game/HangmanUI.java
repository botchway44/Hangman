package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import core.Game;



public class HangmanUI extends JPanel{
	private JPanel alphabets_panel;
	private JPanel top_north_panel;
	private JPanel center_panel;
	private JLabel guess;
	private JLabel hint;
	private JLabel dashes;
	private JLabel guessed_chars;
	private JLabel hanging_images;
	private Game game;
	private int image_index=0;
	private JLabel label = null;
	private JPanel top_panel;
	private JPanel bottom_panel;
	
		public HangmanUI() {
			this.setLayout(new BorderLayout());
				
			alphabets_panel =new JPanel();
			alphabets_panel.setLayout(new BoxLayout(alphabets_panel, BoxLayout.Y_AXIS));
			
			top_north_panel = new JPanel();
			FlowLayout flow = new FlowLayout();
			flow.setAlignment(FlowLayout.LEFT);
			top_north_panel.setLayout(flow);
			displayTopButtons();	
			this.add(top_north_panel, BorderLayout.NORTH);
			
			center_panel = new JPanel();
			center_panel.setLayout(new BoxLayout(center_panel, BoxLayout.X_AXIS));
			addCenterElements();
			this.add(center_panel, BorderLayout.CENTER);
			
			addAlphabets();
			this.add(alphabets_panel, BorderLayout.SOUTH);
			createBorder();
			
			//initialize a new Game
			game = new Game(7);
			game.createDashes();
			
			dashes.setText(game.getTempWordHolder());
			guess.setText("Guesses : "+game.guessSoFar());
		}
	

		private void addCenterElements() {
			JPanel left = new JPanel();
			left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
			left.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
			 guess = new JLabel("Guess");
			 guess.setFont(new Font("Serif", Font.BOLD, 30));
			 
			 hint = new JLabel();
			 hint.setFont(new Font("Serif", Font.BOLD, 30));
			 
			 dashes = new JLabel("_ _ _ _ _ _");
			 left.add(guess);
			 left.add(hint);
			 left.add(dashes);

			 
			 guessed_chars = new JLabel("");
			 guessed_chars.setFont(new Font("Serif", Font.BOLD, 20));
			 left.add(guessed_chars);
			 
			 dashes.setFont(new Font("Serif", Font.BOLD, 100));
			 center_panel.add(left);
			 
			 
			FlowLayout flow = new FlowLayout();
			flow.setAlignment(FlowLayout.RIGHT);
			JPanel right = new JPanel(flow);
			hanging_images = new JLabel(new ImageIcon("res/hangman"+image_index+".png"));
			right.add(hanging_images);
			center_panel.add(right);
			
		}


		public void display(MouseEvent e) {
			String name = ((JLabel) e.getComponent()).getName();
			game.addGuessed_characters(name);
			if(!game.checkCharacter(name)) {
				image_index++;
				if(image_index <= 7) {
					hanging_images.setIcon(new ImageIcon("res/hangman"+image_index+".png"));
				}
			}

			dashes.setText(game.getTempWordHolder());
			guess.setText("Guess : "+game.guessSoFar());
			guessed_chars.setText("Guessed Letters : " + game.getGuessed_characters());
			
			
			
			if(game.checkIfCompletedWord()){
				hint.setText("You Won");
			}
			
			if(!game.getNumGuesses()){
				hint.setText("Game Over ");
				dashes.setText(game.getCurrentWord().getName());
				Core.play("res/laughing.mp3");
			}	
			
		}
		
		public void displayTopButtons() {
			JLabel icon = new JLabel(new ImageIcon("res/hmlogo.png"));
			top_north_panel.add(icon);
			
			JButton hint_button = new JButton("Hint");
			hint_button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					hint.setText("Hint :" + game.getCurrentWord().getMeaning());
				}
				
			});
			top_north_panel.add(hint_button);
			
			JButton end_game = new JButton("End Game");
			end_game.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dashes.setText(game.getCurrentWord().getName());
				}
				
			});
			top_north_panel.add(end_game);
			
			JButton new_game = new JButton("Play Again");
			new_game.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					game.resetGame();
					dashes.setText(game.getTempWordHolder());
					guess.setText("Guess : "+game.guessSoFar());
					image_index=0;
					hanging_images.setIcon(new ImageIcon("res/hangman"+image_index+".png"));
					hint.setText("");
				}
				
			});
			top_north_panel.add(new_game);
			
			
			
					
		}
		
		public void createBorder() {
			int count = top_panel.getComponentCount();
			
			for(int i=0;i<count; i++) {
				Component comp = top_panel.getComponent(i);
				//border
				Border border = ((JLabel) comp).getBorder();
				Border margin = new EmptyBorder(10,10,10,10);
				((JLabel) comp).setBorder(new CompoundBorder(border,margin));
				
			}
			
			count = bottom_panel.getComponentCount();
			for(int i=0;i<count; i++) {
				Component comp = bottom_panel.getComponent(i);
				//border
				Border border = ((JLabel) comp).getBorder();
				Border margin = new EmptyBorder(10,10,10,10);
				((JLabel) comp).setBorder(new CompoundBorder(border,margin));
				
			}
		}
		public void addAlphabets() {
			
			top_panel = new JPanel();
			top_panel.setLayout(new FlowLayout());
			
			
			//label a
			JLabel a = new JLabel(new ImageIcon("res/a.jpg"));
			a.setName("a");
			a.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(a);
			
			//label b
			JLabel b = new JLabel(new ImageIcon("res/b.png"));
			b.setName("b");
			b.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(b);
			
			//label c
			JLabel c = new JLabel(new ImageIcon("res/c.png"));
			c.setName("c");
			c.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(c);
			
			//label d
			JLabel d = new JLabel(new ImageIcon("res/d.png"));
			d.setName("d");
			d.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(d);
			
			//label e
			JLabel e = new JLabel(new ImageIcon("res/e.png"));
			e.setName("e");
			e.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(e);
			
			//label f
			JLabel f = new JLabel(new ImageIcon("res/f.png"));
			f.setName("f");
			f.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(f);
			
			//label g
			JLabel g = new JLabel(new ImageIcon("res/g.png"));
			g.setName("g");
			g.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(g);
			
			//label h
			JLabel h = new JLabel(new ImageIcon("res/h.png"));
			h.setName("h");
			h.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(h);
			
			//label i
			JLabel i = new JLabel(new ImageIcon("res/i.png"));
			i.setName("i");
			i.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(i);
			
			//label j
			JLabel j = new JLabel(new ImageIcon("res/j.png"));
			j.setName("j");
			j.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(j);
			
			//label k
			JLabel k = new JLabel(new ImageIcon("res/k.png"));
			k.setName("k");
			k.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(k);
			
			//label l
			JLabel l = new JLabel(new ImageIcon("res/l.png"));
			l.setName("l");
			l.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(l);
			
			//label m
			JLabel m = new JLabel(new ImageIcon("res/m.png"));
			m.setName("m");
			m.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(m);
			
			//label n
			JLabel n = new JLabel(new ImageIcon("res/n.png"));
			n.setName("n");
			n.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(n);
			
			//label o
			JLabel o = new JLabel(new ImageIcon("res/o.png"));
			o.setName("o");
			o.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			top_panel.add(o);
			
			
			
			bottom_panel = new JPanel();
			bottom_panel.setLayout(new FlowLayout());
			
			JLabel p = new JLabel(new ImageIcon("res/p.png"));
			p.setName("p");
			p.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(p);
			
			JLabel q = new JLabel(new ImageIcon("res/q.png"));
			q.setName("q");
			q.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(q);
			
			JLabel r = new JLabel(new ImageIcon("res/r.png"));
			r.setName("r");
			r.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(r);
			
			JLabel s = new JLabel(new ImageIcon("res/s.png"));
			s.setName("s");
			s.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(s);
			
			JLabel t = new JLabel(new ImageIcon("res/t.png"));
			t.setName("t");
			t.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(t);
			
			JLabel u = new JLabel(new ImageIcon("res/u.png"));
			u.setName("u");
			u.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(u);
			
			JLabel v = new JLabel(new ImageIcon("res/v.png"));
			v.setName("v");
			v.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(v);
			
			JLabel w = new JLabel(new ImageIcon("res/w.png"));
			w.setName("w");
			w.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(w);
			
			JLabel x = new JLabel(new ImageIcon("res/x.png"));
			x.setName("x");
			x.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(x);
			
			JLabel y = new JLabel(new ImageIcon("res/y.png"));
			y.setName("y");
			y.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(y);
			
			JLabel z = new JLabel(new ImageIcon("res/z.png"));
			z.setName("z");
			z.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					display(e);
				}
			});
			bottom_panel.add(z);
			
			alphabets_panel.add(top_panel);
			alphabets_panel.add(bottom_panel);
			}
	
}
