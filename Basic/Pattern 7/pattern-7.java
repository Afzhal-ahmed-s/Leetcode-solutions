//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        for(int a=1; a<=n; a++){
            for(int b=1; b< n*2; b++){
                if(b <= n-a && b<=n)System.out.print(" ");
                else if(b > n-a && b<=n)System.out.print("*");
                if(b>n && b-n <= a-1)System.out.print("*");
            }
            System.out.println();
        }
    }
}