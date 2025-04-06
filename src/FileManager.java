import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FileManager {
    File directory = new File("../../FilesDirectory");

    void createDirectory() {
        if (directory.mkdir()) {
            System.out.println("This directory already exists.");
        } else System.out.println("Directory has been created.");
    }

    Optional<File> showFileWithMaximumSizeInDirectory() {
        File[] fileList = directory.listFiles();
        if (fileList != null) {
            return Arrays.stream(fileList).max(Comparator.comparing(File::length));
        }
        return Optional.empty();
    }


}



