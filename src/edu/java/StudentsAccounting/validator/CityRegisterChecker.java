package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.CityRegisterCheckerResponse;
import edu.java.StudentsAccounting.domain.Person;

public interface CityRegisterChecker {

    CityRegisterCheckerResponse checkPerson(Person person);

}
