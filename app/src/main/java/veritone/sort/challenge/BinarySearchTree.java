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

	/**
	 * node value
	 */
	private T value;

	/**
	 * Child whose value is less than the current node
	 */
	private BinarySearchTree<T> lesserChild = null;

	/**
	 * Child whose value is greater than the current node
	 */
	private BinarySearchTree<T> greaterChild = null;

	/**
	 * Construct a new instance
	 * 
	 * @param value the node's value
	 */
	public BinarySearchTree(final T value) {
		this.value = value;
	}

	/**
	 * Add an element to the tree
	 * 
	 * @param element the element to add
	 */
	public void addElement(final T element) {
		if (element.compareTo(value) < 0) {
			if (lesserChild == null) {
				lesserChild = new BinarySearchTree<>(element);
			} else {
				lesserChild.addElement(element);
			}
		} else if (element.compareTo(value) > 0) {
			if (greaterChild == null) {
				greaterChild = new BinarySearchTree<>(element);
			} else {
				greaterChild.addElement(element);
			}
		}
	}

	/**
	 * Get the value of the current node
	 * 
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Get the subtree whose root node's value is less than the current node
	 * 
	 * @return lesser subtree
	 */
	public BinarySearchTree<T> getLesserChild() {
		return lesserChild;
	}

	/**
	 * Get the subtree whose root node's value is greater than the current node
	 * 
	 * @return the greater subtree
	 */
	public BinarySearchTree<T> getGreaterChild() {
		return greaterChild;
	}

	/**
	 * Determines the deepest nodes in the BST along with their depth.
	 * 
	 * @return a set of key-value pairs, the key is the node, the value is the
	 * node's depth
	 */
	public Map<T, Integer> getDeepestNodes() {
		final Map<T, Integer> leaves = new HashMap<>();

		addLeavesToMap(this, leaves, 0);

		int deepest = 0;
		for (final T currentLeafNode : leaves.keySet()) {
			if (leaves.get(currentLeafNode) > deepest) {
				deepest = leaves.get(currentLeafNode);
			}
		}

		// build a new list consisting only of nodes with the depth determined to be the
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
	private void addLeavesToMap(final BinarySearchTree<T> tree, final Map<T, Integer> leaves, final int currentDepth) {
		if (tree.getLesserChild() == null && tree.getGreaterChild() == null) {
			leaves.put(tree.getValue(), currentDepth);
			return;
		}

		if (tree.getLesserChild() != null) {
			addLeavesToMap(tree.getLesserChild(), leaves, currentDepth + 1);
		}

		if (tree.getGreaterChild() != null) {
			addLeavesToMap(tree.getGreaterChild(), leaves, currentDepth + 1);
		}
	}
}
