package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.domain.register.AnswerCityRegister;
import edu.java.StudentsAccounting.domain.register.AnswerCityRegisterItem;
import edu.java.StudentsAccounting.domain.register.CityRegisterResponse;
import edu.java.StudentsAccounting.exception.CityRegisterException;

import java.util.Iterator;
import java.util.List;

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
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for(Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }
        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
            CityRegisterResponse cans = personChecker.checkPerson(person);

        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
        }

        return null;
    }
}
