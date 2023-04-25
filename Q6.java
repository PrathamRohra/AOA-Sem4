//FRACTIONAL KNAPSACK

import java.util.*;
class Item {
  int value, weight;
  Item(int val, int wt) {
    this.value = val;
    this.weight = wt;
  }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
public class Q6{

    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 

        for (int i = 0; i < n; i++) {
       //Simply add up the weights if curr+arr[i].weight is less than capacity
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;

            }
     //Else take the fraction of it and break since we cant add more capacity.
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30), new Item(140, 2)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is: "+ans);
    }
}