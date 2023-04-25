//INSERTION SORT
import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the len of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        InsertionSort(arr, n);
    }
    static void InsertionSort(int[] arr, int n){
        //Compare current with all previous elements and insert at correct position.
        for(int i = 1; i < n; i++){
            
            int key = arr[i];
            int j = i - 1;
            
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
            
            //Printing Each Pass
            System.out.print("Pass " + i + "\t" + "[");
            for(int num: arr) System.out.print(num+ " ");
            System.out.print("]");
            System.out.println();
        }
    }

}
