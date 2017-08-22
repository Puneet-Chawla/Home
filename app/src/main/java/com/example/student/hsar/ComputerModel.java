package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class ComputerModel {
    String  issue , device , address , phone;

    public ComputerModel() {
    }

    public ComputerModel(String address, String device, String issue, String phone) {
        this.address = address;
        this.device = device;
        this.issue = issue;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getDevice() {
        return device;
    }

    public String getIssue() {
        return issue;
    }

    public String getPhone() {
        return phone;
    }
}
