//LCS
import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "ACDF";
        String ans = LCS(str1, str2);
        System.out.println("The length of the longest common subsequence between "
        + str1 + " and " + str2 + " is " + ans);
    }
    public static String LCS(String str1, String str2){
        
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; //Addind to diagonal element.
                } 
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //Max from left or top
                }
            }
        }
        
        //Printing the above stuff
        System.out.println("LCS Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        //Now, main part - storing the subsequence
        StringBuilder sb = new StringBuilder();
        int i = m, j = n; //Traversing from bottom.

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {//If match found
                sb.append(str1.charAt(i - 1));
                i--;
                j--; //Going to diagonal and storing in sb.
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {//Choosing the max from left or top.
                i--;
            } 
            else {
                j--;
            }
        }

        return sb.reverse().toString();


    }
}
