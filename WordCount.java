import org.w3c.dom.Node;

public class WordCount implements Comparable<WordCount>{
    public String word;
    public int count;

    public int compareTo(WordCount item){
        if (count < item.count){
            return -1;
        }
        if (count > item.count){
            return 1;
        }
        if (count == item.count){
            return 0;
        }
        return 0;
    }

    public WordCount(String word, int count){
            this.word = word;
            this.count = count;

    }
}
