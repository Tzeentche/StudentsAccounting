package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.mail.MailSender;
import edu.java.StudentsAccounting.validator.*;
import org.w3c.dom.ls.LSOutput;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {

        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {

        while(true) {
            StudentOrder so = readStudentOrder();

//            System.out.println("Start!");

            if(so == null) {
                break;
            }

//            System.out.println("Finish!");

                AnswerCityRegister cityAnswer = checkCityRegister(so);
                if(!cityAnswer.success) {
                    //
//                    continue;

                    break;
                }

                AnswerWedding wedAnswer = checkWedding(so);
                AnswerChildren childAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
        }

//        System.out.println("Finish 2");
    }

    public StudentOrder readStudentOrder() {

        StudentOrder so = new StudentOrder();
        return so;
    }
    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);

    }
}
