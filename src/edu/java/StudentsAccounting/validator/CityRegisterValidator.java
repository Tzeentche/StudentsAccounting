package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.AnswerCityRegister;
import edu.java.StudentsAccounting.domain.CityRegisterCheckerResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.domain.StudentOrder;
import edu.java.StudentsAccounting.exception.CityRegisterException;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    public String login;
    public String password;

    private FakeCityRegisterChecker personChecker;

    public CityRegisterValidator() {

        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {

        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getHusband());
        } catch (CityRegisterException e) {
            e.printStackTrace();
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
