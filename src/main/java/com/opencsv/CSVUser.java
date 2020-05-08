package com.opencsv;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    public  String Name;

    @CsvBindByName(column = "email", required = true)
    public   String Email;

    @CsvBindByName(column = "phone")
    public  String PhoneNo;

    @CsvBindByName
    public  String Country;

    public CSVUser(String Name, String Email, String PhoneNo, String Country) {
        this.Name = Name;
        this.Email = Email;
        this.PhoneNo = PhoneNo;
        this.Country = Country;
    }

    public CSVUser() {
    }

    @Override
    public  String toString() {
        return "CSVUserTest{" +
                "name=" + Name + '\'' +
                ", email=" + Email + '\'' +
                ", phoneNo=" + PhoneNo + '\'' +
                ", country=" + Country + '\'' +
                '}';
    }

    public String getName() {

        return Name;
    }

    public String getEmail() {

        return Email;
    }

    public String getPhoneNo() {

        return PhoneNo;
    }

    public String getCountry() {

        return Country;
    }
}
