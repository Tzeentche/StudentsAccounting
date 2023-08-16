package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.domain.StudentOrder;
import edu.java.StudentsAccounting.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {

    Long saveStudentOrder(StudentOrder so) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;
}
