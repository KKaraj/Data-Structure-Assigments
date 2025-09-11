
class Node {
    public int value;
    public List<Node> neighbors;

    public Node() {
        value = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int value) {
        this.value = value;
        neighbors = new ArrayList<>();
    }
    public Node(int value, List<Node> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }
}

//recursive method to perform DFS and clone the graph
public class CloneGraph {
    public void DFS(Node node, Node copy, Node[] visited) {
        visited[copy.value] = copy;
        //iterate through all the neighbors of the original node
        for (Node neighbor : node.neighbors) {
        	//if neighbor has not been visited
            if (visited[neighbor.value] == null) {
                Node newNode = new Node(neighbor.value);
                copy.neighbors.add(newNode);
                DFS(neighbor, newNode, visited);//recursively clone the neighbor
            } else {
                copy.neighbors.add(visited[neighbor.value]);//if neighbor was already cloned, add it directly to the copy's neighbors
            }
        }
    }
    //method to initiate the cloning of the graph
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        //create a copy of the starting node
        Node copy = new Node(node.value);
        //create an array to keep track of visited nodes, indexed by node value
        Node[] visited = new Node[101];
        //start DFS traversal and cloning form the input node
        DFS(node, copy, visited);
        return copy;
    }
    // helper to print the graph using BFS
    public static void printGraph(Node node, boolean[] visited) {
        if (node == null || visited[node.value]) return;
        visited[node.value] = true;
        System.out.print("Node " + node.value + " connected to: ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.value + " ");
        }
        System.out.println();
        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        System.out.println("Original graph:");
        boolean[] visitedOriginal = new boolean[101];
        printGraph(node1, visitedOriginal);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        System.out.println("\nCloned graph:");
        boolean[] visitedClone = new boolean[101];
        printGraph(clonedGraph, visitedClone);
    }
}
