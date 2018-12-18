package game;

import java.util.Scanner;

import core.Dictionary;
import core.Loader;
import core.Word;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Loader ld = new Loader();
		
		Dictionary dic = ld.dic;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. Enter input");
		System.out.println("0. Exit");
		
		
		while(true) {
			//check if he won or not
			boolean won = false;
			
			//take input
			System.out.print("enter to play ? ");
			int input = scan.nextInt();
			//process
			if(input == 0) break;
			
			//update
			Word temp = dic.getWord();
			System.out.print("Word = " + temp.toString()+"\n");
			int guesses = 3;
			String temp_word = temp.getName();
			
			//run this till guesses is 0
			while(guesses >0) {
				System.out.print("guess character ? ");
				String in = scan.next();
				
				//compare if the character exists in the word
				if(temp_word.contains(in)) {
					System.out.print("contains character \n");
					int index = temp_word.indexOf(in);
					temp_word = temp_word.substring(0,index) + temp_word.substring(index+1);
					System.out.print("new temp word = " + temp_word +"\n");
				}else {
					System.out.print("does not contains character \n");
					guesses--;
					System.out.print("guesses =  "+ guesses +"\n");
					
				}
				
				if(temp_word.length() <=0) {
					won = true;
					break;
				}
			}
			
			if(won) {
			System.out.print("You are a winner \n");
			}else {
				System.out.print("Game Over \n");
			}
			
			System.out.println();
		
		}
	}

	
}
