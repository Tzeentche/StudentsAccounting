package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl {

    private Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
                "postgres", "root");
        return connect;
    }

    public List<Street> findStreets(String pattern) throws DaoException {

        List<Street> result = new LinkedList<>();

        try {
            Connection connect = getConnection();
            Statement stmt = connect.createStatement();
            String sql = "SELECT street_code, street_name " +
                    "FROM jc_street WHERE UPPER(street_name) LIKE UPPER('%" + pattern + "%')";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                Street str = new Street(res.getLong(1), res.getString(2));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return result;
    }
}
