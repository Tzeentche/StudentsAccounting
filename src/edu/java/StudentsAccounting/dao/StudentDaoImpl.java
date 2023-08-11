package edu.java.StudentsAccounting.dao;

import edu.java.StudentsAccounting.config.Config;
import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

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
        Long result = -1L;

        try (Connection connect = getConnection();
             PreparedStatement stmt = connect.prepareStatement(INSERT_ORDER, new String[] {"student_order_id"})){

//            Header
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

//            Husband
            Adult husband = so.getHusband();
            stmt.setString(3, so.getHusband().getSurName());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(7, so.getHusband().getPassportSeria());
            stmt.setString(8, so.getHusband().getPassportNumber());
            stmt.setDate(9, java.sql.Date.valueOf(so.getHusband().getIssueDate()));
            stmt.setLong(10, husband.getIssueDepartment().getOfficeId());

            Address h_address = husband.getAddress();
            stmt.setString(11, h_address.getPostCode());
            stmt.setLong(12, h_address.getStreet().getStreetCode());
            stmt.setString(13, h_address.getBuilding());
            stmt.setString(14, h_address.getExtension());
            stmt.setString(15, h_address.getApartment());

//            Wife
            Adult wife = so.getWife();
            stmt.setString(16, wife.getSurName());
            stmt.setString(17, wife.getGivenName());
            stmt.setString(18, wife.getPatronymic());
            stmt.setDate(19, java.sql.Date.valueOf(wife.getDateOfBirth()));
            stmt.setString(20, wife.getPassportSeria());
            stmt.setString(21, wife.getPassportNumber());
            stmt.setDate(22, java.sql.Date.valueOf(wife.getIssueDate()));
            stmt.setLong(23, wife.getIssueDepartment().getOfficeId());

            Address w_address = wife.getAddress();
            stmt.setString(24, w_address.getPostCode());
            stmt.setLong(25, w_address.getStreet().getStreetCode());
            stmt.setString(26, w_address.getBuilding());
            stmt.setString(27, w_address.getExtension());
            stmt.setString(28, w_address.getApartment());

//              Marriage
            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));
            
            stmt.executeUpdate();
            
            ResultSet gkRs = stmt.getGeneratedKeys();

            if(gkRs.next()) {
                result = gkRs.getLong(1);
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }
}
