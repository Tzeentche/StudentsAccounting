package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.CityRegisterCheckerResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.exception.CityRegisterException;

public interface CityRegisterChecker {

    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException;

}
