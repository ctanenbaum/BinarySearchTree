package binarySearchTrees;

import java.util.Stack;


public class BinaryTree<T extends Comparable<T>> {  //created generic type
	private BNode<T> root;
	private boolean found; // used by remove methods

	public BinaryTree() {
		root = null; // empty tree
	}

	

	// recursive insert method
	public boolean insertRecur(T data) {
		BNode<T> tree = root;
		if (root == null) {
			root = new BNode<T>(data);
			return true;
		} else {
			return insertTryAgain(tree, data);
		}
	}

	private boolean insertTryAgain(BNode<T> root, T data) {
		if (data.compareTo(root.getData()) < 0) {
			// this data value belongs in left branch
			if (root.getLC() == null) {
				// left child is empty, insert data right there
				root.setLC(new BNode<T>(data));
				return true;
			} else {// find next available spot along left branch
				return insertTryAgain(root.getLC(), data);

			}
		} else

		if (data.compareTo(root.getData()) > 0) {
			// this data value belongs in right branch
			if (root.getRC() == null) {
				root.setRC(new BNode<T>(data));
				return true;

			} else { // find next available spot along right branch
				return insertTryAgain(root.getRC(), data);
			}
		}

		else
			return false; // duplicate value
	}

	public boolean removeVal(T value) {
		// to remove a value must start searching for it at the root
		root = removeNode(value, root);
		return found; // return value in instance variable set by private method
	}

	private BNode<T> removeNode(T value, BNode<T> tree) {
		// looks for value in the subtree
		if (tree == null)
			found = false;
		else if (value.compareTo(tree.getData()) < 0)
			// recursive call further down the left side of tree
			// might have to reset links if a node further down
			// is set to null
			tree.setLC(removeNode(value, tree.getLC()));
		else if (value.compareTo(tree.getData()) > 0)
			// recursive call further down the right side of the tree
			// might have to reset links if a node further down
			// is set to null
			tree.setRC(removeNode(value, tree.getRC()));
		else { // found the value , now remove that data from
				// the tree
			tree = removeData(tree);
			found = true;

		}
		return tree;
	}

	private BNode<T> removeData(BNode<T> tree) {
		// case 1 and 2: subtree just has one child branch so return that
		// branch and link that branch to previous
		// part of tree, basically eliminating the BNode
		// in which the data was found
		if (tree.getLC() == null)
			return tree.getRC();
		else if (tree.getRC() == null)
			return tree.getLC();
		else { // data is in a BNode that has two children.
				// It is too complicated to remove this type of Node
				// Instead do the following:
				// a. Replace the data in that BNode with data that
				// logically precedes that data - this data will be found in
				// a leaf BNode
				// b. eliminate the leaf BNode by reinvoking the
				// removeNode() method
			T data = findPredecessor(tree.getLC());
			tree.setData(data);
			tree.setLC(removeNode(data, tree.getLC()));
			return tree;

		}

	}

	private T findPredecessor(BNode<T> tree) {
		// the Node that contains data that precedes a Node
		// can be found by going down till one hits the right most leaf
		// of its left branch
		while (tree.getRC() != null) {
			tree = tree.getRC();

		}
		return tree.getData();
	}

	// recursive traversals
	public void traversePreOrder() {
		System.out.print(root.getData() + ", ");
		traverseP(root.getLC());
		traverseP(root.getRC());

	}

	private void traverseP(BNode<T> root) {
		if (root == null)
			return; // anchor case
		System.out.print(root.getData() + ", ");
		traverseP(root.getLC());
		traverseP(root.getRC());

	}

	public void traverseInOrder() {
		traverseI(root.getLC());
		System.out.print(root.getData() + ", ");
		traverseI(root.getRC());
	}

	private void traverseI(BNode<T> root) {
		if (root == null)
			return; // anchor case
		traverseI(root.getLC());
		System.out.print(root.getData() + ", ");
		traverseI(root.getRC());

	}

	//post order traversal
	public void traversePostOrder() {	
		traversePo(root.getLC());
		traversePo(root.getRC());
		System.out.print(root.getData()  + ", ");

	}
    //recursive call on post order
	private void traversePo(BNode<T> root) {
		if (root == null)
			return; // anchor case		
		traverseP(root.getLC());
		traverseP(root.getRC());
		System.out.print(root.getData()  + ", ");

	}
	
}
