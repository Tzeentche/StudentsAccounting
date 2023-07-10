package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.CityRegisterCheckerResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException {


        return null;
    }
}
