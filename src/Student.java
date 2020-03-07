import java.util.ArrayList;

/**
 * @title Student.java
 * @author Athena Enosara
 * @since 12 - February - 2020
 * @abstract This is the level 1 doll of the 4 Babushka dolls that is School, Instructor, Course, and Student classes.
 */

public class Student {
    private int myStudentId;
    private String myStudentName;

    public Student(int sId, String sName) {
        this.myStudentId = sId;
        this.myStudentName = sName;
    }

    public void display() { System.out.println(myStudentName); }


    public int getMyStudentID() { return myStudentId; }

    public boolean search(Student stu, ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (this.myStudentId == stu.getMyStudentID()) {
                return true;
            }
        }
        return false;
    }
}
