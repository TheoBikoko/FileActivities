package exercises;

import java.io.*;
import java.util.*;
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
                return List.of(fileList);
            }
            return null;
    }

    //Pt14
    public StringBuilder readFileContent(File file){
        try {
            StringBuilder content = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (Objects.nonNull(line)){
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

            while (Objects.nonNull(line)){
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

            while (Objects.nonNull(line)){
                if (line.toLowerCase().contains(string)) {
                   return true;
                }
                line = reader.readLine();
            }
            reader.close();
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
            while (Objects.nonNull(line)){
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    counter++;
                }
                line = reader.readLine();
            }
            reader.close();
            return ("The word " + string + " has been found " + counter + " times.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String writeStringCounterInANewDocument (File file, String string){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("\\b"+ string + "\\b");
            Matcher matcher;
            File newFile = new File(file.getCanonicalFile() + ".count");
            FileWriter writer = new FileWriter(newFile, true);

            int counter = 0;

            while (Objects.nonNull(line)){
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    counter++;
                }
                line = reader.readLine();
            }
            String result = "The word " + string + " has been found " + counter + " times.";
            writer.write(result);
            writer.close();
            return "New file created with the result located in: " + newFile.getCanonicalFile() +".";

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String rewriteFileInAllCaps(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder content = new StringBuilder();
            String line = reader.readLine();

            while(Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(content.toString().toUpperCase());
            writer.close();

            return "The content of the file : " + file.getCanonicalFile() +" has been rewritten in all caps.";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String copyFileContentIntoNewFile(File file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder content = new StringBuilder();
            String line = reader.readLine();

            while(Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }

            int finalPosition = file.getName().lastIndexOf(".");
            String newFileName = file.getName().substring(0, finalPosition);

            File newFile = new File(file.getParent() + "/" + newFileName + "2.txt");
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content.toString());
            writer.close();

            return "The content of the file : " + file.getCanonicalFile() +" has been copied into the file " + newFile.getCanonicalFile();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}







