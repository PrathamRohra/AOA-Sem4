//SUM OF SUBSETS
import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queens: ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        // Arrays.fill(board, 0);

        //Calling and printing the chess board with n queens
        if(nQueen(board, 0, n)){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(board[i][j]+ " ");
                }
                System.out.println();
            }
        }
    }
    static boolean isSafe(int[][] board, int x, int y, int n){

        //Upper side
        for(int row = 0; row < x; row++){
            if(board[row][y] == 1){
                return false;
            }
        }

        //Upper left diagonal.
        int row = x;
        int col = y;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 1){
                return false;
            }
            row--;
            col--;
        }

        //Upper right diagonal
        row = x;
        col = y;
        while(row >= 0 && col < n){
            if(board[row][col] == 1){
                return false;
            }
            row--;
            col++;
        }

        return true;
    }
    static boolean nQueen(int[][] board, int x, int n){
        if(x >= n){
            return true; //All queens are placed.
        }
        for(int col = 0; col < n; col++){
            if(isSafe(board, x, col, n)){
                board[x][col] = 1;

                if(nQueen(board, x + 1, n)){
                    return true;
                }
                board[x][col] = 0; //Backtrack
            }            
        }
        return false;
    }
}
