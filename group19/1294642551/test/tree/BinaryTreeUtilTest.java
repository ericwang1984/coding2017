package tree;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class BinaryTreeUtilTest {

	BinaryTreeNode<Integer> root = null;
	@Before
	public void setUp() throws Exception {
		root = new BinaryTreeNode<Integer>(1);
		root.setLeft(new BinaryTreeNode<Integer>(2));
		root.setRight(new BinaryTreeNode<Integer>(5));
		root.getLeft().setLeft(new BinaryTreeNode<Integer>(3));
		root.getLeft().setRight(new BinaryTreeNode<Integer>(4));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPreOrderVisit() {
		
		List<Integer> result = BinaryTreeUtil.preOrderVisit(root);
		Assert.assertEquals("[1, 2, 3, 4, 5]", result.toString());
		
		
	}
	@Test
	public void testInOrderVisit() {
		
		
		List<Integer> result = BinaryTreeUtil.inOrderVisit(root);
		Assert.assertEquals("[3, 2, 4, 1, 5]", result.toString());		
		
	}
	
	@Test
	public void testPostOrderVisit() {
		
		
		List<Integer> result = BinaryTreeUtil.postOrderVisit(root);
		Assert.assertEquals("[3, 4, 2, 5, 1]", result.toString());		
		
	}
	
	
	@Test
	public void testInOrderVisitWithoutRecursion() {
		BinaryTreeNode<Integer> node = root.getLeft().getRight();
		node.setLeft(new BinaryTreeNode<Integer>(6));
		node.setRight(new BinaryTreeNode<Integer>(7));
		
		List<Integer> result = BinaryTreeUtil.inOrderWithoutRecursion(root);
		Assert.assertEquals("[3, 2, 6, 4, 7, 1, 5]", result.toString());	
		
		{//补充测试
			node = root.getRight();
			node.setLeft(new BinaryTreeNode<Integer>(8));
			node.setRight(new BinaryTreeNode<Integer>(9));
			result = BinaryTreeUtil.inOrderWithoutRecursion(root);
			Assert.assertEquals("[3, 2, 6, 4, 7, 1, 8, 5, 9]", result.toString());
		}
		
		{//补充测试2
			node = root.getRight().getLeft();
			node.setLeft(new BinaryTreeNode<Integer>(10));
			node.setRight(new BinaryTreeNode<Integer>(11));
			result = BinaryTreeUtil.inOrderWithoutRecursion(root);
			Assert.assertEquals("[3, 2, 6, 4, 7, 1, 10, 8, 11, 5, 9]", result.toString());
		}
		
		{//测试方法2

			List<Integer> result2 = BinaryTreeUtil.inOrderWithoutRecursion2(root);
			Assert.assertEquals("[3, 2, 6, 4, 7, 1, 10, 8, 11, 5, 9]", result2.toString());
		}
		
	}
	@Test
	public void testPreOrderVisitWithoutRecursion() {
		BinaryTreeNode<Integer> node = root.getLeft().getRight();
		node.setLeft(new BinaryTreeNode<Integer>(6));
		node.setRight(new BinaryTreeNode<Integer>(7));
		
		List<Integer> result = BinaryTreeUtil.preOrderWithoutRecursion(root);
		Assert.assertEquals("[1, 2, 3, 4, 6, 7, 5]", result.toString());	
		
		{//测试方法2
			List<Integer> result2 = BinaryTreeUtil.preOrderWithoutRecursion2(root);
			Assert.assertEquals("[1, 2, 3, 4, 6, 7, 5]", result2.toString());
		}
		
	}
}
