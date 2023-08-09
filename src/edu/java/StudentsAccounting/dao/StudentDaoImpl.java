package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.domain.StudentOrder;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;

import static edu.java.StudentsAccounting.dao.DictionaryDaoImpl.GET_STREET;

public class StudentDaoImpl implements StudentOrderDao {

    public static final String INSERT_ORDER =

    private Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connect;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(INSERT_ORDER)){

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return null;
    }
}
