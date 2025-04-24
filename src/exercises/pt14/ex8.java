package exercises.pt14;

import exercises.FileManager;

import java.io.File;
import java.util.Arrays;

public class ex8 {
    public static void main(String[] args) {
        FileManager manager = new FileManager();
        File file = new File("FilesDirectory/pdf-test.pdf");

        System.out.println(Arrays.toString(manager.readWithbufferedInput(file)));
        System.out.println(manager.writeWithbufferedOutput(file, "M3 Programacio DAM1"));
    }
}
