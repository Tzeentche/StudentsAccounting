package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.register.CityRegisterResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.exception.CityRegisterException;
import edu.java.StudentsAccounting.exception.TransportException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException;

}
