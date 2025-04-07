import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class FileManager {

    void createDirectory(File directory) {
        if (!directory.mkdir()) {
            System.out.println("This directory already exists.");
        } else System.out.println("Directory has been created.");
    }

    Optional<File> showFileWithMaximumSizeInDirectory(File directory) {
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
           return Arrays.stream(fileList).max(Comparator.comparing(File::length));
        }
        return Optional.empty();
    }

    Stream<File> showFileIfItContainsInputWord(File directory, String inputWord){
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
            return Arrays.stream(fileList).filter(file -> file.getName().contains(inputWord));
        }
        return null;
    }

//    void  fileInventory(File directory){
//        File[] fileList = directory.listFiles();
//
//        Arrays.stream(fileList).forEach(file -> );
//    }

//    Stream<File> deleteFileIfItContainsNumber(File directory, int number){
//        File[] fileList = directory.listFiles();
//        if (directory.isDirectory() && fileList != null) {
//            return Arrays.stream(fileList).filter(file -> file.getName());
//        }
//        return null;
//    }

}






