public class WordCountMap {
    /**
     * A class called WordCountMap consisting of a binary search
     * tree that maintains a record of words and their counts. 
     * (WordCountMap will make use of two very small classes called Node and WordCount described below.)
     */
    private Node root;
    private class Node<E extends Comparable<E>>{
        private String word;
        private int count;
        private Node left;
        private Node right;

        public Node(String word, int count, Node left, Node right){
            this.word = word;
            this.count = count;
            this.left = left;
            this.right = right;
    }
      }
    
    
    public void insertWord(Node object){
        if (root == null){
            root = object;
            return;
        }
        Node current = root;
        
        if (current.word.compareTo(object.word)>0){
            while (current.left != null && current.word.compareTo(object.word)>0){
            current = current.left;
            }
            if (current.word.compareTo(object.word)<0){
                current.right = object;
            }
            current.left = object;
        }
        if (current.word.compareTo(object.word)<0){
            while (current.right != null && current.word.compareTo(object.word)<0){
            current = current.right;
            }
            current.right = object;
        }
    }
    //no child, add to left or right based on compareTo
    //one child, add to left or right if it is null and in the right spot
        //if there is a child in the way, and the child is less than, keep going
        //if there is a child and the child is the wrong way, add it to the oppposite side of the child
        


    public void insertCount(Node object){
        if (root == null){
            root = object;
            return;
        }
        else{

        Node current = root;
        if (current.count >= object.count){
            current.right = object;

        }
        
        if (current.count < object.count){
            current.left = object;
        }
    }
    }

    public static void printInOrder(Node root){
        if (root == null){
            return;
        }
        Node current = root;
        printInOrder(current.left);
        System.out.println(current.word);
        // System.out.println(current.right.word);
        printInOrder(current.right);

    }

    //maybe create getData function to get the data the root contains

    public static void main(String[] args){
        WordCountMap map = new WordCountMap();
        Node root = map.new Node("apple", 2, null, null);
        Node node = map.new Node("banana", 1, null, null);
        Node node2 = map.new Node("aaron", 1, null, null);
        Node node3 = map.new Node("dog", 1, null, null);
        Node node4 = map.new Node("cat", 1, null, null);
        Node node5 = map.new Node("zebra", 1, null, null);
        map.insertWord(root);
        map.insertWord(node);
        map.insertWord(node2);
        map.insertWord(node3);
        map.insertWord(node4);
        map.insertWord(node5);
        System.out.println(node3.right.word);
        printInOrder(root);

    }
}
