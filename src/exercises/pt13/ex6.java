package exercises.pt13;
import exercises.FileManager;

import java.io.File;
import java.io.IOException;

public class ex6 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        try {
            manager.createDirectoryFromFileAndViceversa(directory);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}