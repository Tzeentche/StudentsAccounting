package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.Adult;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class SaveStudentOrder {

    public static void main(String[] args) {

//        buildStudentOrder();
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 1999;
        System.out.println("SaveStudentOrder");

        return answer;
    }

    static StudentOrder buildStudentOrder(long id) {

        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);

        Adult husband = new Adult("Pidorov", "Vasilii", "Kamenev", null);

        return so;

    }
}