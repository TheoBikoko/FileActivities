package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex3 {
    public static void main(String[] args) {
        FileManager fileManager= new FileManager();
        File file = new File ("FilesDirectory/textSample.txt");
        String input = "wonders";

        boolean verification = fileManager.checkIfStringIsInFile(file,input);
        System.out.println(verification);
    }
}
