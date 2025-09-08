public class GoodNodes {
	static class TreeNode {
	    int value;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int x) { value = x; }
	}
	
    private int ans = 0;
    public int goodNodes(TreeNode root) {
        DFS(root, -100000); //start DFS from the root with a very low initial max value
        return ans;
    }
    
    //helper DFS method to count good nodes
    private void DFS(TreeNode root, int max) {
        if (root == null)  return; //Base case: empty node

        //if current node's value is greater than or equal to max seen so far on the path
        if (max <= root.value) {
            ans++; //count this node as "good"
            max = root.value; //update the max value
        }
        //recurse to the left and right subtrees
        DFS(root.left, max);
        DFS(root.right, max);
    }
	    

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Input Tree: [3, 1, 4, 3, null, 1, 5]");
        GoodNodes solution = new GoodNodes();
        int result = solution.goodNodes(root);
        System.out.println("Number of good nodes: " + result);
    
    }       
}
	
