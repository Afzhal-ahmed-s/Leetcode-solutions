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
        int max = -100000; int count = 0;
    
        public int goodNodes(TreeNode root) {
        
        DFS(root, max);
        return count;
        }
    
        public void DFS(TreeNode root, int max){
        if(root == null)return;

        if(root.val >= max)count++;
        
        DFS(root.left, Math.max(root.val, max));
        DFS(root.right, Math.max(root.val, max));
    }
}