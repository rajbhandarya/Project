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

    public void insertWordRec(Node object){
        if (root == null){
            root = object;
            return;
        }
        Node current = root;
        System.out.println("loop");
        if (current.word.compareTo(object.word)>0 && current.left == null){
            current.left = object;
            System.out.println("hohoho");
            return;
        }
        if (current.word.compareTo(object.word)<0 && current.right == null){
            current.right = object;
            System.out.println("hohoho");
            return;
        }
        if (current.word.compareTo(object.word)>0){
            insertWordRec(current.left);
        }
        
        else if (current.word.compareTo(object.word)<0){
            insertWordRec(current.right);
        }
        

    }


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
        map.insertWordRec(root);
        map.insertWordRec(node);
        map.insertWordRec(node2);
        map.insertWordRec(node3);
        map.insertWordRec(node4);
        map.insertWordRec(node5);
        printInOrder(root);

    }
}
