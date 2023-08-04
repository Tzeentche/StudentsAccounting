package edu.java.StudentsAccounting.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db_url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    public static Properties properties = new Properties();

    public synchronized static String getProperty(String name) {
        if(properties.isEmpty()) {

            try (InputStream is = Config.class.getClassLoader().getResourceAsStream("dao.properties")) {

                properties.load(is);
            } catch (IOException ex ) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }

        return properties.getProperty(name);
    }
}
