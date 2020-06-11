package Java_1;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        char[][] board = new char[3][3];
        char Player = 'X';
        int movesLeft = 9;
        int[] PlayerMove = new int[2];
        boolean isValid = false;
        initializeArray(board);
        while (true) {
            while (isValid == false) {
                System.out.println("Player " + Player + " turn. Please enter the coordinates");
                PlayerMove[0] = userInput.nextInt();
                PlayerMove[1] = userInput.nextInt();
                isValid = ValidMove(board, PlayerMove, Player);
                if (isValid == false)
                    System.out.println("invalid input, try again");
            }
            movesLeft--;
            printBoard(board);
            if (hasWinner(board, Player)) {
                //userInput.close();
                break;
            }

            //Changing the Player
            isValid = false;
            Player = ChangePlayer(Player);

            //reset the game if no moves remaining
            if (movesLeft == 0) {
                movesLeft = 9;
                initializeArray(board);
                Player = 'X';
                System.out.println("restarting game, no winner");
            }
        }
        System.out.println("Winner is Player " + Player);
    }

    public static void initializeArray(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '0';
            }
        }
    }

    public static boolean ValidMove(char[][] board, int[] PlayerMove, char Player) {
        if ((PlayerMove[0] >= 0) && (PlayerMove[0] <= 2) && (PlayerMove[1] >= 0) && (PlayerMove[1] <= 2)) {
            if (board[PlayerMove[0]][PlayerMove[1]] == '0') {
                board[PlayerMove[0]][PlayerMove[1]] = Player;
                return true;
            }
        }
        return false;
    }

    public static char ChangePlayer(char Player) {
        if (Player == 'X')
            return 'O';
        return 'X';
    }


    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean hasWinner(char[][] board, char Player) {
        if (board[0][0] == Player && board[1][0] == Player && board[2][0] == Player)
            return true;
        else if (board[0][1] == Player && board[1][1] == Player && board[2][1] == Player)
            return true;
        else if (board[0][2] == Player && board[1][2] == Player && board[2][2] == Player)
            return true;
        else if (board[0][0] == Player && board[0][1] == Player && board[0][2] == Player)
            return true;
        else if (board[1][0] == Player && board[1][1] == Player && board[1][2] == Player)
            return true;
        else if (board[2][0] == Player && board[2][1] == Player && board[2][2] == Player)
            return true;
        else if (board[0][0] == Player && board[1][1] == Player && board[2][2] == Player)
            return true;
        else if (board[2][0] == Player && board[1][1] == Player && board[0][2] == Player)
            return true;
        else
            return false;
    }
}
