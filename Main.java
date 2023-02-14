package binarySearchTrees;

public class Main {

	public static void main(String[] args) {
			BinaryTree bst = new BinaryTree();
			int[] array = new int[20];
			System.out.println("Array: "); //created a random integer array
			for (int i = 0; i < 20; i++) {
				int rand = (int) (Math.random() * (100) + 1);
				bst.insertRecur(rand);  //added random integer to the tree
				array[i] = rand;
				System.out.print(rand + ", ");  //printed the original array

			}

			for (int j = 0; j < 20; j++) {
				System.out.println("\nInOrder: ");  //printed the array in order each time
				bst.traverseInOrder();
				bst.removeVal(array[j]);  //remove one value at a time 
			}
			// if there were duplicates it removes both at once

		}

	}
