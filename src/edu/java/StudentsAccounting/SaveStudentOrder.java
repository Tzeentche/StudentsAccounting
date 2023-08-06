package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.dao.DictionaryDaoImpl;
import edu.java.StudentsAccounting.domain.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {

    public static void main(String[] args) throws Exception {

        List<Street> d = new DictionaryDaoImpl().findStreets("Про");
        for (Street s : d ) {
            System.out.println(s.getStreetName());
        }

        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        for(PassportOffice p : po) {
            System.out.println(p.getOfficeName());
        }

        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        for(RegisterOffice r : ro) {
            System.out.println(r.getOfficeName());
        }
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
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(1L, "First Street");

        Address address = new Address("195000", street, "12", "", "142");

        Adult husband = new Adult("Pidor", "Vasilii", "Kamenev",
                LocalDate.of(1977, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + 10000 + id);
        husband.setAddress(address);

        Adult wife = new Adult("Shmara", "Irina", "Kameneva",
                LocalDate.of(1978, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(1L, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child1 = new Child("Tvar'", "Veron", "Kameneva",
                LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro1 = new RegisterOffice(1L, "", "");
        child1.setIssueDepartment(ro1);
        child1.setAddress(address);

        Child child2 = new Child("Tvar'", "Vaskina", "Kameneva",
                LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(1L, "", "");
        child2.setIssueDepartment(ro2);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;

    }
}