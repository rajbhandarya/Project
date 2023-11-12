import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    String fileName;
    String word;

    public void load(String fileName){
        
        WordCountMap theWord = new WordCountMap();
        Scanner scanner = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        while (scanner.hasNext()) {
            word = scanner.next();
            Node someWord = theWord.new Node(word, 0, null, null);
            theWord.insertWord(someWord);
            //and then incremennt as it reads each word
    }
    System.out.println(list);
    
}
}

