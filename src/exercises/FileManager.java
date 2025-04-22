package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    //Pt13

    public void createDirectory(File directory) {
        if (!directory.mkdir()) {
            System.out.println("This directory already exists.");
        } else System.out.println("Directory has been created.");
    }

    public Optional<File> showFileWithMaximumSizeInDirectory(File directory) {
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
           return Arrays.stream(fileList).max(Comparator.comparing(File::length));
        }
        return Optional.empty();
    }

    public void showFilesIfTheyContainInputWord(File directory, String inputWord){
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
            for(File file: fileList){
                if (file.getName().toLowerCase().contains(inputWord)){
                    System.out.println(file);
                }
            }
        }
    }

    public void fileInventory(File directory){
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

    public void deleteFilesThatBeginWithANumber(File directory) {
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                if (file.getName().matches("[0-9].*")) {
                    System.out.println("The file: " + file.getName() + "has been removed.");
                }
            }
        }
    }

    public void createDirectoryFromFileAndViceversa(File directory) throws IOException {
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

    public List<File> sortFilesInDirectory(File directory, int selection){
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

    //Pt14
    public StringBuilder readFileContent(File file){
        try {
            StringBuilder content = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null){
                content.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            return content;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String readFileContentInAllCaps(File file){
        try {
            StringBuilder content = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null){
                content.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            return content.toString().toUpperCase();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean checkStringInFile(File file, String string){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null){
                if (line.toLowerCase().contains(string)) {
                   return true;
                }
                line = reader.readLine();
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String stringCounter (File file, String string){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("\\b"+ string + "\\b");
            Matcher matcher;

            int counter = 0;
            while (line != null){
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    counter++;
                }
                line = reader.readLine();
            }
            return ("The word " + string + " has been found " + counter + " times.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}







