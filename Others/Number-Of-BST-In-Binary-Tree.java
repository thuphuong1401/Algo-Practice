/*
// https://www.geeksforgeeks.org/count-the-number-of-binary-search-trees-present-in-a-binary-tree/
Very nice problem, reinforces the thinking model that for every binary tree related problems, always think about recursion, and passing the root
in the answer function. How does the root interact with its left & right child? How does null and leaves affect the end result?
Also, learn by heart the following property of a BST:
- leftMax < root.val < rightMin
- root is a BST iff root.left is a BST && root.right is a BST

The recurrence relation for this problem:
numBST(root) is:
- if leftMax < root.val < rightMin: numBST(root) = numBST(root.left) + numBST(root.right) + 1
- else: numBST(root) = numBST(root.left) + numBST(root.right)
Edge cases:
- numBST(leaves) = 1
- numBST(null) = 0

Update min & max value in the subtree rooted at current node in every recursion call (to check for BST property)
*/
