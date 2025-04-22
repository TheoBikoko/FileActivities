package exercises.pt13;
import exercises.FileManager;

import java.io.File;

public class ex3 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        String inputWord = "file";
        manager.showFilesIfTheyContainInputWord(directory, inputWord);
    }
}