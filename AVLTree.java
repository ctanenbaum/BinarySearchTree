package binarySearchTrees;

public class AVLTree<T extends Comparable<T>> {
	private BNode<T> root;

	public void insertRecur(T data) {
		BNode<T> tree = root;
		if (root == null) {
			root = new BNode<T>(data);

		} else {
			add(tree, data);
		}
	}

	private void add(BNode<T> tree, T data) {
		if ((tree.getData()).compareTo(data) > 0) {
			if (tree.getRC() == null) {
				tree.setRC(tree);
				return;
			}
		} else {
			if (tree.getLC() == null) {
				tree.setLC(tree);
				return;
			} else {
				return;
			}
		}

	}

	public BNode<T> leftRotate(BNode<T> node) {
		BNode<T> right = node.getRC();
		BNode<T> temp = right;
		BNode<T> tempLeft = temp.getLC();
		right = temp.getLC();
		tempLeft = node;
		return temp;
	}

	public BNode<T> rightRotate(BNode<T> node) {
		BNode<T> left = node.getLC();
		BNode<T> temp = left;
		BNode<T> tempRight = temp.getRC();
		left = temp.getRC();
		tempRight = node;
		return temp;
	}
}
