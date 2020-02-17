import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	static public void guess(String word, int life) {
		char [] filler = new char[word.length()];
		int i = 0;
		while(i<word.length()) {
			filler[i]='-';
			if(word.charAt(i)==' ') {
				filler[i]=' ';
			}
			i++;
		}
		System.out.print(filler);
		System.out.println("    Life remaining=" + life);

		Scanner s = new Scanner(System.in); //reads the character

		ArrayList<Character> l = new ArrayList<Character>();

		while(life>0) {
			char x=s.next().charAt(0); //character inputed by user

			if(l.contains(x)) {
				System.out.println("Already entered");
				continue;
			}

			l.add(x);

			if(word.contains(x+"")) {
				for(int y = 0; y<word.length(); y++) {  //This loop will check all indexes for the
					if(word.charAt(y)==x) {				//character and it will replace '-' with the
						filler[y]=x;					//character
					}
				}
			}else {
				life--;  //will decrease life in character inputed is wrong
			}

			if(word.equals(String.valueOf(filler))) {
				System.out.print("Word to guess = " + word);
				System.out.println("\nCongratulations, you've won");
				break;
			}

			System.out.print(filler);
			System.out.println("    Life remaining=" + life);
		}

		if (life == 0) {
			System.out.print("Word to guess = " + word);
			System.out.println("\nSorry, you've lost");
		}
	}


	public static void main(String [] arg) {
		String word = "Hi"; //word to be guessed
		int life = 5; //number of life
		guess(word,life);
	}
}
