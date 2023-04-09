//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();

            Solution ob = new Solution();
            ob.printDiamond(n);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    void printDiamond(int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j< n-i-1; j++)System.out.print(" ");
            for(int j=0; j<i+1; j++){System.out.print("*"); System.out.print(" ");}
        
            System.out.println();
        }
        for(int i=n-1; i>=0; i--){
            for(int j=0; j< n-i-1; j++)System.out.print(" ");
            for(int j=0; j<i+1; j++){System.out.print("*"); System.out.print(" ");}
        
            System.out.println();
        }
    }
}
