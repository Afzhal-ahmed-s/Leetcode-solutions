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
    Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;

        for(int a=0; a<inorder.length; a++){
            m.put(inorder[a], a);
        }
        
        return helper(preorder, 0, 0, inorder.length-1);
        
    }
    
    public TreeNode helper(int[] preorder, int preorderIndex, int inorderStart, int inorderEnd){
        if(preorderIndex > preorder.length-1 || inorderStart > inorderEnd)return null;
        
        int currPreOrderVal = preorder[preorderIndex];
        int mid = m.get(currPreOrderVal);
        TreeNode node = new TreeNode(currPreOrderVal);
        
        node.left = helper(preorder, preorderIndex + 1, inorderStart, mid-1);
        node.right = helper(preorder, preorderIndex + (mid - inorderStart) + 1, mid+1, inorderEnd);
        
        return node;
    }
}