package exercises;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ex1 {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);

        manager.createDirectory(directory);
        Optional<File> file = manager.showFileWithMaximumSizeInDirectory(directory);
        try {
            if (file.isPresent()) {
                System.out.println(file.get().getCanonicalFile());
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
