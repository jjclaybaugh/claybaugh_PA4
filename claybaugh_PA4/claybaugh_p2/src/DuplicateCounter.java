import java.io.*;
import java.util.*;

public class DuplicateCounter {
    private Integer wordCount;
    private Map<String, Integer> stringMap;

    public DuplicateCounter() {
        this.wordCount = 0;
        this.stringMap = new HashMap<>();
    }

    public void count(String dataFile) throws IOException{
        Scanner reader;

        try{
            reader = new Scanner(new File(dataFile));

            while(reader.hasNextLine()){
                String line = reader.nextLine().trim();
                //splits a string by all non-word characters
                String[] data = line.split("[\\W]+");

                for(String word : data){
                    this.wordCount = stringMap.get(word);

                    if (this.wordCount == null){
                        this.wordCount = 1;
                    }
                    else{
                        ++this.wordCount;
                    }

                    stringMap.put(word, this.wordCount);
                }
            }
            reader.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("File " + dataFile + " cannot be found");
            System.exit(1);
        }
    }

    public void write(String outputFile){
        FileWriter fwriter;
        PrintWriter pwriter;

        try{
            fwriter = new FileWriter(new File(outputFile));
            pwriter = new PrintWriter(fwriter);

            for(Map.Entry<String, Integer> entry : stringMap.entrySet()){
                pwriter.write(entry.getKey() + " " + entry.getValue() + " " + System.lineSeparator());
            }

            pwriter.flush();
            fwriter.close();
            pwriter.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
}
