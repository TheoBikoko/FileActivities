package exercises.pt14.ex13;

import exercises.FileManager;

import java.io.File;

public class ex13 {
    public static void main(String[] args) {
        File file = new File("FilesDirectory/students.dat");
        FileManager manager = new FileManager();
        manager.database(file)
    }
}
