package com.student.result;

public class StudentResult {

    public static final int MAX_MARKS = 100;
    public static final int PASS_MARK = 40;

    public int calculateTotal(int[] marks) {
        validateMarks(marks);
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAverage(int[] marks) {
        int total = calculateTotal(marks);
        return (double) total / marks.length;
    }

    public String calculateGrade(double average) {
        if (average < 0 || average > MAX_MARKS) {
            throw new IllegalArgumentException("Average must be between 0 and 100");
        }
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else if (average >= PASS_MARK) {
            return "E";
        }
        return "F";
    }

    public boolean isPassed(int[] marks) {
        validateMarks(marks);
        for (int mark : marks) {
            if (mark < PASS_MARK) {
                return false;
            }
        }
        return true;
    }

    private void validateMarks(int[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("Marks must not be empty");
        }
        for (int mark : marks) {
            if (mark < 0 || mark > MAX_MARKS) {
                throw new IllegalArgumentException("Each mark must be between 0 and 100");
            }
        }
    }
}
