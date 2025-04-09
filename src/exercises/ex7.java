package exercises;
import java.io.File;

public class ex7 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        System.out.println("""
                           Welcome to the file sorter. Please, select which parameter you want to use to sort your files: \s
                           1. Alphabetical order (name)
                           2. Modification order
                           3. Size order
                          \s""");
    }
}