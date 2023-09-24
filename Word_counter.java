import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Word_counter {
    public static void main(String[] args) throws IOException {
        FileInputStream s=new FileInputStream("readme.txt");
        Scanner sc=new Scanner(s);

        ArrayList<String> org=new ArrayList<>();
        ArrayList<String> words=new ArrayList<>();
        ArrayList<Integer> count=new ArrayList<>();
        int total_c=0;

        List<String> stopwords = Files.readAllLines(Paths.get("stopwords-en.txt"));


        while(sc.hasNext()){
            total_c++;
            String cur_word=sc.next().toLowerCase();
            org.add(cur_word);
            if(!stopwords.contains(cur_word)) {
                if (words.contains(cur_word)) {
                    int index = words.indexOf(cur_word);
                    count.set(index, count.get(index) + 1);
                } else {
                    words.add(cur_word);
                    count.add(1);
                }
            }
        }
        System.out.println("\nOriginal input text:"+org);
        System.out.println("Total number of words in input text file: "+total_c+"\n");
        System.out.println("Count of unique words excluding stop words");
        for(int i=0;i<words.size();i++){
            String word=words.get(i);
            int c=count.get(i);
            System.out.println(word+" has a count of "+c);
        }



    }
}
