package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {

        StudentOrder so = new StudentOrder();
        so.hFirstName = "Trofim";
        so.hLastName = "Trifonov";
        so.wFirstName = "Parafia";
        so.wLastName = "Trifonova";

        StudentOrder so1 = new StudentOrder();
        so1.hFirstName = "Trofim";
        so1.hLastName = "Trifonov";
        so1.wFirstName = "Parafia";
        so1.wLastName = "Trifonova";

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 1999;
        System.out.println("edu.java.StudentsAccounting.SaveStudentOrder" + studentOrder.hLastName);

        return answer;
    }
}