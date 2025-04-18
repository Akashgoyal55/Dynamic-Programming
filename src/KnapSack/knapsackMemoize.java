package KnapSack;
// Here we will solve the recursive approach using memoization
public class knapsackMemoize {
    static int[][] t; // global memoization table

    public static int knapSack(int[] wgt, int[] val, int w, int n){
        t = new int[n+1][w+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                t[i][j]=-1;
            }
        }
        // base case
        if(n==0 || w==0){
            return 0;
        }

        if(t[n][w]!=-1){
            return t[n][w];
        }

        if(wgt[n-1]<=w){
            return t[n][w] = Math.max(val[n-1]+knapSack(wgt, val, w-wgt[n-1], n-1), knapSack(wgt, val, w, n-1));
        }else if(wgt[n-1]>w){
            return knapSack(wgt, val, w, n-1);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] wgt = {2,4,6,7,8};
        int[] val = {3,5,7,9,11};
        int w = 10;
        int n = wgt.length;

        System.out.println("The max profit is : " +knapSack(wgt, val, w, n));
    }
}
