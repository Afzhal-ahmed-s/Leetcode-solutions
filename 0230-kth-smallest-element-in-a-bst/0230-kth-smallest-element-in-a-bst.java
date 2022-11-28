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
    
    int count =0;
    int result = Integer.MIN_VALUE;
    boolean done = false;
    
    public int kthSmallest(TreeNode root, int k) {
        
        DFS(root, k);
        return result;
        
    }
    
    public void DFS(TreeNode root, int k){
        if(done == true || root == null)return;
        
        DFS(root.left, k);
        count++;
        if(count == k){
            done = true;
            result = root.val;
        }
        DFS(root.right, k);
    }
}