import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException{
        DuplicateRemover file = new DuplicateRemover();
        file.remove("problem1.txt");
        file.write("unique_words.txt");
    }
}
