package Java_1;

import java.util.*;

/** MASTER MIND rules:
 * Guess a secret code consisting of a series of 8 alphabets from a to h. Each guess results in feedback narrowing down the possibilities of the code.
 * The winner is the player who solves his opponent’s secret code with fewer guesses.
 * The response at the right indicates:
 * 1 right alphabet in the right place #
 * 1 right alphabet in the wrong place *
 */
public class MasterMind {
    public static void main(String[] args) {
        char[][] board = new char[10][8];
        List<Character> correct = new ArrayList<>();
        combination(correct);
        Set<Character> correctSet = new HashSet<>(correct);
        initializeArray(board);
        printBoard(board);


        for (int numberOfTry = 0; numberOfTry < 11; numberOfTry++) {
            int i = numberOfTry;
            ask(board, i);


            int BlackCounter = 0;
            int RedCounter = 0;
            for (int j = 0; j < 4; j++) {

                if (correct.get(j).equals(board[i][j])) {
                    BlackCounter++;   //#  BLACK: right color and in the right position
                } else if (correctSet.contains(board[i][j])) {
                    RedCounter++;    //* Red: right color but in the wrong position
                }

            }

            feedback(board, BlackCounter, RedCounter, i);
            printBoard(board);
            if ((correct.get(0).equals(board[i][0])) && (correct.get(1).equals(board[i][1])) && (correct.get(2).equals(board[i][2])) && (correct.get(3).equals(board[i][3]))) {
                System.out.println("YOU WIN! :)");
                break;
            }

        }

    }


    public static void initializeArray(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'O';
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            for (int j = 4; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void ask(char[][] board, int i) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();


        for (int j = 0; j < 4; j++) {
            char[] input = userInput.toCharArray();

            if ((input[j] == 'a') | (input[j] == 'b') | (input[j] == 'c') | (input[j] == 'd') | (input[j] == 'e') | (input[j] == 'f') | (input[j] == 'g') | (input[j] == 'h')) {
                board[i][j] = input[j];
            } else {
                System.out.println("Please ENTER a VALID character from 'a' to 'h'!");
                break;
            }
        }


    }

    public static void feedback(char[][] board, int BlackCounter, int RedCounter, int i) {
        for (int j = 4; j < BlackCounter + 4; j++) {
            board[i][j] = '#';
        }
        for (int j = BlackCounter + 4; j < BlackCounter + 4 + RedCounter; j++) {
            board[i][j] = '*';
        }
    }

    public static void combination(List<Character> correct) {
        Random rand = new Random();
        List<Character> possibleInputs = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
        int numberOfElements = 4;
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(possibleInputs.size());
            char randomElement = possibleInputs.get(randomIndex);
            correct.add(randomElement);
            possibleInputs.remove(randomIndex);

        }
    }

}