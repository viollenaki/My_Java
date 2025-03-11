import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

class Student {

    int id;
    String name;
    int age;
    Set<String> courses;

    public Student(int id, String name, int age, Set<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public void changeInfo(int id, String name, int age, Set<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public void changeInfo(String name) {
        this.name = name;
    }

    public void changeInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void changeInfo(String name, int age, Set<String> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public void getInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
    }
}

class School {

    private HashMap<Integer, Student> students;

    public School() {
        students = new HashMap<>();
    }

    public void addStudent(int id, String name, int age, Set<String> courses) {
        Student student = new Student(id, name, age, courses);
        students.put(id, student);
        System.out.println("Student successfully added");
    }

    public void deleteStudent(int id) {
        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student successfully removed");
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void getStudent(Integer id) {
        Student student = students.get(id);
        if (student != null) {
            student.getInfo();
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void updateStudent(int id, String name, int age, Set<String> courses) {
        Student student = students.get(id);
        if (student != null) {
            student.changeInfo(name, age, courses);
            System.out.println("Student successfully updated");
        } else {
            System.out.println("Student not found");
        }
    }
    

    public void getSortedById() {
        TreeSet<Integer> ids = new TreeSet<>(students.keySet());
        for (Integer i : ids) {
            students.get(i).getInfo();
        }
    }


    public void getCourseStudents(String course) {
        for (Integer i : students.keySet()) {
            if (students.get(i).courses.contains(course)) {
                students.get(i).getInfo();
            }
        }
    }
}

public class StudentManagement {

    public static void main(String[] args) {
        School school = new School();
        school.addStudent(66, "Elina", 20, new TreeSet<>(Set.of("Math", "English")));
        school.addStudent(22, "Tolon", 20, new TreeSet<>(Set.of("English", "History")));
        school.addStudent(31, "Bolot", 20, new TreeSet<>(Set.of("Math", "History")));
        school.getSortedById();
        school.getStudent(66);
        school.getCourseStudents("Math");
        school.deleteStudent(66);
    }
}
