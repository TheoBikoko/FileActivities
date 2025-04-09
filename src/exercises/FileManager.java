package exercises;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    void showFilesIfTheyContainInputWord(File directory, String inputWord){
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
            for(File file: fileList){
                if (file.getName().toLowerCase().contains(inputWord)){
                    System.out.println(file);
                }
            }
        }
    }

    void fileInventory(File directory){
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for(File file: fileList){
                System.out.println("\nFile name: " + file.getName() +
                                    ", length: " +  file.length() +
                                    ", last modification: " +  file.lastModified()  +
                                    ", has read permissions: " +  file.canRead() +
                                    ", has writing permissions: " +  file.canWrite() +
                                    ", has execute permissions: " +  file.canExecute() );
                }
            }
        }

    void deleteFilesThatBeginWithANumber(File directory) {
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                if (file.getName().matches("[0-9].*")) {
                    System.out.println("The file: " + file.getName() + "has been removed.");
                }
            }
        }
    }

    void createDirectoryFromFileAndViceversa(File directory) throws IOException {
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    File newDirectory = new File(file.getName().substring(0, file.getName().lastIndexOf(".")));
                    System.out.println("The file: " + file.getName() + "has created a new directory with the same name. Result of the operation: " +  newDirectory.mkdir());
                }
                else if (file.isDirectory()) {
                    File newFile = new File(file.getName() + ".txt");
                    System.out.println("The directory: " + file.getName() + "has created a new file with the same name. Result of the operation: " +  newFile.createNewFile());
                }
            }
        }
    }

    List<File> sortFilesInDirectory(File directory, int selection){
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
        switch (selection) {
            case 1 -> Arrays.sort(fileList, Comparator.comparing(File::getName));
            case 2 -> Arrays.sort(fileList, Comparator.comparing(File::lastModified));
            case 3 -> Arrays.sort(fileList, Comparator.comparing(File::length));
            }
        }
        return List.of(fileList);
    }
}






