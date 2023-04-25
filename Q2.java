//SELECTION SORT
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the len of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        SelectionSort(arr, n);
    }
    static void SelectionSort(int[] arr, int n){
        //Finding min element in unsorted array and swap it with the beginning element.
        for(int i = 0; i < n - 1; i++){

            for(int j = i+1; j < n; j++){

                if(arr[j] < arr[i]){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
            
            //Printing Each Pass
            System.out.print("Pass " + i + "\t" + "[");
            for(int num: arr) System.out.print(num+ " ");
            System.out.print("]");
            System.out.println();
        }
    }

}
