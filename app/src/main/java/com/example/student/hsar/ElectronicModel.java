package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class ElectronicModel {
    String appliance , repair , address , phone;

    public ElectronicModel() {
    }

    public ElectronicModel(String address, String appliance, String phone, String repair) {
        this.address = address;
        this.appliance = appliance;
        this.phone = phone;
        this.repair = repair;
    }

    public String getAddress() {
        return address;
    }

    public String getAppliance() {
        return appliance;
    }

    public String getPhone() {
        return phone;
    }

    public String getRepair() {
        return repair;
    }
}
