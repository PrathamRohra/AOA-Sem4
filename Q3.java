//QUICK SORT
import java.util.*;
public class Q3 {
    static int callCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the len of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int low = 0;
        int high = arr.length - 1;

        QuickSort(arr, low, high);

        System.out.println("Number of calls to Quick Sort Procedure: "+callCount);
        System.out.println("Sorted array: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        
    }
    static void QuickSort(int[] arr, int low, int high){
        callCount++;
        if(low < high){
            int pivot = Partition(arr, low, high);
            QuickSort(arr, low, pivot-1);
            QuickSort(arr, pivot+1, high);
        }
    }
    //Returns sorted position of Pivot element.
    static int Partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;
        while(i < j){
            //Continuously incrementing `i` if ith element is less than pivot.
            while((i <= arr.length -1) && (arr[i] <= pivot)) i++;

            //Continuously incrementing `j` if jth element is less than pivot.
            while(arr[j] > pivot) j--;

            //After finding min i and max j, swap both of em.
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //Continue this process until i < j
        }
        //Swapping low with jth element so that pivot reaches its correct position.
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

}
