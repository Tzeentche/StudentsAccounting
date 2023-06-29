package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.Adult;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class SaveStudentOrder {

    public static void main(String[] args) {

        buildStudentOrder();

//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 1999;
        System.out.println("SaveStudentOrder");

        return answer;
    }

    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Trifon");
        husband.setSurName("Pidorov");
        husband.setPassportNumber("12345678001");
        so.setHusband(husband);

        String ans = husband.getPersonString();
        System.out.println(ans);

        return so;
    }
}