package exercises;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    //Pt13
    //1
    public void createDirectory(File directory) {
        if (!directory.mkdir()) {
            System.out.println("This directory already exists.");
        } else System.out.println("Directory has been created.");
    }

    //2
    public Optional<File> showFileWithMaximumSizeInDirectory(File directory) {
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
            return Arrays.stream(fileList).max(Comparator.comparing(File::length));
        }
        return Optional.empty();
    }

    //3
    public void showFilesIfTheyContainInputWord(File directory, String inputWord) {
        File[] fileList = directory.listFiles();
        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                if (file.getName().toLowerCase().contains(inputWord)) {
                    System.out.println(file);
                }
            }
        }
    }

    //4
    public void fileInventory(File directory) {
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                System.out.println("\nFile name: " + file.getName() +
                        ", length: " + file.length() +
                        ", last modification: " + file.lastModified() +
                        ", has read permissions: " + file.canRead() +
                        ", has writing permissions: " + file.canWrite() +
                        ", has execute permissions: " + file.canExecute());
            }
        }
    }

    //5
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

    //6
    public void createDirectoryFromFileAndViceversa(File directory) throws IOException {
        File[] fileList = directory.listFiles();

        if (directory.isDirectory() && fileList != null) {
            for (File file : fileList) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    File newDirectory = new File(file.getName().substring(0, file.getName().lastIndexOf(".")));
                    System.out.println("The file: " + file.getName() + "has created a new directory with the same name. Result of the operation: " + newDirectory.mkdir());
                } else if (file.isDirectory()) {
                    File newFile = new File(file.getName() + ".txt");
                    System.out.println("The directory: " + file.getName() + "has created a new file with the same name. Result of the operation: " + newFile.createNewFile());
                }
            }
        }
    }

    //7
    public List<File> sortFilesInDirectory(File directory, int selection) {
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
    //1
    public StringBuilder readFileContent(File file) {
        try {
            StringBuilder content = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            return content;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //2
    public String readFileContentInAllCaps(File file) {
        try {
            StringBuilder content = new StringBuilder();
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
            return content.toString().toUpperCase();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //3
    public boolean checkIfStringIsInFile(File file, String string) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (Objects.nonNull(line)) {
                if (line.toLowerCase().contains(string)) {
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //4
    public String stringCounter(File file, String string) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("\\b" + string + "\\b");
            Matcher matcher;

            int counter = 0;
            while (Objects.nonNull(line)) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    counter++;
                }
                line = reader.readLine();
            }
            reader.close();
            return ("The word " + string + " has been found " + counter + " times.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //5
    public String writeStringCounterInANewDocument(File file, String string) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("\\b" + string + "\\b");
            Matcher matcher;
            File newFile = new File(file.getCanonicalFile() + ".count");
            FileWriter writer = new FileWriter(newFile, true);

            int counter = 0;

            while (Objects.nonNull(line)) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    counter++;
                }
                line = reader.readLine();
            }
            String result = "The word " + string + " has been found " + counter + " times.";
            writer.write(result);
            writer.close();
            return "New file created with the result located in: " + newFile.getCanonicalFile() + ".";

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //6
    public String rewriteFileInAllCaps(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder content = new StringBuilder();
            String line = reader.readLine();

            while (Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(content.toString().toUpperCase());
            writer.close();

            return "The content of the file : " + file.getCanonicalFile() + " has been rewritten in all caps.";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //7
    public String copyFileContentIntoNewFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder content = new StringBuilder();
            String line = reader.readLine();

            while (Objects.nonNull(line)) {
                content.append(line).append("\n");
                line = reader.readLine();
            }

            int finalPosition = file.getName().lastIndexOf(".");
            String newFileName = file.getName().substring(0, finalPosition);

            File newFile = new File(file.getParent() + "/" + newFileName + "2.txt");
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content.toString());

            fileReader.close();
            reader.close();
            fileWriter.close();
            writer.close();

            return "The content of the file : " + file.getCanonicalFile() + " has been copied into the new file " + newFile.getCanonicalFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //8
    public byte[] readWithbufferedInput(File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int len = bis.available();
            byte[] byteArray = new byte[len];
            bis.read(byteArray);
            bis.close();
            return byteArray;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String writeWithbufferedOutput(File file, String input) {
        try {
            String newFileName = file.getName().substring(0, file.getName().lastIndexOf("."));
            File newFile = new File(file.getParent() + "/" + newFileName + "2.txt");
            BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream(newFile));

            for (int i = 0; i < input.length(); i++) {
                int charConvertedtoAscii = input.charAt(i);
                bis.write(charConvertedtoAscii);
            }
            bis.flush();
            bis.close();
            return "The input : " + input + " has been written into the new file " + newFile.getCanonicalFile();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //9
    public String copyFileByteByByte(File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int nameBeforeExtension = file.getName().lastIndexOf('.');

            if (nameBeforeExtension > 0 && nameBeforeExtension < file.length() - 1) {
                String extension = file.getName().substring(nameBeforeExtension + 1);
                File copiedFile = new File(file.getParent() + "/" + file.getName().substring(0, nameBeforeExtension) + "copy." + extension);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copiedFile));
                int len = bis.available();
                byte[] byteArray = new byte[len];
                bis.read(byteArray);
                bos.write(byteArray);
                bis.close();
                bos.close();
                return "The file " + file.getCanonicalFile() + " has been copied byte to byte into the new file " + copiedFile.getCanonicalFile();
            } else return "This file has no extension. Please use a file that has a valid extension.";
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        //10
        public String analitzador(File file){
        try {
            File outputFile = new File("FilesDirectory/paraules.txt");
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile, true));
            int counter = 0;
            while ((byte) bis.read() != -1){
                counter++;
            }
            bos.write((file.getCanonicalFile() + " " + counter + "\n").getBytes());
            bis.close();
            bos.close();

            return "The result of the file " + file.getCanonicalFile() + " has been saved in the file " + outputFile.getCanonicalFile();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

        //11
        public String getAverageNumberFromFileBytes(File file){
        try{
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
            int total = 0;
            int counter = 0;

            while (dis.available() >= 4){
                total += dis.readInt();
                counter++;
            }

            double average = (double) total/counter;
            dos.writeUTF(" Average result" + average);
            dis.close();
            dos.close();
            return "The average result has been saved in the file: " + file.getCanonicalFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        //12
        public String sortNumbersFromFileBytes(File file){
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            byte[] byteArray = new byte[(int)raf.length()];
            Arrays.sort(byteArray);
            raf.write(byteArray);
            return Arrays.toString(byteArray);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        //13
    }








