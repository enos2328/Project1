
/**
 * @title Instructor.java
 * @author Athena Enosara
 * @since 12 - February - 2020
 * @abstract This is the level 3 doll of the 4 Babushka dolls that is School, Instructor, Course, and Student classes.
 */

public class Instructor {
    private int myInstructorID;
    private String myInstructorName;
    private String myInstructorEmail;
    private String myInstructorPhone;


    public Instructor(int iId, String iName, String iEmail, String iPhone) {
        this.myInstructorID = iId;
        this.myInstructorName = iName;
        this.myInstructorEmail = iEmail;
        this.myInstructorPhone = iPhone;
    }
}
