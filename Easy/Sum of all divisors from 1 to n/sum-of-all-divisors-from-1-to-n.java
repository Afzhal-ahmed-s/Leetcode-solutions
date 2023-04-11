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
            int N=sc.nextInt();
			
            
            Solution ob = new Solution();
            long ans  = ob.sumOfDivisors(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long sumOfDivisors(int N){
        if(N==1)return 1;
        int ans=0;

        // for(int i=2; i<=N; i++){
        //     int limit = (int)Math.sqrt(i);
            
        //     for(int j=1; j<= limit; j++){
        //         if(i%j == 0){
        //             ans+=j;
        //             if(i/j != j)ans+= i/j;
        //     }
        //     }
        // }
        
        // return ans;
        
        // for(int i=1; i<=N; i++){
        //     ans += (N/i) * i;
        // }
        //  return ans;        
        
           long sum = 0;
        for (int i = 1; i <= N; ++i)
            sum += (N / i) * i;
        return sum;
    }
}