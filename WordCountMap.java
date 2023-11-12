import java.util.ArrayList;
import java.util.Scanner;

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
    public ArrayList<WordCount> getWordCountsByWord() {
        // traverse through binary search tree and create a word count object for each node
        // for each node created, add it to the array list
        ArrayList<WordCount> list = new ArrayList<>();
        list = arrayListofWordCountObjectsWord(root, list);        
        return list;
    }

    public ArrayList<WordCount> arrayListofWordCountObjectsWord(Node current, ArrayList<WordCount> list){
        if (current == null){
            return list;
        }
        arrayListofWordCountObjectsWord(current.left, list);
        WordCount wordCountObject = new WordCount(current.word, current.count);
        list.add(wordCountObject);
        arrayListofWordCountObjectsWord(current.right, list);
        return list;
  }
 
        /**
   * Returns an array list of WordCount objects, one per word stored in this
   * WordCountMap, sorted in decreasing order by count.
   */
  public ArrayList<WordCount> getWordCountsByCount() {
    ArrayList<WordCount> list = new ArrayList<>();
    arrayListofWordCountObjectsCount(root, list);
    selectionSortCount(list);
    return list;
  }


  private ArrayList<WordCount> arrayListofWordCountObjectsCount(Node current, ArrayList<WordCount> list){
    if (current == null){
        return list;
    }
    arrayListofWordCountObjectsCount(current.left, list);
    WordCount wordCountObject = new WordCount(current.word, current.count);
    list.add(wordCountObject);
    arrayListofWordCountObjectsCount(current.right, list);
    return list;
  }

  public static void selectionSortCount(ArrayList<WordCount> arr) {
    for (int i = 0; i < arr.size(); i++) {
        int pos = i;
        for (int j = i; j < arr.size(); j++) {
            if (arr.get(j).count < arr.get(pos).count)
                pos = j;
        }
        // Swap min (smallest num) to current position on array
        WordCount min = arr.get(pos);
        arr.set(pos, arr.get(i));
        arr.set(i, min);
    }
}

    public void insertWord(Node current){
        insertWordRecursively(root, current);
    }

    private Node insertWordRecursively(Node current, Node object){
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
            insertWordRecursively(current.left, object);
        }
        
        if (current.word.compareTo(object.word)<0){
            insertWordRecursively(current.right, object);
        }
        return current;
    }



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


    public static void main(String[] args){
        // if (args.length != 1) {
        //     System.err.println();
        //     System.exit(1);
        // }

        WordCountMap map = new WordCountMap();
        Node root = map.new Node("apple", 16, null, null);
        Node node = map.new Node("banana", 8, null, null);
        Node node2 = map.new Node("aaron", 35, null, null);
        Node node3 = map.new Node("dog", 0, null, null);
        Node node4 = map.new Node("cat", 0, null, null);
        Node node5 = map.new Node("zebra", 100, null, null);
        Node node6 = map.new Node("bunny", 3, null, null);

        map.insertWord(root);
        map.insertWord(node);
        map.insertWord(node2);
        map.insertWord(node3);
        map.insertWord(node4);
        map.insertWord(node5);
        map.insertWord(node6);

        // printInOrder(root);
        for (WordCount item: map.getWordCountsByCount()){
            System.out.println(item.count);
        }

        WordCounter fileWords = new WordCounter();
        fileWords.load("Federalistpapers.txt");

    }
}
