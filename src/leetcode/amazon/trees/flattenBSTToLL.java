package leetcode.amazon.trees;
/*Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.*/
public class flattenBSTToLL {

   /*If you notice carefully in the flattened tree, each node’s right child points to the next node of a pre-order traversal.

Now, if a node does not have left node, then our problem reduces to solving it for the node->right.
If it does, then the next element in the preorder traversal is the immediate left child. But if we make the immediate left child as the right child of the node, then the right subtree will be lost. So we figure out where the right subtree should go. In the preorder traversal, the right subtree comes right after the rightmost element in the left subtree.
So we figure out the rightmost element in the left subtree, and attach the right subtree as its right child. We make the left child as the right child now and move on to the next node.

*/
    public TreeNode flatten(TreeNode a, TreeNode tail) {
        if (a == null)
            return tail;

        tail = flatten(a.right, tail);
        a.right = flatten(a.left, tail);
        a.left = null;
        return a;
    }

    public TreeNode flatten(TreeNode a) {
        return flatten(a, null);
    }
}
