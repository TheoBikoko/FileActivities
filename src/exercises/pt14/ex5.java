package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex5 {
    public static void main(String[] args) {
            FileManager manager = new FileManager();
            File file = new File ("FilesDirectory/textSample.txt");
            String input = "The";
            System.out.println(manager.writeStringCounterInANewDocument(file, input));
        }
}
