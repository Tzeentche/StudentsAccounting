package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentDaoImpl implements StudentOrderDao {

    public static final String INSERT_ORDER = "INSERT INTO jc_student_order(\" +\n" +
            "                    \" student_order_status, student_order_date, h_sur_name, \" +\n" +
            "                    \" h_given_name, h_patronymic, h_date_of_birth, h_passport_seria, \" +\n" +
            "                    \" h_passport_number, h_passport_date, h_passport_office_id, h_post_index, \" +\n" +
            "                    \" h_street_code, h_building, h_extension, h_apartment, h_university_id, h_student_number, \" +\n" +
            "                    \" w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, \" +\n" +
            "                    \" w_passport_number, w_passport_date, w_passport_office_id, w_post_index, \" +\n" +
            "                    \" w_street_code, w_building, w_extension, w_apartment, w_university_id, w_student_number, \" +\n" +
            "                    \" certificate_id, register_office_id, marriage_date)\" +\n" +
            "                    \" VALUES (?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?, ?, ?, ?, \" +\n" +
            "                    \" ?, ?, ?);";

    private static final String INSERT_CHILD =
            "INSERT INTO jc_student_child(" +
                    " student_order_id, c_sur_name, c_given_name, " +
                    " c_patronymic, c_date_of_birth, c_certificate_number, c_certificate_date, " +
                    " c_register_office_id, c_post_index, c_street_code, c_building, " +
                    " c_extension, c_apartment)" +
                    " VALUES (?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?)";

    private static final String SELECT_ORDERS =
            "SELECT so.*, ro.r_office_area_id, ro.r_office_name, " +
                    "po_h.p_office_area_id as h_p_office_area_id, " +
                    "po_h.p_office_name as h_p_office_name, " +
                    "po_w.p_office_area_id as w_p_office_area_id, " +
                    "po_w.p_office_name as w_p_office_name " +
                    "FROM jc_student_order so " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = so.register_office_id " +
                    "INNER JOIN jc_passport_office po_h ON po_h.p_office_id = so.h_passport_office_id " +
                    "INNER JOIN jc_passport_office po_w ON po_w.p_office_id = so.w_passport_office_id " +
                    "WHERE student_order_status = ? ORDER BY student_order_date LIMIT ?";

    private static final String SELECT_CHILD =
            "SELECT soc.*, ro.r_office_area_id, ro.r_office_name " +
                    "FROM jc_student_child soc " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = soc.c_register_office_id " +
                    "WHERE soc.student_order_id IN ";

    private static final String SELECT_ORDERS_FULL =
            "SELECT so.*, ro.r_office_area_id, ro.r_office_name, " +
                    "po_h.p_office_area_id as h_p_office_area_id, " +
                    "po_h.p_office_name as h_p_office_name, " +
                    "po_w.p_office_area_id as w_p_office_area_id, " +
                    "po_w.p_office_name as w_p_office_name, " +
                    "soc.*, ro_c.r_office_area_id, ro_c.r_office_name " +
                    "FROM jc_student_order so " +
                    "INNER JOIN jc_register_office ro ON ro.r_office_id = so.register_office_id " +
                    "INNER JOIN jc_passport_office po_h ON po_h.p_office_id = so.h_passport_office_id " +
                    "INNER JOIN jc_passport_office po_w ON po_w.p_office_id = so.w_passport_office_id " +
                    "INNER JOIN jc_student_child soc ON soc.student_order_id = so.student_order_id " +
                    "INNER JOIN jc_register_office ro_c ON ro_c.r_office_id = soc.c_register_office_id " +
                    "WHERE student_order_status = ? ORDER BY so.student_order_id LIMIT ?";


    private Connection getConnection() throws SQLException {
        Connection connect = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connect;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        Long result = -1L;

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(INSERT_ORDER, new String[] {"student_order_id"})){

            connect.setAutoCommit(false);

            try {
//            Header
                stmt.setInt(1, StudentOrderStatus.START.ordinal());
                stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

//            Husband and Wife
                setParamsForAdult(stmt, 3, so.getHusband());
                setParamsForAdult(stmt, 16, so.getWife());

//              Marriage
                stmt.setString(29, so.getMarriageCertificateId());
                stmt.setLong(30, so.getMarriageOffice().getOfficeId());
                stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));
                stmt.executeUpdate();

                ResultSet gkRs = stmt.getGeneratedKeys();

                if (gkRs.next()) {
                    result = gkRs.getLong(1);
                }
                gkRs.close();

                saveChildren(connect, so, result);
                connect.commit();

            } catch (SQLException ex) {
                connect.rollback();
                throw ex;
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    private void saveChildren(Connection connect, StudentOrder so, Long soId) throws SQLException {
        try(PreparedStatement stmt = connect.prepareStatement(INSERT_CHILD)) {
            for (Child child : so.getChildren()) {
                stmt.setLong(1, soId);
                setParamsForChild(stmt, child);
                stmt.addBatch();
            }

            stmt.executeBatch();
        }
    }

    private void setParamsForChild(PreparedStatement stmt, Child child) throws SQLException {

        setParamsForPerson(stmt, 2, child);
        stmt.setString(6, child.getCertificateNumber());
        stmt.setDate(7, java.sql.Date.valueOf(child.getIssueDate()));
        stmt.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, 9, child);
    }

    private void setParamsForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start + 4, adult.getPassportSeria());
        stmt.setString(start + 5, adult.getPassportNumber());
        stmt.setDate(start + 6, java.sql.Date.valueOf(adult.getIssueDate()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, start + 8, adult);
    }

    private void setParamsForAddress(PreparedStatement stmt, int start, Person person) throws SQLException {
        Address h_address = person.getAddress();
        stmt.setString(start, h_address.getPostCode());
        stmt.setLong(start + 1, h_address.getStreet().getStreetCode());
        stmt.setString(start + 2, h_address.getBuilding());
        stmt.setString(start + 3, h_address.getExtension());
        stmt.setString(start + 4, h_address.getApartment());
    }

    private void setParamsForPerson(PreparedStatement stmt, int start, Person person) throws SQLException {
        stmt.setString(start, person.getSurName());
        stmt.setString(start + 1, person.getGivenName());
        stmt.setString(start + 2, person.getPatronymic());
        stmt.setDate(start + 3, Date.valueOf(person.getDateOfBirth()));
    }
}
