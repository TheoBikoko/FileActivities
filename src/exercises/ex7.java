package exercises;
import java.io.File;
import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileManager manager = new FileManager();
        String newDirectoryPath = "FilesDirectory";
        File directory = new File(newDirectoryPath);
        boolean running = true;

        while (running) {
            System.out.println("""
                     \n Welcome to the file sorter. Please, select which parameter you want to use to sort your files: \s
                     1. Alphabetical order
                     2. Modification order
                     3. Size order
                     4. Exit program
                    \s""");
            int option = input.nextInt();
            switch (option) {
                case 1 -> System.out.println("Files sorted by name: " + manager.sortFilesInDirectory(directory, 1));
                case 2 -> System.out.println("Files sorted by last modification: " + manager.sortFilesInDirectory(directory, 2));
                case 3 -> System.out.println("Files sorted by size: " + manager.sortFilesInDirectory(directory, 3));
                case 4 -> {
                    System.out.println("Thank you for using our program, goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }
}