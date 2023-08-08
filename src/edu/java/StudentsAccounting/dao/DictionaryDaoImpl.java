package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.CountryArea;
import edu.java.StudentsAccounting.domain.PassportOffice;
import edu.java.StudentsAccounting.domain.RegisterOffice;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {

    public static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM jc_street WHERE UPPER(street_name) LIKE UPPER(?)";

    public static final String GET_PASSPORT = "SELECT * " +
            "FROM jc_passport_office WHERE p_office_area_id = ?";

    public static final String GET_REGISTER = "SELECT * " +
            "FROM jc_register_office WHERE r_office_area_id = ?";

    public static final String GET_AREA = "SELECT * " +
            "FROM jc_country_struct WHERE area_id like ? and area_id <> ?";

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

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoException {

        List<PassportOffice> result = new LinkedList<>();

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(GET_PASSPORT)){

            stmt.setString(1, areaId);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                PassportOffice str = new PassportOffice(
                        res.getLong("p_office_id"),
                        res.getString("p_office_area_id"),
                        res.getString("p_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException {

        List<RegisterOffice> result = new LinkedList<>();

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(GET_REGISTER)){

            stmt.setString(1, areaId);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                RegisterOffice str = new RegisterOffice(
                        res.getLong("r_office_id"),
                        res.getString("r_office_area_id"),
                        res.getString("r_office_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return result;
    }

    @Override
    public List<CountryArea> findAreas(String areaId) throws DaoException {
        List<CountryArea> result = new LinkedList<>();

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(GET_AREA)){

            String param1 = buildParam(areaId);
            String param2 = "";

            stmt.setString(1, param1);
            stmt.setString(1, param2);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                CountryArea cntrArea = new CountryArea(
                        res.getString("r_area_id"),
                        res.getString("r_area_name"));
                result.add(cntrArea);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return result;
    }

    private String buildParam(String areaId) {

        if(areaId == null || areaId.trim().isEmpty()) {
            return "__0000000000";
        } if(areaId.endsWith("0000000000")) {
            return areaId.substring(0, 2) + "___0000000";
        } else if(areaId)
    }
}
