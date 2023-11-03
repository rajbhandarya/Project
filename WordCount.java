public class WordCount implements Comparable<WordCount>{
    public String word;
    public int count;

    public int compareTo(WordCount bob){
        if (count < bob.count){
            return -1;
        }
        if (count > bob.count){
            return 1;
        }
        if (count == bob.count){
            return 0;
        }
        return 0;
    }
}
