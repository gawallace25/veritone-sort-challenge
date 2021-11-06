package veritone.sort.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * A binary search tree, where values less than the parent are on the left, and
 * values greater are on the right.
 *
 * @param <T> type of value stored in each node of the tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BinarySearchTreeNode<T> root = null;

	public BinarySearchTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Add an element to the tree
	 * 
	 * @param element the element to add
	 */
	public void addElement(final T element) {
		final BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<>(element);
		if (root == null) {
			root = newNode;
			return;
		}

		boolean inserted = false;
		BinarySearchTreeNode<T> current = root;
		while (!inserted) {
			if (element.compareTo(current.getValue()) < 0) {
				if (current.getLesserChild() == null) {
					current.setLesserChild(newNode);
					inserted = true;
				} else {
					current = current.getLesserChild();
				}
			} else {
				if (current.getGreaterChild() == null) {
					current.setGreaterChild(newNode);
					inserted = true;
				} else {
					current = current.getGreaterChild();
				}
			}
		}
	}

	/**
	 * Determines the deepest nodes in the BST along with their depth.
	 * 
	 * @return a set of key-value pairs, the key is the node, the value is the
	 * node's depth
	 */

	public Map<T, Integer> getDeepestNodes() {
		final Map<T, Integer> leaves = new HashMap<>();

		int deepest = 0;
		addLeavesToMap(root, leaves, 0, deepest);

		for (final T currentLeafNode : leaves.keySet()) {
			if (leaves.get(currentLeafNode) > deepest) {
				deepest = leaves.get(currentLeafNode);
			}
		}

		// build a new list consisting only of nodes with the depth determined to be
		// deepest
		final Map<T, Integer> deepestNodes = new HashMap<>();
		for (final T currentLeafNode : leaves.keySet()) {
			if (leaves.get(currentLeafNode) == deepest) {
				deepestNodes.put(currentLeafNode, leaves.get(currentLeafNode));
			}
		}

		return deepestNodes;
	}

	/**
	 * Utility method to recursively build a running list of leaf nodes, adding them
	 * to the key-value pair along with their depth
	 * 
	 * @param tree the tree to traverse
	 * @param leaves the running list of leaf nodes encountered during traversal
	 * @param currentDepth the current depth of the traversal
	 */

	private void addLeavesToMap(final BinarySearchTreeNode<T> tree, final Map<T, Integer> leaves,
			final int currentDepth, Integer deepest) {
		if (tree.getLesserChild() == null && tree.getGreaterChild() == null) {
			leaves.put(tree.getValue(), currentDepth);

			if (currentDepth > deepest) {
				deepest = currentDepth;
			}
			return;
		}

		if (tree.getLesserChild() != null) {
			addLeavesToMap(tree.getLesserChild(), leaves, currentDepth + 1, deepest);
		}

		if (tree.getGreaterChild() != null) {
			addLeavesToMap(tree.getGreaterChild(), leaves, currentDepth + 1, deepest);
		}
	}

}
