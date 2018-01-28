package test;

import static org.junit.Assert.*;

import org.junit.Test;

import easy.MergeTwoBinaryTrees;
import easy.TreeNode;

public class MergeTwoBinaryTreesTest {

	@Test
	public void testMergeTrees() {
		// Arrange
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		
		// Act
		TreeNode mergedTree = MergeTwoBinaryTrees.mergeTrees(t1, t2);
		
		// Assert
		assertNotNull(mergedTree);
		assertEquals(3, mergedTree.val);
		assertEquals(4, mergedTree.left.val);
		assertEquals(5, mergedTree.right.val);
		assertEquals(5, mergedTree.left.left.val);
		assertEquals(4, mergedTree.left.right.val);
		assertNull(mergedTree.right.left);
		assertEquals(7, mergedTree.right.right.val);
		
	}

}
