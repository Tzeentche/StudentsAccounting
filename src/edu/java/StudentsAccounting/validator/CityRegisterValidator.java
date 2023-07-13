package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.exception.CityRegisterException;
import org.w3c.dom.ls.LSOutput;

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

        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());

            List<Child> children = so.getChildren();

            for (int i = 0; i < so.getChildren().size(); i++) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChildren().get(i));
            }

            for(Iterator<Child> it = children.iterator(); it.hasNext(); ) {

                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

            for(Child child : children) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

        } catch (CityRegisterException e) {
            e.printStackTrace(System.out);
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
