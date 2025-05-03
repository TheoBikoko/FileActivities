package exercises.pt14.ex13;

public class Student {
    private int idStudent;
    private String name;
    private String surname;
    private int age;

    public Student(int idStudent, String name, String surname, int age) {
        this.idStudent = idStudent;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(String name, String surname, int age) {
        this.idStudent = 0;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
