//SUM OF SUBSETS
import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        int[] set = new int[]{ 1, 8, 8, 9, 4, 2, 7 };
        int targetSum = 9;
        List<List<Integer>> subsets = findSubsetsWithSum(set, targetSum);
        System.out.println("Subsets that add up to " + targetSum + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
    

    public static List<List<Integer>> findSubsetsWithSum(int[] set, int targetSum) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), set, targetSum, 0);
        return subsets;
    }


    private static void backtrack(List<List<Integer>> subsets, List<Integer> currentSubset, int[] set, int targetSum,
            int start) {
        if (targetSum == 0) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }
        for (int i = start; i < set.length; i++) {
            if (targetSum - set[i] >= 0) {
                currentSubset.add(set[i]);
                backtrack(subsets, currentSubset, set, targetSum - set[i], i + 1);
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }

}   
