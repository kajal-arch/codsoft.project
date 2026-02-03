void main() {
    Scanner scanner = new Scanner(System.in);

    // 1. Take input for number of subjects
    IO.print("Enter the number of subjects: ");
    int numSubjects = scanner.nextInt();

    int[] marks = new int[numSubjects];
    int totalMarks = 0;

    // 2. Take marks obtained in each subject
    for (int i = 0; i < numSubjects; i++) {
        IO.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
        marks[i] = scanner.nextInt();

        // Validation to ensure marks are within 0-100
        while (marks[i] < 0 || marks[i] > 100) {
            IO.print("Invalid input. Enter marks between 0 and 100: ");
            marks[i] = scanner.nextInt();
        }
        totalMarks += marks[i];
    }

    // 3. Calculate Average Percentage
    double averagePercentage = (double) totalMarks / numSubjects;

    // 4. Grade Calculation
    char grade;
    if (averagePercentage >= 90) {
        grade = 'A';
    } else if (averagePercentage >= 80) {
        grade = 'B';
    } else if (averagePercentage >= 70) {
        grade = 'C';
    } else if (averagePercentage >= 60) {
        grade = 'D';
    } else if (averagePercentage >= 40) {
        grade = 'E';
    } else {
        grade = 'F';
    }

    // 5. Display Results
    IO.println("\n--- RESULTS ---");
    IO.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
    System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
    IO.println("Grade: " + grade);

    scanner.close();
}
