package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    public static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM jc_street WHERE UPPER(street_name) LIKE UPPER(?)";

    private Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connect;
    }

    public List<Street> findStreets(String pattern) throws DaoException {

        List<Street> result = new LinkedList<>();

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(GET_STREET)){

                stmt.setString(1, pattern);
                ResultSet res = stmt.executeQuery();
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
