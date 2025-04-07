import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ExerciseTest {
    public static void main(String[] args) {

        FileManager manager = new FileManager();
        File directory = new File("FilesDirectory");

        System.out.println("---- Exercici 1 ----");
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

        System.out.println("---- Exercici 2 ----");
        if (args.length == 1){
            directory = new File(args[0]);
            manager.createDirectory(directory);
        }
        System.out.println(manager.showFileWithMaximumSizeInDirectory(directory));
    }
}
