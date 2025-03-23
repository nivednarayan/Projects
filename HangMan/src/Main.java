import java.util.*;
public class Main {
    public static void main(String[] args) {
        HangMan game = new HangMan();
        game.initialize();
        game.count();

        Scanner sc = new Scanner(System.in);
        int wrongGuess = 0;

        System.out.println("Current word: " + new String(game.guess));

        while (!game.check() && wrongGuess < 6){
            System.out.print("Enter your guess: ");
            String input = sc.next().toLowerCase();
            if (input.length() > 1){
                if (input.equals(game.s)){
                    System.out.println("Correct! You guessed the whole word!");
                    game.guessEntireWord(game.s);
                    System.out.println(new String(game.guess));
                    break;
                }
                else{
                    wrongGuess++;
                    System.out.println("Wrong word guess! Attempts left: " + (6 - wrongGuess));
                    game.printHangMan(wrongGuess);
                }
            }
            else{
                char c = input.charAt(0);
                if (game.isGuessed(c)){
                    System.out.println("Already guessed.");
                }
                else{
                    game.guessCharacter(c);
                    if (!game.isValid(c)){
                        wrongGuess++;
                        System.out.println("Wrong! Attempts left: " + (6 - wrongGuess));
                        game.printHangMan(wrongGuess);
                    }
                }
            }
        }
        System.out.println(game.check() ? "You won!" : "Game Over! Word: " + game.s);
        sc.close();
    }
}
