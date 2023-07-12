package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.Address;
import edu.java.StudentsAccounting.domain.Adult;
import edu.java.StudentsAccounting.domain.Child;
import edu.java.StudentsAccounting.domain.StudentOrder;

import java.time.LocalDate;

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
        so.setMarriageCertificateId("" + (12345000 + id));
        so.setMarriageDate(LocalDate.of(2023, 7 , 4));
//        so.setMarriageOffice("Otdel ZAGS");

        Address address = new Address("195000", "ave. Warszawske", "12", "", "142");

        Adult husband = new Adult("Pidor", "Vasilii", "Kamenev",
                LocalDate.of(1977, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Police otdel #" + id);
        husband.setStudentId("" + 10000 + id);
        husband.setAddress(address);

        Adult wife = new Adult("Shmara", "Irina", "Kameneva",
                LocalDate.of(1978, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Otdel Police #" + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child = new Child("Tvar'", "Veron", "Kameneva",
                LocalDate.of(2018, 6, 29));
        child.setCertificateNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018, 7, 19));
        child.setIssueDepartment("Otdel ZAGS #" + id);
        child.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.setChild(child);

        return so;

    }
}