package edu.java.StudentsAccounting.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryArea {

    private String areaId;
    private String areaName;

    public CountryArea() {
    }

    public CountryArea(String areaId, String areaName) {
        this.areaId = areaId;
        this.areaName = areaName;
    }

    public String getAreaId() {
        return areaId;
    }

//    public void setAreaId(String areaId) {
//        this.areaId = areaId;
//    }

    public String getAreaName() {
        return areaName;
    }

//    public void setAreaName(String areaName) {
//        this.areaName = areaName;
//    }
}
