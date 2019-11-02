import java.io.*;
import java.util.*;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException{
        String word;
        uniqueWords = new HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));

        while(scnr.hasNext()){
            word = scnr.next();
            uniqueWords.add(word);
        }
        scnr.close();
    }

    public void write(String outputFile) throws IOException{
        File file = new File(outputFile);
        FileWriter writer = null;

        if (file.exists() == false){
            file.createNewFile();
        }

        writer = new FileWriter(file, true);
        Iterator iterator = uniqueWords.iterator();

        while(iterator.hasNext()){
            String word = (String)iterator.next();
            writer.write(word + "\n");
        }
        writer.close
    }
}
