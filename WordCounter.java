import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.w3c.dom.Node;


public class WordCounter {
    String fileName;
    String word;
    WordCountMap map;
    Node root;

    public WordCounter(String fileName) {
        this.fileName = fileName;
        this.map = new WordCountMap(); // Initialize the WordCountMap
        this.root = root; // Initialize root
    }
    

    public void load(WordCountMap map){
        ArrayList<String> stopWordList = loadStopWords("StopWords.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        while (scanner.hasNext()) {
            word = scanner.next();
            word = word.replaceAll("[^a-zA-Z]", "");
            if (stopWordList.contains(word.toLowerCase()) == false){
                map.insertWord(map.createNode(word, 0, null, null));            
                map.incrementCount(word);
            }
            }
    }

    public static ArrayList<String> loadStopWords(String fileName){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            list.add(word.toLowerCase());
        }
        return list;
    }




    public static void main(String[] args){
        // if (args.length != 2 || args.length != 3) {
        //     System.err.println("ok");
        //     System.exit(1);
        // }

        WordCountMap map = new WordCountMap();
        String fileName = args[1];
        String type = args[0];
        
        WordCounter fileWords = new WordCounter(fileName);
        WordCloudMaker cloudMaker = new WordCloudMaker();
        fileWords.load(map);
        // ArrayList<String> stopWordList = loadStopWords("StopWords.txt");

        ArrayList<WordCount> listCount = map.getWordCountsByCount();
        if (type.equals("frequency")){
        for (WordCount item : listCount){
            System.out.println(item.word+": "+ item.count);
        }
        }
        ArrayList<WordCount> listWord = map.getWordCountsByWord();
        if (type.equals("alphabetical")){
        for (WordCount item : listWord){
            System.out.println(item.word+": "+ item.count);

        }
        }

        if (args.length == 3){
            String number = args[2];
            int num = Integer.parseInt(number);
            if (type.equals("cloud")){
            List<WordCount> subList = listCount.subList(0, num);
            for (WordCount item : subList){
                System.out.println(item.word);
            }
            for (WordCount item : subList){
                System.out.println(item.word+": "+ item.count);

            }
            // cloudMaker.createWordCloudHTML("title", subList, "fileName.HTML");
        }
        }

        }
}

