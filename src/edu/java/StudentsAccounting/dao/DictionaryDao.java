package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.domain.CountryArea;
import edu.java.StudentsAccounting.domain.PassportOffice;
import edu.java.StudentsAccounting.domain.RegisterOffice;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;
}
