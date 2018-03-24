package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import easy.MaximumDepthOfBinaryTree;
import easy.TreeNode;

public class MaximumDepthOfBinaryTreeTest {
	MaximumDepthOfBinaryTree max;
	TreeNode tree;
	static final int expectedResult = 3;

	@Before
	public void setup() {
		tree = new TreeNode(3);
		tree.right = new TreeNode(9);
		tree.left = new TreeNode(20);

		tree.left.right = new TreeNode(15);
		tree.left.left = new TreeNode(7);
		max = new MaximumDepthOfBinaryTree();
	}

	@Test
	public void maxDepthRecursiveReturnsSuccessfully() {
		// Act
		int actualResult = max.maxDepthRecursive(tree);

		// Assert
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void maxDepthIterativeReturnsSuccessfully() {
		// Act
		int actualResult = max.maxDepthIterative(tree);

		// Assert
		assertEquals(expectedResult, actualResult);
	}

}
