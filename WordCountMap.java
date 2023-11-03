public class WordCountMap {
    /**
     * A class called WordCountMap consisting of a binary search
     * tree that maintains a record of words and their counts. 
     * (WordCountMap will make use of two very small classes called Node and WordCount described below.)
     */
    Node root;
    private class Node<E extends Comparable<E>>{
        private String word;
        private int count;
        private Node left;
        private Node right;
        private E data;
        Node root = null;

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
        }
        else{
        Node current = root;
        if (current.word.compareTo(object.word)>=0){
            current.right = object;

        }
        
        if (current.word.compareTo(object.word)<0){
            current.left = object;
        }
    }
    }

    public void insertCount(Node object){
        if (root == null){
            root = object;
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

    //maybe create getData function to get the data the root contains

    public static void main(String[] args){
        WordCountMap map = new WordCountMap();
        Node node = map.new Node("alligator", 1, null, null);
        System.out.println(node.root + "     " + node.word);
        Node node2 = map.new Node("happy", 1, null, null);
        map.insertWord(node2);
        System.out.println(map);
        System.out.println(node.right);


    }

    
}
