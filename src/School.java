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
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public School(String schoolName){
        this.mySchoolName = schoolName;
    }


    // READ DATA METHOD
    public void readData(String filename) {
        File f = new File(filename);//creates file
        Scanner scan = null;//we do this so that the Scanner is created here, it's set to null so that nothing is in it

        try{
            scan = new Scanner(f);
        } catch (FileNotFoundException e){ //end of try statement, start of catch
            System.out.println("Couldn't find the file... " + "even though we are making it. " + e);
            e.printStackTrace();
        }


        // READ IN INSTRUCTORS
        String iSize = scan.nextLine();
//        System.out.println("Size: " + iSize);
        System.out.println(iSize);
        HashMap<String, String> iArray = new HashMap<>();

        for(int i = 0; i < Integer.parseInt(iSize); i++){
            String sc = scan.nextLine();
            System.out.println(sc);
            String[] tester = sc.split(",");

            int iLength = tester.length;
//            System.out.println(iLength);

            iArray.put("iId", tester[0]);
            iArray.put("iName", tester[1]);
            iArray.put("iEmail", tester[2]);
            iArray.put("iPhone", tester[3]);

//            System.out.println("In the HashMap: " + iArray);
            addInstructor(iArray.get("iId"), iArray.get("iName"), iArray.get("iEmail"), iArray.get("iPhone"));

        }

        // READ IN COURSES
        String cSize = scan.nextLine();
//        System.out.println("Size: " + cSize);
        System.out.println(cSize);
        HashMap<String, String> cArray = new HashMap<>();

        for(int i = 0; i < Integer.parseInt(cSize); i++){
            String sc = scan.nextLine();
            System.out.println(sc);
            String[] tester = sc.split(",");

            int cLength = tester.length;
//            System.out.println(cLength);

            cArray.put("cId", tester[0]);
            cArray.put("cName", tester[1]);
            cArray.put("cEnrolled", tester[2]);
            cArray.put("cLocation", tester[3]);

//            System.out.println("In the HashMap: " + cArray);
            addCourse(cArray.get("cId"), cArray.get("cName"), cArray.get("cEnrolled"), cArray.get("cLocation"));

        }

        // READ IN STUDENTS
        String sSize = scan.nextLine();
//        System.out.println("Size: " + sSize);
        System.out.println(sSize);
        HashMap<String, String> sArray = new HashMap<>();

        for(int i = 0; i < Integer.parseInt(sSize); i++){
            String sc = scan.nextLine();
            System.out.println(sc);
            String[] tester = sc.split(",");

            int sLength = tester.length;
//            System.out.println(sLength);

            sArray.put("sId", tester[0]);
            sArray.put("sName", tester[1]);

//            System.out.println("In the HashMap: " + sArray);
            addStudent(sArray.get("sId"), sArray.get("sName"));

        }



        // if succeeded
        System.out.println();
        System.out.println("Done.");
    }

    // ADD INSTRUCTOR METHOD
    public boolean addInstructor(String iId, String iName, String iEmail, String iPhone){
//        System.out.println("Adding instructor...");
        Instructor a = new Instructor(Integer.parseInt(iId), iName, iEmail, iPhone);

        return true;
    }

    // ADD COURSE METHOD
    public boolean addCourse(String cId, String cName, String cEnrolled, String cLocation){
//        System.out.println("Adding course...");
        Course a = new Course(Integer.parseInt(cId), cName, cEnrolled, cLocation);

        return true;
    }

    // ADD STUDENT METHOD
    private boolean addStudent(String sId, String sName) {
//        System.out.println("Adding student...");
        Student a = new Student(Integer.parseInt(sId), sName);

        return true;
    }

    public void schoolInfo(){
        System.out.println("School Name: " + this.mySchoolName +
                "Instructor Information\n" +
                getInstructors() +
                "Course Information\n" +
                getCourses() +
                "Student Information\n" +
                getStudents());
    }


    private String getStudents() {
        String[] students = {"test-students\n"};


        return students[0];
    }

    private String getCourses() {
        String[] courses = {"test-courses\n"};


        return courses[0];
    }

    private String getInstructors() {
        String[] instructors = {"test-instructors\n"};


        return instructors[0];
    }



    public boolean searchByEmail(String email){

        return false;
    }



//    @Override
//    public String toString(){
//        return "School Name:        " + this.mySchoolName + "\n" +
//                "Instructor Information\n" +
//                getInstructors() +
//                "Course Information\n" +
//                getCourses() +
//                "Student Information\n" +
//                getStudents();
//    }
}
