package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class PlumberModel {
    String add,phone,problem;

    public PlumberModel() {
    }

    public PlumberModel(String add, String phone, String problem) {
        this.add = add;
        this.phone = phone;
        this.problem = problem;
    }

    public String getAdd() {
        return add;
    }

    public String getPhone() {
        return phone;
    }

    public String getProblem() {
        return problem;
    }
}
