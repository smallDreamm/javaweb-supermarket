package com.example.entity;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Thing {

    private String thingcode;
    private String thingname;
    private String personname;
    private String tel;
    private String fax;
    private Date  makedate;

    public String getThingcode() {
        return thingcode;
    }

    public void setThingcode(String thingcode) {
        this.thingcode = thingcode;
    }

    public String getThingname() {
        return thingname;
    }

    public void setThingname(String thingname) {
        this.thingname = thingname;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Date getMakedate() {
        return makedate;
    }

    public void setMakedate(Date makedate) {
        this.makedate = makedate;
    }



}
