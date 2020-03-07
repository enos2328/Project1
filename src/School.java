import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @title School.java
 * @author Athena Enosara
 * @since 12 - February - 2020
 * @abstract This is the level 4 doll of the 4 Babushka dolls that is School, Instructor, Course, and Student classes.
 */

public class School {
    private String mySchoolName;
    private ArrayList<Instructor> instructors = new ArrayList<>();
    private int iIndex = 0;
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public School(String schoolName){
        this.mySchoolName = schoolName;
    }


    // ####### READ DATA METHOD
    public void readData(String filename) {
        File f = new File(filename);//creates file
        Scanner scan = null;//we do this so that the Scanner is created here, it's set to null so that nothing is in it

        try{
            scan = new Scanner(f);
        } catch (FileNotFoundException e){ //end of try statement, start of catch
            System.out.println("Couldn't find the file... " + "even though we are making it. " + e);
            e.printStackTrace();
        }


        // ####### READ IN INSTRUCTORS
        String iSize = scan.nextLine();
        for(int i = 0; i < Integer.parseInt(iSize); i++){
            String sc = scan.nextLine();
            String[] tester = sc.split(",");
            Instructor dr = new Instructor(Integer.parseInt(tester[0]), tester[1], tester[2], tester[3]);
            addInstructor(dr);
        }

        // ####### READ IN COURSES
        String cSize = scan.nextLine();
        for(int i = 0; i < Integer.parseInt(cSize); i++){
            String sc = scan.nextLine();
            String[] tester = sc.split(",");
            Course cou = new Course(Integer.parseInt(tester[0]), tester[1], Integer.parseInt(tester[2]), tester[3]);
            addCourse(cou);
        }

        // ####### READ IN STUDENTS
        String sSize = scan.nextLine();
        for(int i = 0; i < Integer.parseInt(sSize); i++){
            String sc = scan.nextLine();
            String[] tester = sc.split(",");
            Student stu = new Student(Integer.parseInt(tester[0]), tester[1]);
            addStudent(stu);
        }
        // if succeeded
        System.out.println("Done.");
    }

    // ####### ADD INSTRUCTOR METHOD
    public void addInstructor(Instructor a){
        //check if instructor being added already exists
        boolean foundI = false;
        try {
            for (Instructor ins : instructors) {
                if (a.getMyInstructorID() == ins.getMyInstructorID()) {
                    foundI = true;
                    break;
                }
            }

            if(!foundI){
                instructors.add(a);
            } else {
                System.out.println("Instructor info reading failed - Employee number " + a.getMyInstructorID() + " already used.");
            }
        } catch (NullPointerException e){
            System.out.println("You're trying to add a memory address.");
        }
    }

    // ####### ADD COURSE METHOD
    public void addCourse(Course a){
        //check if instructor being added already exists
        boolean foundC = false;
        try {
            for (Course cou : courses) {
                if (a.getMyCourseID() == cou.getMyCourseID()) {
                    foundC = true;
                    break;
                }
            }

            if(!foundC){
                courses.add(a);
            } else {
                System.out.println("Course info reading failed - Course number " + a.getMyCourseID() + " already used.");
            }
        } catch (NullPointerException e){
            System.out.println("You're trying to add a memory address.");
        }
    }

    // ####### ADD STUDENT METHOD
    private void addStudent(Student a) {
        //check if instructor being added already exists
        boolean foundS = false;
        try {
            for (Student student : students) {
                if (a.getMyStudentID() == student.getMyStudentID()) {
                    foundS = true;
                    break;
                }
            }

            if(!foundS){
                students.add(a);
            } else {
                System.out.println("Course info reading failed - Course number " + a.getMyStudentID() + " already used.");
            }
        } catch (NullPointerException e){
            System.out.println("You're trying to add a memory address.");
        }
    }

    // ####### SCHOOL INFO METHOD
    public void schoolInfo(){
        System.out.println("School Name: " + this.mySchoolName +
                "\nInstructor Information");
        getInstructors();
        System.out.println("\nCourse Information");
        getCourses();
        System.out.println("\nStudent Information");
        getStudents();
    }

    // ####### GET STUDENTS METHOD
    private void getStudents() {
        for(int i = 0; i < students.size(); i++){
            students.get(i).display();
        }
    }

    // ####### GET COURSES METHOD
    private void getCourses() {
        for(int i = 0; i < courses.size(); i++){
            courses.get(i).display();
        }
    }

    // ####### GET INSTRUCTORS METHOD
    private void getInstructors() {
        for(int i = 0; i < instructors.size(); i++){
            instructors.get(i).display();
        }
    }


    // ####### SEARCH BY MAIL METHOD
    public void searchByEmail(String email){
        boolean found = false;
        int id = 0;
        String name = "";
        String phone = "";

        for (Instructor ins : instructors) {
            if (ins.getMyInstructorEmail().equals(email)) {
                found = true;
                id = ins.getMyInstructorID();
                name = ins.getMyInstructorName();
                phone = ins.getMyInstructorPhone();
                break;
            }
        }

        if(found){
            System.out.println("Search key: " + email +
                    "\nEmployee Number: " + id +
                    "\nName: " + name +
                    "\nPhone: " + phone);
        } else {
            System.out.println("Search key: " + email +
                    "\nNo employee with email " + email);
        }
    }

    public void addInstructor(int id, String name, String email, String phone) {
    }

    public void addCourse(int id, String name, int enrolled, String location) {
        //check if instructor being added already exists
        boolean foundC = false;
        try {
            for (Course cou : courses) {
                if (id == cou.getMyCourseID()) {
                    foundC = true;
                    break;
                }
            }

            if(!foundC){
                Course create = new Course(id, name, enrolled, location);
            } else {
                System.out.println("Course info reading failed - Course number " + id + " already used.");
            }
        } catch (NullPointerException e){
            System.out.println("You're trying to add a memory address.");
        }
    }
}
