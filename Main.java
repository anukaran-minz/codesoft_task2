import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculateResults();
    }

    public static void calculateResults() {
        // Initialize variables
        double total = 0;
        int numSubjects = 0;

        // Get the number of subjects
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        numSubjects = Integer.parseInt(scanner.nextLine());

        // Get the marks for each subject
        List<Double> marks = new ArrayList<>();
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter the mark for subject " + (i + 1) + " (out of 100): ");
                String input = scanner.nextLine();
                try {
                    double mark = Double.parseDouble(input);
                    if (mark >= 0 && mark <= 100) {
                        marks.add(mark);
                        total += mark;
                        break;
                    } else {
                        System.out.println("Invalid mark. Please enter a value between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }

        // Calculate the average percentage
        double averagePercentage = (total / numSubjects);

        // Assign grades based on the average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the results
        System.out.printf("Total Marks: %.0f/%d%n", total, numSubjects * 100);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}