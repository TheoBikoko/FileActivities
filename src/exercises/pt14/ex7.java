package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex7 {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        File file = new File("FilesDirectory/textSample.txt");

        System.out.println(manager.copyFileContentIntoNewFile(file));
    }
}
