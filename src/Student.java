import util.CSVPrintable;

import java.io.PrintWriter;
public class Student implements CSVPrintable {
    protected String name; // Format: Velasquez, Ruth
    protected int studentID; // 0 or 5-digit string
    protected long Phone;

    public Student(String name, int studentID, long Phone) {
        this.name = name;
        this.studentID = studentID;
        this.Phone = Phone;
    }

    @Override
    public int getID(){
        return studentID;
    };
    @Override
    public String getName(){
        return name;
    };
    @Override
    public void csvPrintln(PrintWriter out){
        out.println(getName() + "," + getID() + "," + Phone);
    }

}
