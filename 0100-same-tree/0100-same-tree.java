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
    boolean ans = true;
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        DFS(p, q);
        return ans;
    }
    
    public void DFS (TreeNode p, TreeNode q){
        if(p == null && q != null || q == null && p != null){
            ans = false;
            return;
        }
        if(p == null)return;
        if(p.val != q.val)ans = false;
        
        DFS(p.left, q.left);
        DFS(p.right, q.right);
        return;
    } 
}