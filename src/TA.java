import java.io.PrintWriter;

public final class TA extends Student{
    private int teacherID;

    public TA(String name, int studentID, int teacherID, long Phone) {
        super(name, studentID, Phone);
        this.teacherID = teacherID;
    }

    @Override
    public int getID() {
        return Math.max(studentID, teacherID);
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + Phone);
    }

}
