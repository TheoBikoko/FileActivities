package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex12 {
    public static void main(String[] args) {
        FileManager manager= new FileManager();
        File file = new File("FilesDirectory/numeros2.bin");
        manager.sortNumbersFromFileBytes(file);
    }
}
