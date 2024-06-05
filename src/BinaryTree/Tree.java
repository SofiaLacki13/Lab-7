// Fig. 21.15: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
package BinaryTree;

// class TreeNode definition
class TreeNode<E extends Comparable<E>> {
   // package access members
   TreeNode<E> leftNode;
   E data; // node value
   TreeNode<E> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(E nodeData) {
      data = nodeData;              
      leftNode = rightNode = null; // node has no children
   } 

   // locate insertion point and insert new node; ignore duplicate values
   public void add(E insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) < 0) {
         // insert new TreeNode
         if (leftNode == null) {
            leftNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing left subtree recursively
            leftNode.insert(insertValue); 
         }
      } 
      // insert in right subtree
      else if (insertValue.compareTo(data) > 0) {
         // insert new TreeNode
         if (rightNode == null) {
            rightNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing right subtree recursively
            rightNode.insert(insertValue); 
         }
      } 
   } 

   public TreeNode<E> removeNode() {
      if (rightNode == null && leftNode == null) { //no children
         data = null;
      } else if (rightNode == null) { //only left child
         data = leftNode.data;
         leftNode.data = null;
      } else if (leftNode == null) { //only right child
         data = rightNode.data;
         rightNode.data = null;
      } else { //both children
         data = getMin();
      }
   }

   public TreeNode<E> getMin() {
      
   }

   public TreeNode<E> left() {
      return leftNode;
   }

   public TreeNode<E> right() {
      return rightNode;
   }
   public E data() {
      return data;
   }

   
} 

// class Tree definition
public class Tree<E extends Comparable<E>> {
   private TreeNode<E> root;

   // constructor initializes an empty Tree of integers
   public Tree() {root = null;}

   // insert a new node in the binary search tree
   public void insertNode(E insertValue) {
      if (root == null) {
         root = new TreeNode<E>(insertValue); // create root node
      }
      else {
         root.add(insertValue); // call the insert method
      }
   } 

   public void findRemoveNode(E removeValue) {
      if (root == null) {
         System.out.println("This tree is empty! We won't find anything!");
      }
      else {
         while (removeValue.compareTo(root.data()) != 0) {
            TreeNode<E> left = root.left();
            TreeNode<E> right = root.right();
            E data = root.data();
            
            if (removeValue.compareTo(data) < 0) {
            
               if (left != null) {
                  root = left;
               } else {
                  break;
               }
            }
            else if (removeValue.compareTo(data) > 0) {
               
               if (right != null) {
                  root = right;
               } else {
                  break;
               }
            }
            
         
         if (removeValue.compareTo(data) == 0) {
            removeNode(root, right, left)

         }
      }
   }

   public void removeNode(TreeNode<E> root, TreeNode<E>) {
      if (right == null && left == null) { //no children
         root = null;
      } else if (right == null) { //only left child
         root = left;
      } else if (left == null) {
         root = right;
      } else { //both children
         root = getMin();
      }
   }


   // begin preorder traversal 
   public void preorderTraversal() {preorderHelper(root);}

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }

      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree  
      preorderHelper(node.rightNode); // traverse right subtree
   } 

   // begin inorder traversal
   public void inorderTraversal() {inorderHelper(root);}

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }

      inorderHelper(node.leftNode); // traverse left subtree
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   } 

   // begin postorder traversal
   public void postorderTraversal() {postorderHelper(root);}

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }
  
      postorderHelper(node.leftNode); // traverse left subtree  
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data
   } 
}
