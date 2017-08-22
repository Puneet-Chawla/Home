package com.example.student.hsar;

/**
 * Created by Student on 7/18/2017.
 */

public class FridgeModel {
    String Appliance , Repair , Add , Phone;

    public FridgeModel() {
    }

    public FridgeModel(String add, String appliance, String phone, String repair) {
        Add = add;
        Appliance = appliance;
        Phone = phone;
        Repair = repair;
    }

    public String getAdd() {
        return Add;
    }

    public String getAppliance() {
        return Appliance;
    }

    public String getPhone() {
        return Phone;
    }

    public String getRepair() {
        return Repair;
    }
}
