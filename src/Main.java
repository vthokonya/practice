import java.util.*;

public class Main {
    // Root of Binary Tree
    Node root;
    int depth = 0;
    Main() { root = null; }
    public static void main(String[] args) {
        Main tree = new Main();
        tree = tree.init(tree);
        // Function call
        System.out.println(
                "Inorder traversal of binary tree is ");
        //tree.printInorder(tree.root);
        //tree.printRightView();
        tree.kthAncestor(1, 5);
    }

    private Main init(Main tree){
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.right.left = new Node(21);
        //tree.root.left.left.left = new Node(2);
        //tree.root.left.left.right = new Node(5);
        //tree.root.left.right.left = new Node(8);
        //tree.root.left.right.right = new Node(11);
        //tree.root.left.left.right.left = new Node(4);
        //tree.root.left.right.left.left = new Node(7);
        //tree.root.left.right.right = new Node(8);
        return tree;
    }
    // Given a binary tree, print its nodes in inorder
    void printInorder(Node node)
    {
        if (node == null)
            return;

        // Then print the data of node
        System.out.print(node.key + " ");

        // First recur on left child
        printInorder(node.right);

        // Now recur on right child
        printInorder(node.left);
    }

    void printRightView(){
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(queue.size()>0){
            int count = queue.size();
            while(count-- > 0){
                Node val = queue.remove();
                if(count==0){
                    System.out.print(val.key + " ");
                }
                if(val.left != null)
                    queue.add(val.left);
                if(val.right != null)
                    queue.add(val.right);
            }
        }
    }

    void findSpiral(){
        if(root==null)
            return;
        List<Node> queue = new ArrayList<Node>();
        List<Node> leftQueue = new ArrayList<Node>();
        List<Node> rightQueue = new ArrayList<Node>();
        queue.add(root);
        int level = 0;
        while(queue.size()>0){
            int count = queue.size();
            System.out.print("("+count+")");
            while(count-- > 0) {
                Node val = queue.remove(0);
                System.out.print(val.key + " ");
                Queue<Node> temp = new LinkedList<Node>();
                Queue<Node> temp1 = new LinkedList<Node>();
                if(level%2 != 0){
                    temp1.addAll(rightQueue);
                    rightQueue.clear();
                    if (val.right != null)
                        temp.add(val.right);
                    if (val.left != null)
                        temp.add(val.left);
                    rightQueue.addAll(temp);
                    rightQueue.addAll(temp1);
                }else {
                    temp1.addAll(leftQueue);
                    leftQueue.clear();
                    if (val.left != null)
                        temp.add(val.left);
                    if (val.right != null)
                        temp.add(val.right);
                    leftQueue.addAll(temp);
                    leftQueue.addAll(temp1);
                }
            }
            if(level++%2 == 0){
                queue.addAll(rightQueue);
                queue.addAll(leftQueue);
            }else{
                queue.addAll(leftQueue);
                queue.addAll(rightQueue);
            }
            rightQueue.clear();
            leftQueue.clear();
        }
    }

    void kthAncestor(int k, int node){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> ancestors = new ArrayList<Integer>();
        queue.add(root);
        ancestors.add(0);
        ancestors.add(root.key, -1);
        while(queue.size() > 0){
            int count = queue.size();
            while(count-- > 0){
                Node temp = queue.remove();
                System.out.print(temp.key + " ");
                if(temp.left != null){
                    queue.add(temp.left);
                    ancestors.add(temp.left.key, temp.key);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    ancestors.add(temp.right.key, temp.key);
                }
            }
        }
        int ancestor = node;
        while(k-- > 0){
            ancestor = ancestors.get(ancestor);
        }
        System.out.println("the " + k + " ancestor is " + ancestor);
    }

    // Class containing left and right child of current
// node and key value
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
}