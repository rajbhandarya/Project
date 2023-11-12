import java.util.ArrayList;
import java.util.Scanner;

public class WordCountMap {
    /**
     * A class called WordCountMap consisting of a binary search
     * tree that maintains a record of words and their counts. 
     * (WordCountMap will make use of two very small classes called Node and WordCount described below.)
     */
    public Node root;
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

    public Node createNode(String word, int num, Node left, Node right) {
        return new Node(word, num, left, right);
    }

    public Node getRoot() {
        return root; 
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
}
