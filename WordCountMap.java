import java.util.ArrayList;

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
    
    
/**
   * Returns a list of WordCount objects, one per word stored in this
   * WordCountMap, sorted alphabetically by word.
   */
    // public ArrayList<WordCount> getWordCountsByWord() {
    //     ArrayList<WordCount> list = new ArrayList<WordCount>();
    //     if (root == null){
    //         return list;
    //     }
    //     list.add(root.left.word);
    //     list.add(root);
    //     getWordCountsByWord(root.right);
    //     return list;
    // }

    
    public void insertWord(Node current){
        insertWordRec(root, current);
    }

    private Node insertWordRec(Node current, Node object){
        if (root == null){
            root = object;
            return root;
        }
        if (current.word.compareTo(object.word)>0 && current.left == null){
            current.left = object;
            return current.left;
        }
        if (current.word.compareTo(object.word)<0 && current.right == null){
            current.right = object;
            return current.right;
        }
        if (current.word.compareTo(object.word)>0){
            insertWordRec(current.left, object);
        }
        
        if (current.word.compareTo(object.word)<0){
            insertWordRec(current.right, object);
        }
        return current;
    }

    /**
   * Returns an array list of WordCount objects, one per word stored in this
   * WordCountMap, sorted in decreasing order by count.
   */
//   public ArrayList<WordCount> getWordCountsByCount() {
//     //using a binary tree sorted by count,
//     //return an array list in order
//     return Array;
//   }
/**
   * If the specified word is already in this WordCountMap, then its
   * count is increased by one. Otherwise, the word is added to this map
   * with a count of 1.
   */
    public void incrementCount(String word) {
        search(word, root);
    }

    public boolean search(String searchWord, Node current){
        if (root == null){
            return false;
        }
        if (current.word.compareTo(searchWord)>0){
            search(searchWord, current.left);
        }
        
        else if (current.word.compareTo(searchWord)<0){
            search(searchWord, current.right);
        }
        else if (current.word.compareTo(searchWord) == 0){
            current.count ++;
            return true;
        }
        current.count ++;
        return false;

    }

    public static void printInOrder(Node current){
        if (current == null){
            return;
        }
        printInOrder(current.left);
        System.out.println(current.word);
        // System.out.println(current.right.word);
        printInOrder(current.right);

    }

    //maybe create getData function to get the data the root contains

    public static void main(String[] args){
        WordCountMap map = new WordCountMap();
        Node root = map.new Node("apple", 16, null, null);
        Node node = map.new Node("banana", 0, null, null);
        Node node2 = map.new Node("aaron", 0, null, null);
        Node node3 = map.new Node("dog", 0, null, null);
        Node node4 = map.new Node("cat", 0, null, null);
        Node node5 = map.new Node("zebra", 0, null, null);
        Node node6 = map.new Node("bunny", 0, null, null);

        map.insertWord(root);
        map.insertWord(node);
        map.insertWord(node2);
        map.insertWord(node3);
        map.insertWord(node4);
        map.insertWord(node5);
        map.insertWord(node6);

        printInOrder(root);
        // System.out.println(map.getWordCountsByWord(root));
        map.incrementCount("apple");
        System.out.println(root.count);
        // map.incrementCount("apple");
        // System.out.println(root.count);
        map.incrementCount("dog");
        System.out.println(node3.count);

    }
}
