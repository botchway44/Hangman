package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {
	public static Dictionary dic = new Dictionary();
	
	public Loader(){
		loadWordsAndMeaning();
	}
	
	
	public void loadWords() {
		Scanner scan = null;
		try {
		 scan = new Scanner(new File("./res/dictionary.txt"));
		
		 while(scan.hasNextLine()) {
				String temp =scan.nextLine();
				dic.addWord( new Word(temp));
				//System.out.println(temp);
			}
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void loadWordsAndMeaning() {
		Scanner scan = null;
		try {
		 scan = new Scanner(new File("./res/grewords.txt"));
		
		 while(scan.hasNextLine()) {
				String temp =scan.nextLine();
				String[] word_and_meaning = temp.split("\t");	
				
				if(word_and_meaning.length >1) {
				dic.addWord( new Word(word_and_meaning[0],word_and_meaning[1]));
				//System.out.println(word_and_meaning[0]+" : "+word_and_meaning[1]);
				}
			}
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
