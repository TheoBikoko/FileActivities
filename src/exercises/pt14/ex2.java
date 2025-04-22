package exercises.pt14;

import exercises.FileManager;

public class ex2 {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        String path = ("/home/25634122r/Escriptori/FileActivities/FilesDirectory/textSample.txt");
        System.out.println(manager.readFileContentInAllCaps(path));
    }
}
