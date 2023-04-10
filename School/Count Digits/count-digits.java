//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int N){
        int count=0;
        String s = String.valueOf(N);
        String[] arr = s.split("");
        
        for(int i=0; i<arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            if(num > 0 && N % num == 0)count++;
        }
        return count;
    }
}