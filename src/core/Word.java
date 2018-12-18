package core;

public class Word {

	private String name;
	private String meaning ="";
	
	public Word(String word) {
		this.name = word;
	}
	
	public Word(String word, String meaning) {
		this.name = word;
		this.meaning = meaning;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getMeaning() {
		return this.meaning;
	}
	
	public String toString() {
		return this.name +" "+this.meaning;
				
	}
	
}
