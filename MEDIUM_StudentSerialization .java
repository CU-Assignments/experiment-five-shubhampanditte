import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double GPA;

    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', GPA=" + GPA + "}";
    }
}

public class StudentSerialization {

    public static void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
            System.out.println("Student object serialized and saved to file: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: IOException occurred - " + e.getMessage());
        }
    }

    public static Student deserializeStudent(String fileName) {
        Student student = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            student = (Student) in.readObject();
            System.out.println("Student object deserialized from file: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: IOException occurred - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found - " + e.getMessage());
        }
        return student;
    }

    public static void main(String[] args) {
        String fileName = "student.ser"; 

        Student student = new Student(1, "John Doe", 3.75);

        serializeStudent(student, fileName);

        Student deserializedStudent = deserializeStudent(fileName);
        
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student: " + deserializedStudent);
        } else {
            System.out.println("No student object found in the file.");
        }
    }
}
