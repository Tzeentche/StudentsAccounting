package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.AnswerChildren;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class ChildrenValidator {

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
