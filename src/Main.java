import util.CSVPrintable;
import util.InputValidator;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CSVPrintable> people = new ArrayList<>();

        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            CSVPrintable person = parsePerson(line);
            if (person != null) {
                people.add(person);
            } else {
                System.out.println("Invalid input. Please re-enter.");
                i--; // Decrement to re-process this entry
            }
        }

        writeToCSV(people, "out.csv");
    }

    private static CSVPrintable parsePerson(String line) {
        if (!InputValidator.isValidInput(line)) {
            System.out.println("Invalid input format. Please try again.");
            return null;
        }

        String[] parts = line.split("\\s+");
        String position = parts[0].toLowerCase();
        String name = parts[1];
        String studentID = parts[2];
        String teacherID = parts[3];
        String phone = parts[4];

        switch (position) {
            case "student":
                return new Student(name, Integer.parseInt(studentID), Long.parseLong(phone));
            case "teacher":
                return new Teacher(name, Integer.parseInt(teacherID), Integer.parseInt(phone.substring(6)));
            case "ta":
                return new TA(name, Integer.parseInt(studentID), Integer.parseInt(teacherID), Long.parseLong(phone));
            default:
                System.out.println("Invalid position. Please try again.");
                return null;
        }
    }

    private static void writeToCSV(ArrayList<CSVPrintable> people, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (CSVPrintable person : people) {
                person.csvPrintln(writer);
            }
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

