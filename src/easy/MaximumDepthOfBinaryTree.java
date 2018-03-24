package easy;

import java.util.Stack;

/*
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

 */
 
public class MaximumDepthOfBinaryTree {
	/**
	 * Recursive Solution of finding the max depth
	 * 
	 * @param root
	 * @return the max depth of the binary tree
	 */
	public int maxDepthRecursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
	}
	
	/**
	 * Iterative approach to find the max depth of binary tree
	 * @param root
	 * @return
	 */
	
	public int maxDepthIterative(TreeNode root) {
		TreeNode node = root;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<>();
        
        int max = 0;
        int depth = 1;
        while (node != null || !nodeStack.isEmpty())
        {
            if (node != null)
            {
                nodeStack.push(node);
                depthStack.push(depth);
                node = node.left;
                depth++;
            }
            else
            {
                node = nodeStack.pop();
                depth = depthStack.pop();
                
                if (depth > max) max = depth;
                
                node = node.right;
                depth++;
            }
        }
        
        return max;
	}
}
