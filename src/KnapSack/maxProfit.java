package KnapSack;
/*
* It's a 0/1 knapsack problem
* Where you have been given a weight array and value array along with the maximum weight of the knapsack
* Select items such that their total weight is ≤ 5, and the total value is maximized.
* You can’t break items (i.e., either take it fully or not at all).
* Find the maximum profit you can get
 */
public class maxProfit {
    // knapsack function
    public static int knapsack(int[] wgt, int[] val, int W, int n){

        // base case
        if(W==0 || n==0){
            return 0;
        }

        if(wgt[n-1]<=W) { // condition 1 - include or not
            int include = val[n-1]+knapsack(wgt, val, W-wgt[n-1], n-1);
            int exclude = knapsack(wgt, val, W, n-1);

            return Math.max(include, exclude);

        }else if(wgt[n-1]>W) { // Condition2, do not include any item
            return knapsack(wgt, val, W, n-1);

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] wgt = {2,3,1,4,5};
        int[] val = {3,6,2,5,8};
        int W = 5;
        int n = wgt.length;

        System.out.println(knapsack(wgt, val, W, n-1));



    }
}
