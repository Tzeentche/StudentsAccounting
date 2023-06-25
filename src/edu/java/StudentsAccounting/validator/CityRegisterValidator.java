package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.AnswerCityRegister;
import edu.java.StudentsAccounting.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    public String login;
    public String password;

        public AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister is running: " + hostName + ", " + login + ", " + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
