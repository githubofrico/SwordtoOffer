package cn.edu.tju.rico.inttree;

import cn.edu.tju.rico.inttree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree("1(2(4,5(7(9,10),12)),3(6(,8(,11)),))");
//		tree.createBinaryTree("A(B(D,E(G(I,J),M)),C(F(,H(,K)),))");

		System.out.println();
		System.out.println("tree的层次(广序)遍历 ： " + tree.levelOrder());
		System.out.println("\n----------------------------------------------\n");
		System.out.println("tree的前序遍历 (递归)： " + tree.preOrder(tree.getRoot()));
		System.out.println("tree的前序遍历 (迭代)： " + tree.preOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的中序遍历 (递归)： " + tree.inOrder(tree.getRoot()));
		System.out.println("tree的中序遍历 (迭代)： " + tree.inOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的后序遍历 (递归)： " + tree.postOrder(tree.getRoot()));
		System.out.println("tree的后序遍历 (迭代)： " + tree.postOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的根结点 ： " + tree.getRoot());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的高度 ： " + tree.height(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的结点数 ： " + tree.size(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 复制并构造树
		BinaryTree tree2 = new BinaryTree(tree.getRoot());
		System.out.println("tree为 ： " + tree.getBinaryTree(tree.getRoot()));
		System.out.println("复制tree为tree2 ： " + tree2.getBinaryTree(tree2.getRoot()));
		// 判断 tree2 与 tree 是否相等
		System.out.println("tree2 与 tree 是否相等: " + tree.equals(tree2));
		System.out.println("\n----------------------------------------------\n");

		// 构建tree1
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree("1(2(4,5(7(9,10),)),3(6(,8(,11)),))");
		System.out.println("tree为 ： " + tree.getBinaryTree(tree.getRoot()));
		System.out.println("构建tree1为 ： " + tree1.getBinaryTree(tree1.getRoot()));
		// 判断 tree1 与 tree 是否相等
		System.out.println("tree1 与 tree 是否相等: " + tree.equals(tree1));
		System.out.println("\n----------------------------------------------\n");

		// 根据前序遍历创建树
		BinaryTree tree3 = new BinaryTree(
				"123##45#6##7###".toCharArray());
		System.out.println("根据前序遍历创建二叉树: " + tree3.getBinaryTree(tree3.getRoot()));
		System.out.println("前序遍历tree3： " + tree.preOrder(tree3.getRoot()));
		System.out.println("中序遍历tree3： " + tree.inOrder(tree3.getRoot()));
		System.out.println("后序遍历tree3： " + tree.postOrder(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 以广义表的形式打印二叉树
		System.out.println("以广义表的形式打印tree为 ：" + tree.getBinaryTree(tree.getRoot()));
		System.out.println("以广义表的形式打印tree1为 ：" + tree1.getBinaryTree(tree1.getRoot()));
		System.out.println("以广义表的形式打印tree2为 ：" + tree2.getBinaryTree(tree2.getRoot()));
		System.out.println("以广义表的形式打印tree3为 ：" + tree3.getBinaryTree(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 根据tree的先序遍历和中序遍历结果构建树
		String pre = tree.preOrder().replace(" ", "");
		String in = tree.inOrder().replace(" ", "");
		BinaryTree tree4 = new BinaryTree(pre, in, true);
		System.out.println("根据tree的先序遍历和中序遍历结果构建的tree4为 ："
				+ tree.getBinaryTree(tree4.getRoot()));
		System.out.println("tree与tree4是否相等： " + tree.equals(tree4));
		System.out.println("\n----------------------------------------------\n");
		
		// 根据tree的中序遍历和后序遍历结果构建树
		String post = tree.postOrder().replace(" ", "");
		BinaryTree tree5 = new BinaryTree(in, post, false);
		System.out.println("根据tree的中序遍历和后序遍历结果构建的tree5为 ："
				+ tree.getBinaryTree(tree5.getRoot()));
		System.out.println("tree与tree5是否相等： " + tree.equals(tree5));
		System.out.println("\n----------------------------------------------\n");
		
		BinaryTree tree19 = new BinaryTree();
		tree19.createBinaryTree("8(6(5,7),2(9,4))");
		System.out.println("以广义表的形式打印tree19为 ：" + tree19.getBinaryTree(tree19.getRoot()));
		System.out.println(tree19.getRoot());
		tree19.Mirror1(tree19.getRoot());
		System.out.println("以广义表的形式打印tree19为 ：" + tree19.getBinaryTree(tree19.getRoot()));
		tree19.Mirror(tree19.getRoot());
		System.out.println("以广义表的形式打印tree19为 ：" + tree19.getBinaryTree(tree19.getRoot()));
		
		
	}
}
