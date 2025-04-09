package exercises;
import java.io.File;

public class ex4 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        manager.fileInventory(directory);
    }
}