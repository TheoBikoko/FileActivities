package exercises.pt13;
import exercises.FileManager;

import java.io.File;

public class ex2 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        if (args.length == 1){
            directory = new File(args[0]);
            manager.createDirectory(directory);
        }
        System.out.println(manager.showFileWithMaximumSizeInDirectory(directory));
    }
}