import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public String[] fruit = { "a", "p", "p", "l", "e" };
	public String[] Veggie = { "l", "e", "t", "t", "u", "c", "e" };

	public int givenChances = 3;
	public String letter;
	int wordLength;
	int numOfTriesCount;
	int numOfTriesRemaining;
	int totalTries;
	public String fullWord;
	public int numOfChars = fruit.length;

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println("Lets Play Hangman!");

		m.printPositions();
		m.guessWord();

	}
	// public int compareTo(String o) {
	// return guessWord.compareTo(o);
	// }

	public void choseTheme() {
		System.out.println("Please chose the theme of your choice:");

		// implement a list of all the themes instead
		String[] fruits = { "apple", "orange", "banana" };
		String[] vegetables = { "carrots", "lettuce", "cucumber" };
		String[] country = { "Japan", "America", "India", "Italy", "Pakistan" };

		System.out.println("Please pick a theme.");
	}

	public void printWord() {
		Main m = new Main();

		int x;

		for (x = 0; x < m.fruit.length; x++) {
			fullWord = fruit[x];
			System.out.print(fullWord);
		}

		// for (y=0; y<=m.Veggie.length;y++){
		// System.out.println(Veggie[y]);
		// }

	}

	public void printPositions() {
		Main m = new Main();

		System.out.println("The number of characters are: " + numOfChars);
		// for(int i =0; i<=fruit.length;i++){
		// System.out.println(i + " = " + fruit[i]);
		// }
	}

	public void guessWord() {
		Main m = new Main();
		totalTries = numOfChars + givenChances;
		System.out.println("You will be given " + totalTries + " tries");
		System.out.println("------------------------------");
		Scanner guessWord = new Scanner(System.in);
		System.out.println("Please enter the first letter you think will be part of the word:");

		String positiveOutput = "Correct. That letter exists!";

		int numOfTriesCount = 0;
		int numOfTriesRemaining = 0;

		do {
			letter = guessWord.next();
			if (Arrays.asList(m.fruit).contains(letter)) {
				System.out.println(positiveOutput);
				numOfTriesCount++;
				numOfTriesRemaining = (numOfChars + givenChances) - numOfTriesCount;
				System.out.println("Number of tries remaining are " + numOfTriesRemaining);

				if (letter..equals(m.fullWord)) {
					System.out.println("Congrats, you found the full word");
				}
			} else if (m.fruit[0].equalsIgnoreCase(letter)) {
				System.out.println("There is a letter");
				numOfTriesCount++;

			}

			else {
				System.out.println("not matching");
				numOfTriesCount++;
				numOfTriesRemaining = (numOfChars + givenChances) - numOfTriesCount;
				System.out.println("Number of tries remaining are " + numOfTriesRemaining);
			}

		} while (numOfTriesCount <= numOfChars + givenChances);

		if (numOfTriesCount >= numOfChars + givenChances)

		{
			m.revealWord();
		}
	}

	public void revealWord() {
		Main m = new Main();
		System.out.println("----------------------------");
		System.out.println("Sorry, you ran out of tries.");
		System.out.print("The answer to the word is: ");
		printWord();
	}

}
