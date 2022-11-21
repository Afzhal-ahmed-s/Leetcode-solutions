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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int rightMostValueInEachLevel = -101;
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                
                if(rightMostValueInEachLevel == -101)rightMostValueInEachLevel = node.val;
                if(node.right != null)queue.add(node.right);
                if(node.left != null)queue.add(node.left);
            }
            ans.add(rightMostValueInEachLevel);
        }
     return ans;   
    }
}