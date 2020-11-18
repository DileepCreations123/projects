package com. company;
import java.util.Scanner;
public class Hangman {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        String wordToGuess;
        int wordLength;
        int wordToGuessLength;
        int position;
        int Lost = 1;
        int Lives = 7;
        int Remaining;
        boolean guessInWord;
        char guess;
        StringBuffer prevGuessedLetters;
        String[] myArray = new String[]{"delhi"};
        System.out.println(" what is a capital of india");
        wordToGuess = myArray[(int) (Math.random() * myArray.length)];
        wordLength = wordToGuess.length();
        Remaining = wordLength;
        for (position = 0; position < wordLength; position++) {
            sb.append("_ ");
        }
        System.out.println(sb.toString());
        while (Remaining > 0 && Lost < 7) {
            System.out.println("Guess a letter:");
            guess = myScanner.findWithinHorizon(".", 0).charAt(0);
            guessInWord = (wordToGuess.indexOf(guess)) != -1;
            if (guessInWord == false) {
                Lost++;
                System.out.print("Sorry, you have lost a life. You still have ");
                System.out.print(Lives != Lost);
                System.out.println(" life/lives left. Keep trying.");
            } else {
                System.out.println("That was a good guess, well done!");
                for (position = 0; position < wordLength; position++) {
                    if (wordToGuess.charAt(position) == guess) {
                        System.out.print(guess);
                        Remaining--;
                    } else {
                        System.out.print("_ ");
                    }
                }
            }
            System.out.println();
            prevGuessedLetters = buffer.append(guess);
            System.out.println(prevGuessedLetters);
            System.out.print("Letters remaining: ");
            System.out.println(Remaining);
        }
        if (Lost ==Lives) {
            System.out.println("Sorry, you lose!");
        } else {
            System.out.print("Well done, you win! The word was ");
            System.out.println(wordToGuess);
        }
    }
}