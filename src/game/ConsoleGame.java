package game;

import java.util.Scanner;

import core.Game;

public class ConsoleGame {

	public static void main(String[] args) {
		
			Game game = new Game(3);
			game.createDashes();
			
			
		
			Scanner scan = new Scanner(System.in);

			while(true) {
//				System.out.println("Input 'Hint' to display the hint of the word");
				//take input
				System.out.println(game.getSoFar());
				System.out.println(game.getTempWordHolder());
				System.out.println("Guesses : "+game.guessSoFar());
				System.out.print("Guess character ? ");
				String input = scan.nextLine();
				
				
				if(input.equals("hint") || input.equals("HINT") ) {
					System.out.println("Meaning of the word : "+ game.getCurrentWord().getMeaning());
				}else {
					game.checkCharacter(input);
				}
				
				
				if(game.checkIfCompletedWord()){
					System.out.println("You Won");
					//TODO clear screen
					break;
				}
				
				if(!game.getNumGuesses()){
					System.out.println("The Word is: "+game.getCurrentWord().getName());//bless
					System.out.println("The Meaning of the Word is: "+ game.getCurrentWord().getMeaning());
					System.out.println("Game Over");
					break;
				}
				
				
			}
	}
}
