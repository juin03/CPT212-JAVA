import java.util.LinkedList;
import java.util.Queue;

// Define the Node class
class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// BFS implementation within a BinaryTree class
class BinaryTree<T> {
    Node<T> root;

    public BinaryTree(T rootValue) {
        this.root = new Node<>(rootValue);
    }

    // Method to perform BFS traversal
    public void breadthFirstSearch() {
        if (root == null) {
            return;
        }

        // Create a queue for BFS
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Dequeue a node from the front of the queue
            Node<T> current = queue.poll();

            // Process (visit) the current node
            visit(current);

            // Enqueue the left child
            if (current.left != null) {
                queue.add(current.left);
            }

            // Enqueue the right child
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // This method will process the node in whatever way you want
    private void visit(Node<T> node) {
        System.out.print(node.value + " ");
    }
}

// Main class to demonstrate the BFS algorithm
public class BFSExample {
    public static void main(String[] args) {
        // Create an example binary tree
        BinaryTree<String> tree = new BinaryTree<>("A");
        tree.root.left = new Node<>("B");
        tree.root.right = new Node<>("C");
        tree.root.left.left = new Node<>("D");
        tree.root.left.right = new Node<>("E");
        tree.root.right.right = new Node<>("F");

        // Perform BFS traversal
        System.out.print("Breadth-First Search traversal: ");
        tree.breadthFirstSearch();
    }
}
