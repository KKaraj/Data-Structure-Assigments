class TreeNode{
	int value; 
	TreeNode left;
	TreeNode right;
	TreeNode(int value){ this.value= value; }
}


public class TrimBST {
	
     public void helper(TreeNode root, int low, int high) {
        if (root == null) return;
        //trim the left subtree
        while (root.left != null) {
            if (root.left.value < low) 
            	root.left = root.left.right; //if left child value is too small, skip it and move to its right child
            else if (root.left.value > high) 
            	root.left = root.left.left; //if left child value is too big, skip it and move to its left child
            else break; //left child is within range
        }
        //trim the right subtree
        while (root.right != null) {
            if (root.right.value < low) 
            	root.right = root.right.right; //if right child value is too small, skip it and move to its right child
            else if (root.right.value > high) 
            	root.right = root.right.left; //if right child value is too big, skip it and move to its left child
            else break;
        }
        //recurse on left and right subtrees
        helper(root.left, low, high);
        helper(root.right, low, high);  
     }
     public TreeNode trimBST(TreeNode root, int low, int high) {
    	 //create a dummy parent node to simplify edge cases, such as trimming the root
         TreeNode parent = new TreeNode(Integer.MAX_VALUE);
         parent.left = root;
         helper(parent, low, high); //call the helper method to perform the trimming starting from the dummy parent
         return parent.left;
     }

     //utility method to perform an in-order traversal and print the values of the tree
     private static void printInOrder(TreeNode node) {
         if (node == null) return; //Base case
         printInOrder(node.left); //recursively print the left subtree
         System.out.print(node.value + " ");
         printInOrder(node.right); //recursively print the left subtree
     }
     
     public static void main(String[] args) {
    	 
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(0);
         root.right = new TreeNode(2);
         root.left.right = new TreeNode(0);
         root.left.right.left = new TreeNode(0);

         System.out.println("Input Tree: [1, 0, 2]");
         System.out.println("Low = 1, High = 2");
       
         TrimBST solution = new TrimBST();
         TreeNode trimmed = solution.trimBST(root, 1, 2);

         System.out.print("Output Tree : ");
         printInOrder(trimmed); 

    }
}
