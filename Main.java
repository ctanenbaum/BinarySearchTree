package binarySearchTrees;

public class Main {

	public static void main(String[] args) {
			BinaryTree bst = new BinaryTree();
			int[] array = new int[20];
			System.out.println("Array: ");
			for (int i = 0; i < 20; i++) {
				int rand = (int) (Math.random() * (100) + 1);
				bst.insertRecur(rand);
				array[i] = rand;
				System.out.print(rand + ", ");

			}

			for (int j = 0; j < 20; j++) {
				System.out.println("\nInOrder: ");
				bst.traverseInOrder();
				bst.removeVal(array[j]);
			}
			// if there were duplicates it removes both at once

		}

	}
