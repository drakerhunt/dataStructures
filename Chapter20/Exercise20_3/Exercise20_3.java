import java.util.Scanner;
//Drake Hunt - June 4, 2018
//Write a program that repeatedly prompts the user to enter a capital for a state. The program displays whether the answer is correct or not.
class Exercise20_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println((Double)Math.random() * 20 + 2);
		String guess = "";
		String guessedSubs = "";
		String[][] statesAndCapitals = {{"Arizona", "California", "Hawaii", "Mississippi", "North Carolina", "Utah", "Virginia", "Wyoming", "Georgia", "New York"}, {"Phoenix", "Sacramento", "Honolulu", "Jackson", "Raleigh", "Salt Lake City", "Richmond", "Cheyenne", "Atlanta", "Albany"}};
		int count = 0;
		int randomNumber = (int)(Math.random() * 10);
		while (count < 10) {
			if (count < 10) {
				while (guessedSubs.contains(Integer.toString(randomNumber))) {
					randomNumber = (int)(Math.random() * 10);
				} // end while
			}// end if 
			while (!guess.equalsIgnoreCase(statesAndCapitals[1][randomNumber])) {
				System.out.print("Guess the capital of " + statesAndCapitals[0][randomNumber] + ": ");
				guess = input.nextLine();
				if (guess.equalsIgnoreCase(statesAndCapitals[1][randomNumber])) {
					System.out.println("You are correct!\n");
					guessedSubs += randomNumber + ",";
				}
				else {
					System.out.println("You are wrong.\n");
				}//end if else
			}//end while guess does not equal correct
			count++;
		}//end while count < 10
	}
}