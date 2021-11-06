package veritone.sort.challenge;

public class BinarySearchTreeNode<T extends Comparable<T>> {

	/**
	 * node value
	 */
	private T value;

	/**
	 * Child whose value is less than the current node
	 */
	private BinarySearchTreeNode<T> lesserChild = null;

	/**
	 * Child whose value is greater than the current node
	 */
	private BinarySearchTreeNode<T> greaterChild = null;

	public BinarySearchTreeNode(final T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public BinarySearchTreeNode<T> getLesserChild() {
		return lesserChild;
	}

	public BinarySearchTreeNode<T> getGreaterChild() {
		return greaterChild;
	}

	public void setLesserChild(final BinarySearchTreeNode<T> lesserChild) {
		this.lesserChild = lesserChild;
	}

	public void setGreaterChild(final BinarySearchTreeNode<T> greaterChild) {
		this.greaterChild = greaterChild;
	}
}
