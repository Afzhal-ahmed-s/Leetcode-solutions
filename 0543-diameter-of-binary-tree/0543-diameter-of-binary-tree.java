/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int ans = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
    DFS(root);      
    return ans;   
    }
    
    public int DFS(TreeNode root){
         if(root == null)return -1;
        
        int left = DFS(root.left);
        int right = DFS(root.right);
        
        ans = Math.max(ans, left + right + 2);
        return 1+ Math.max(left,right);
    }
}