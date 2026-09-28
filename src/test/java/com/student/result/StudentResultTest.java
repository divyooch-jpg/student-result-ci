package com.student.result;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentResultTest {

    private StudentResult studentResult;

    @BeforeEach
    void setUp() {
        studentResult = new StudentResult();
    }

    @Test
    void totalIsCalculatedCorrectly() {
        int[] marks = {80, 70, 90};
        assertEquals(240, studentResult.calculateTotal(marks));
    }

    @Test
    void averageIsCalculatedCorrectly() {
        int[] marks = {80, 70, 90};
        assertEquals(80.0, studentResult.calculateAverage(marks), 0.001);
    }

    @Test
    void gradeIsAssignedCorrectlyForEachRange() {
        assertEquals("A+", studentResult.calculateGrade(95));
        assertEquals("A", studentResult.calculateGrade(85));
        assertEquals("B", studentResult.calculateGrade(72));
        assertEquals("C", studentResult.calculateGrade(65));
        assertEquals("D", studentResult.calculateGrade(55));
        assertEquals("E", studentResult.calculateGrade(45));
        assertEquals("F", studentResult.calculateGrade(30));
    }

    @Test
    void studentPassesWhenAllMarksAreAtLeastPassMark() {
        int[] marks = {40, 55, 90};
        assertTrue(studentResult.isPassed(marks));
    }

    @Test
    void studentFailsWhenAnyMarkIsBelowPassMark() {
        int[] marks = {80, 39, 90};
        assertFalse(studentResult.isPassed(marks));
    }

    @Test
    void markAboveMaximumThrowsException() {
        int[] marks = {101, 50};
        assertThrows(IllegalArgumentException.class,
                () -> studentResult.calculateTotal(marks));
    }

    @Test
    void emptyMarksThrowsException() {
        int[] marks = {};
        assertThrows(IllegalArgumentException.class,
                () -> studentResult.calculateAverage(marks));
    }
}
