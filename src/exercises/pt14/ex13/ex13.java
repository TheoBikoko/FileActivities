package exercises.pt14.ex13;

import exercises.FileManager;

import java.io.File;
import java.util.ArrayList;

public class ex13 {
    public static void main(String[] args) {
        File file = new File("FilesDirectory/students.dat");

        FileManager manager = new FileManager();
        ArrayList<Student> students = new ArrayList<>();
        Student theo = new Student(1,"Theo","Bikoko", 27);
        Student mamadou = new Student(2,"Mamadou","Diallo",23);
        Student melina = new Student(3,"Melina","Giacone",28);
        Student jordi = new Student(4,"Jordi","Divison",25);
        Student eric = new Student(5,"Eric","Calvo",21);


        students.add(theo);
        students.add(mamadou);
        students.add(melina);
        students.add(jordi);
        students.add(eric);

        for (Student student: students) {
           manager.databaseCreateStudent(file, student);
        }

            manager.databaseReadAllStudents(file);

            manager.databaseReadStudentWithId(file, melina.getIdStudent());
            manager.databaseReadStudentWithId(file, eric.getIdStudent());
            manager.databaseReadStudentWithId(file, theo.getIdStudent());


            manager.databaseDeleteStudentWithId(file, eric.getIdStudent());
            manager.databaseReadStudentWithId(file, 5);
            manager.databaseUpdateStudentWithId(file, 5, new Student("Dante","Alighieri",666));
            manager.databaseReadStudentWithId(file, 5);

    }
}
