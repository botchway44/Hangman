package core;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

	private HashMap<String,Word> words;
	private ArrayList<Word> temp = new ArrayList<>();
	
	public Dictionary(){
		words = new HashMap<String,Word>();
	}
	
	public Dictionary(Word word){
		words = new HashMap<String,Word>();
		temp.add(word);
		
		words.put(word.getName(), word);
	}
	
	public void addWord(Word word) {
		this.words.put(word.getName(), word);
		temp.add(word);
	}
	
	public Word getWord() {
		return temp.get((int) (Math.random()*temp.size()));
	}
	
	public boolean hasWord(String word) {
		if(words.containsKey(word)) return true;
		
		return false;
	}
}
