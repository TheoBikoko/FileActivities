package exercises.pt14;

import exercises.FileManager;

public class ex3 {
    public static void main(String[] args) {
        FileManager fileManager= new FileManager();
        String path = ("/home/25634122r/Escriptori/FileActivities/FilesDirectory/textSample.txt");
        String input = "wonders";

        boolean verification = fileManager.checkStringInFile(path,input);
        System.out.println(verification);
    }
}
