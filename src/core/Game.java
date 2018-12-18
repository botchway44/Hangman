package core;

public class Game {
	private Loader ld = new Loader();//loads all words
	private Dictionary dic = ld.dic;//copies the words to a new dictionary
	private String guessed_characters = "";
	private Word guessed_word; //holds the guessed word
	private int guesses = 3;//number of guesses
	private static int actual_guesses = 3;//number of guesses

	private String temp_word_holder = "";//holds the ----- for the word
	private String temp_word;
	
	public Game(int guesses) {
		this.actual_guesses = guesses;
		this.guesses = actual_guesses;
		 guessed_word = dic.getWord();
		 temp_word = guessed_word.getName();
	}
	
	public boolean checkCharacter(String input) {
		//System.out.print(temp_word+" is selected ");
		
		if(temp_word.contains(input)) {
			//System.out.print("contains character \n");
			int index = temp_word.indexOf(input);
			temp_word = temp_word.substring(0,index) +"?"+temp_word.substring(index+1);
			temp_word_holder = temp_word_holder.substring(0,index) + input+ temp_word_holder.substring(index+1);
			//System.out.print("new temp word = " + temp_word +"\n");
		return true;
		}
			//System.out.print("does not contains character \n");
			if(!(guesses <= 0)) guesses--;
			
			//System.out.print("guesses =  "+ guesses +"\n");
			
		return false;		
	}
	
	public void createDashes() {
		temp_word_holder = "";
		int len = guessed_word.getName().length();
		for(int i=0; i<len; i++) {
			temp_word_holder +="?";
		}
	}
	
	public String getSoFar() {
		return this.temp_word_holder;
	}
	
	public boolean getNumGuesses() {
		return this.guesses > 0;
	}
	
	public int guessSoFar() {
		return this.guesses;
	}
	
	public void addGuessed_characters(String guessed_characters) {
		this.guessed_characters+=guessed_characters;
	}
	
	public String getGuessed_characters() {
		return this.guessed_characters;
	}
	
	public String getTempWordHolder() {
		return this.temp_word_holder;
	}
	public boolean checkIfCompletedWord() {
		return (temp_word_holder.equals(guessed_word.getName()));
	}
	
	public Word getCurrentWord() {
		return  guessed_word;
	}
	
	public void resetGame() {
		this.guesses = actual_guesses;
		 guessed_word = dic.getWord();
		 temp_word = guessed_word.getName();
		 guessed_characters = "";
		 createDashes();
	}
}
