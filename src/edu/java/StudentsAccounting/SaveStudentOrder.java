package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class SaveStudentOrder {

    public static void main(String[] args) throws Exception {

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

        Street street = new Street(1L, "First Street");

        Address address = new Address("195000", street, "12", "", "142");

        Adult husband = new Adult("Pidor", "Vasilii", "Kamenev",
                LocalDate.of(1977, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment(new PassportOffice());
        husband.setStudentId("" + 10000 + id);
        husband.setAddress(address);

        Adult wife = new Adult("Shmara", "Irina", "Kameneva",
                LocalDate.of(1978, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment(new PassportOffice());
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child1 = new Child("Tvar'", "Veron", "Kameneva",
                LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        child1.setIssueDepartment("Otdel ZAGS # " + id);
        child1.setAddress(address);

        Child child2 = new Child("Tvar'", "Vaskina", "Kameneva",
                LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        child2.setIssueDepartment("Otdel ZAGS # " + id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;

    }
}