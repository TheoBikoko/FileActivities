package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex10 {
    public static void main(String[] args) {
        FileManager manager= new FileManager();
        File file = new File("FilesDirectory/pdf-test.pdf");
        File file2 = new File("FilesDirectory/textSample.txt");
        System.out.println(manager.analitzador(file));
        System.out.println(manager.analitzador(file2));
    }
}
