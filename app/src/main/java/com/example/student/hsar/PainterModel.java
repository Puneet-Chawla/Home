package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class PainterModel {
    // Address , Phone , Problem
    String address,phone,problem;

    public PainterModel() {
    }

    public PainterModel(String address, String phone, String problem) {
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
