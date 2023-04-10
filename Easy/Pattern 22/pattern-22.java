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
            obj.printSquare(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printSquare(int n) {
        int[][] arr = new int[(2*n)-1][(2*n)-1];
        
        int sr=0; int er= (2*n)-2; int sc=0; int ec= (2*n)-2; int number = n;

        while(sr <= ec && sc <= ec){
            for(int i=sc; i<=ec; i++){
                arr[sr][i] = number;
            }
            sr++;
            
            for(int i=sr; i<=er; i++){
                arr[i][sc] = number;
            }
            sc++;
            
            for(int i=sc; i<=ec; i++){
                arr[er][i]=number;
            }
            er--;
            
            for(int i=sr; i<=er; i++){
                arr[i][ec] = number;
            }
            ec--;
            number--;
        }
        
        
        
        for(int i=0; i< 2*n -1; i++){
         
        for(int j=0; j< 2*n -1; j++){
            System.out.print(arr[i][j]+" ");
        } 
        System.out.println();
        }
    }
}