package edu.java.StudentsAccounting.validator;

import edu.java.StudentsAccounting.domain.Adult;
import edu.java.StudentsAccounting.domain.Child;
import edu.java.StudentsAccounting.domain.CityRegisterCheckerResponse;
import edu.java.StudentsAccounting.domain.Person;
import edu.java.StudentsAccounting.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERR_1 = "1002";
    private static final String ERR_2 = "2002";

    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException {

        CityRegisterCheckerResponse res = new CityRegisterCheckerResponse();

        if(person instanceof Adult) {
            Adult t = (Adult) person;
            String ps = t.getPassportSeria();
            String ps2 = t.getPassportSeria();
            if(ps.equals(GOOD_1) || ps.equals(GOOD_2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }

            if(ps.equals(BAD_1) || ps.equals(BAD_2)) {
                res.setTemporal(false);
            }

            if(ps.equals(ERR_1) || ps.equals(ERR_2)) {
                CityRegisterException ex = new CityRegisterException("Fake ERROR " + ps);
                throw ex;
            }
        }

        if(person instanceof Child) {
            res.setExisting(true);
            res.setTemporal(true);
        }

        System.out.println(res);

        return res;
    }
}
