
/**
 * @title Course.java
 * @author Athena Enosara
 * @since 12 - February - 2020
 * @abstract This is the level 2 doll of the 4 Babushka dolls that is School, Instructor, Course, and Student classes.
 */

public class Course {
    private int myCourseID;
    private String myCourseName;
    private String myCourseEnrolled;
    private String myCourseLocation;


    public Course(int cId, String cName, String cEnrolled, String cLocation) {
        this.myCourseID = cId;
        this.myCourseName = cName;
        this.myCourseEnrolled = cEnrolled;
        this.myCourseLocation = cLocation;
    }
}
