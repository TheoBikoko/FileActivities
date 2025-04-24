package exercises.pt14;

import exercises.FileManager;

import java.io.File;

public class ex9 {
    public static void main(String[] args) {
        FileManager manager= new FileManager();
        File file = new File("FilesDirectory/pdf-test.pdf");
        System.out.println(manager.copyFileByteByByte(file));
    }
}
