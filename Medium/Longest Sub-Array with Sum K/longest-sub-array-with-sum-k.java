//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
    
    int maxLengthOfSubArray = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(int i=0; i<N; i++){
        sum += A[i];
        if(sum == K){
            maxLengthOfSubArray = Math.max(maxLengthOfSubArray, i+1);
        }
        
        int compliment = sum - K;
        
        if(map.containsKey(compliment)){
           maxLengthOfSubArray = Math.max(maxLengthOfSubArray, i - map.get(compliment) ); 
        }
        
        if(!map.containsKey(sum)){
            map.put(sum, i);
        }
    }
    return maxLengthOfSubArray;
    }
    
    
}


