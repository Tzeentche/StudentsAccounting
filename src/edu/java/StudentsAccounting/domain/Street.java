package edu.java.StudentsAccounting.domain;

public class Street {

    private long StreetCode;
    private String streetName;

    public long getStreetCode() {
        return StreetCode;
    }

    public void setStreetCode(long streetCode) {
        StreetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Street(long streetCode, String streetName) {
        StreetCode = streetCode;
        this.streetName = streetName;
    }

    public Street() {
    }
}
