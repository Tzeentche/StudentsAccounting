package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.AnswerWedding;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class WeddingValidator {

    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding is running");
        return new AnswerWedding();
    }
}
