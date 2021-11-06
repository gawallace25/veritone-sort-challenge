# Solution Description

In this implementation, the binary search tree's datastructure is a network of [nodes](https://github.com/gawallace25/veritone-sort-challenge/blob/node-implementation/app/src/main/java/veritone/sort/challenge/BinarySearchTreeNode.java), each node having no more than two descendents. The BinarySearchTree class simply stores [a pointer to the root node of the tree](https://github.com/gawallace25/veritone-sort-challenge/blob/node-implementation/app/src/main/java/veritone/sort/challenge/BinarySearchTree.java#L14). Adding elements to the tree involves [visiting each node starting at the root, iteratively descending the tree until an empty spot is found for the new value to be inserted](https://github.com/gawallace25/veritone-sort-challenge/blob/node-implementation/app/src/main/java/veritone/sort/challenge/BinarySearchTree.java#L34-L50).

This differs from the alternative solution on the main branch, in which each element of the tree is [represented as its own subtree](https://github.com/gawallace25/veritone-sort-challenge/blob/main/app/src/main/java/veritone/sort/challenge/BinarySearchTree.java#L22-L27). This changes the method of traversal through the tree to insert elements, as now the tree itself must visit each node in a while loop until the element is inserted. The [algorithm used to determine the deepest nodes](https://github.com/gawallace25/veritone-sort-challenge/blob/main/app/src/main/java/veritone/sort/challenge/BinarySearchTree.java#L92) remains unchanged.

# Application Description

This is an application that builds a binary search tree of integers from an input file, displays the tree in ASCII format, and determines the deepest nodes in the tree along with their depth.

# How To Run

## Mac OS and Linux

`./gradlew build`

`./gradlew run --args="input.txt"`

## Windows

`gradlew.bat build`

`gradlew.bat run --args="input.txt"`

# Input File

The [input file](https://github.com/gawallace25/veritone-sort-challenge/blob/main/app/input.txt) contains a set of integers that will be read into the tree. Each line of the file should contain one integer.

Example:

    12
    18
    3
    7
    45
    32
    57
    22
    19
    8
    4
    10
    42
