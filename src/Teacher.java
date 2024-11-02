import util.CSVPrintable;

import java.io.PrintWriter;
public class Teacher implements CSVPrintable {
    private String name; // Format: Velasquez, Ruth
    private int teacherID; // 0 or 5-digit string
    private int Phone;

    public Teacher(String name, int teacherID, int Phone) {
        this.name = name;
        this.teacherID = teacherID;
        this.Phone = Phone;
    }

    @Override
    public int getID(){
        return teacherID;
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
