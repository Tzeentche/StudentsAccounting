import org.w3c.dom.ls.LSOutput;

public class StudentOrderValidator {

    public static void main(String[] args) {

        checkAll();
    }

    static void checkAll() {

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

    static StudentOrder readStudentOrder() {

        StudentOrder so = new StudentOrder();
        return so;
    }
    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";
        crv1.login = "liogin1";
        crv1.password = "password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "Host2";
        crv2.login = "liogin2";
        crv2.password = "password2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);
        AnswerCityRegister ans2 = crv2.checkCityRegister(so);
        return ans1;
    }

    static AnswerWedding checkWedding(StudentOrder so) {
        return WeddingRegisterValidator.checkWedding(so);
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        return ChildrenRegisterValidator.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        return StudentRegisterValidator.checkStudent(so);
    }

    static void sendMail(StudentOrder so) {

    }
}
