package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class CarpenterModel {
    // Address , phone , Problem
    String address,phone,problem;

    public CarpenterModel() {

    }

    public CarpenterModel(String address, String phone, String problem) {
        this.address = address;
        this.phone = phone;
        this.problem = problem;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getProblem() {
        return problem;
    }
}
