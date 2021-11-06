/*
 */
package veritone.sort.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class App {

	/**
	 * Builds a sample tree, displays the tree to standard out, and prints the
	 * deepest nodes along with their depth
	 * 
	 * @param args command line args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("Input file must be provided");
			return;
		}

		final BinarySearchTreeBuilder builder = BinarySearchTreeBuilder.getBuilder();

		readListFromFile(args[0]);

		final List<Integer> values = readListFromFile(args[0]);

		final BinarySearchTree<Integer> tree = builder.buildFromList(values);

		printFullTree(tree);

		final Map<Integer, Integer> deepestNodes = tree.getDeepestNodes();

		System.out.println("Deepest nodes:");

		for (final Integer currentNodeToPrint : deepestNodes.keySet()) {
			System.out.println(
					String.format("Node: %s, Depth: %s", currentNodeToPrint, deepestNodes.get(currentNodeToPrint)));
		}

	}

	/**
	 * Read a list of integers from a file
	 * 
	 * @param filename name of the file
	 * @return list of integers retrieved from the file
	 * @throws IOException if we couldn't read from the file
	 */
	private static final List<Integer> readListFromFile(final String filename) throws IOException {
		final List<Integer> list = new ArrayList<>();

		final File file = new File(filename);
		final FileReader fileReader = new FileReader(file);
		final BufferedReader bufferedFileReader = new BufferedReader(fileReader);

		String line = bufferedFileReader.readLine();
		while (line != null) {
			list.add(Integer.parseInt(line));
			line = bufferedFileReader.readLine();
		}

		bufferedFileReader.close();

		return list;
	}

	/**
	 * Print the full binary tree
	 * 
	 * @param tree the tree to print
	 */
	private static void printFullTree(final BinarySearchTree<Integer> tree) {
		final Function<BinarySearchTreeNode<Integer>, String> getLabel = (nodeToPrint) -> {
			return nodeToPrint.getValue().toString();
		};

		final Function<BinarySearchTreeNode<Integer>, BinarySearchTreeNode<Integer>> getLeft = (nodeToPrint) -> {
			return nodeToPrint.getLesserChild();
		};

		final Function<BinarySearchTreeNode<Integer>, BinarySearchTreeNode<Integer>> getRight = (nodeToPrint) -> {
			return nodeToPrint.getGreaterChild();
		};

		final TreePrinter<BinarySearchTreeNode<Integer>> treePrinter = new TreePrinter<BinarySearchTreeNode<Integer>>(
				getLabel, getLeft, getRight);

		treePrinter.printTree(tree.getRoot());
	}
}
