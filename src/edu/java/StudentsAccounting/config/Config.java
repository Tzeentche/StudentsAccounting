package edu.java.StudentsAccounting.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "jdbc:postgresql://localhost/jc_student";
    public static final String DB_LOGIN = "postgres";
    public static final String DB_PASSWORD = "root";
    public static final String DB_LIMIT = "1000";

    private static Properties properties = new Properties();

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("dao.properties")) {

                properties.load(is);

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return properties.getProperty(name);
    }
}
