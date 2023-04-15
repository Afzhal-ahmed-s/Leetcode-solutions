//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> list = new ArrayList<Long>();
        helper(1, N, list);
        return list;
    }
    
    static void helper(int current, long N, ArrayList<Long> list){
        long factorialOfCurrentNumber = factorial(current);
        
        if(factorialOfCurrentNumber > N)return;
        
        list.add(factorialOfCurrentNumber);
        
        helper(++current, N, list);
        
    }
    
    static long factorial(int n){
        if(n == 1)return (long)1;
        return (long)n * factorial(n-1);
    }
}