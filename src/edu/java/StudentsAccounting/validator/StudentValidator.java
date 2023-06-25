package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.AnswerStudent;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class StudentValidator {

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Students checking is running");
        return new AnswerStudent();
    }
}
