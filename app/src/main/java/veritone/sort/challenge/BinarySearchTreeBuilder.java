package veritone.sort.challenge;

import java.util.List;

public class BinarySearchTreeBuilder {

	private static BinarySearchTreeBuilder builder;

	private BinarySearchTreeBuilder() {

	}

	public static BinarySearchTreeBuilder getBuilder() {
		if (builder == null) {
			builder = new BinarySearchTreeBuilder();
		}

		return builder;
	}

	public <T extends Comparable<T>> BinarySearchTree<T> buildFromList(final List<T> values) {
		BinarySearchTree<T> tree = null;
		for (final T currentValue : values) {

			// we're initializing the root node here
			if (tree == null) {
				tree = new BinarySearchTree<>(currentValue);
			} else {
				tree.addElement(currentValue);
			}
		}

		return tree;
	}
}
