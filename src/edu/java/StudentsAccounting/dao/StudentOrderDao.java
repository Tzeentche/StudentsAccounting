package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.domain.StudentOrder;
import edu.java.StudentsAccounting.exception.DaoException;

public interface StudentOrderDao {

    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
