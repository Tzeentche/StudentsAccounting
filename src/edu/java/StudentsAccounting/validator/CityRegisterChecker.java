package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.register.CityRegisterResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.exception.CityRegisterException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person) throws CityRegisterException;

}
