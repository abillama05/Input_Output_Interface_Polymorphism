package util;

import java.io.PrintWriter;
public interface CSVPrintable {

    public String getName();
    public int getID();
    void csvPrintln(PrintWriter out);


}
