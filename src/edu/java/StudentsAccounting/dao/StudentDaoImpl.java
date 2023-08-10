package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.Street;
import edu.java.StudentsAccounting.domain.StudentOrder;
import edu.java.StudentsAccounting.domain.StudentOrderStatus;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;

import static edu.java.StudentsAccounting.dao.DictionaryDaoImpl.GET_STREET;

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

            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(3, so.getHusband().getSurName());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(7, so.getHusband().getPassportSeria());
            stmt.setString(8, so.getHusband().getPassportNumber());
            stmt.setDate(9, java.sql.Date.valueOf(so.getHusband().getIssueDate()));
            stmt.setString(10, so.getHusband().getIssueDepartment().getOfficeAreaId());
            stmt.setString(11, so.getHusband().getPatronymic());
            stmt.setString(12, so.getHusband().getPatronymic());
            stmt.setString(13, so.getHusband().getPatronymic());
            stmt.setString(14, so.getHusband().getPatronymic());
            stmt.setString(15, so.getHusband().getPatronymic());
            stmt.setString(16, so.getHusband().getPatronymic());
            stmt.setString(17, so.getHusband().getPatronymic());
            stmt.setString(18, so.getHusband().getPatronymic());
            stmt.setString(19, so.getHusband().getPatronymic());
            stmt.setString(20, so.getHusband().getPatronymic());
            stmt.setString(21, so.getHusband().getPatronymic());
            stmt.setString(22, so.getHusband().getPatronymic());
            stmt.setString(23, so.getHusband().getPatronymic());
            stmt.setString(24, so.getHusband().getPatronymic());
            stmt.setString(25, so.getHusband().getPatronymic());
            stmt.setString(26, so.getHusband().getPatronymic());
            stmt.setString(27, so.getHusband().getPatronymic());
            stmt.setString(28, so.getHusband().getPatronymic());
            stmt.setString(29, so.getHusband().getPatronymic());
            stmt.setString(30, so.getHusband().getPatronymic());
            stmt.setString(31, so.getHusband().getPatronymic());
            stmt.setString(32, so.getHusband().getPatronymic());
            stmt.setString(33, so.getHusband().getPatronymic());
            stmt.setString(34, so.getHusband().getPatronymic());
            stmt.setString(35, so.getHusband().getPatronymic());


        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return 0L;
    }
}
