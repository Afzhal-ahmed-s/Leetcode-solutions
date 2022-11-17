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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<>();
        Queue <TreeNode> queue = new LinkedList<>();
        
        if(root == null)return answer;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            List<Integer> temp = new ArrayList<>();
            int len =  queue.size();
            
            for(int i=0; i< len; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
    
            answer.add(temp);
           
        }
        return answer;
    }
}