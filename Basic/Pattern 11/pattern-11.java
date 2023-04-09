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
        for(int i=0; i<n; i++){

                if(i%2 == 0){
                    for(int j=0; j<i+1; j++){
                    if(j%2==0)System.out.print(1+" ");
                    else System.out.print(0+" ");
                    }
                }
                else{
                    for(int j=0; j<i+1; j++){
                    if(j%2==0)System.out.print(0+" ");
                    else System.out.print(1+" ");
                    }
                }
            System.out.println();
        }
    }
}