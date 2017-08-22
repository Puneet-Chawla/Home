package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class ElectricalModel {

    // Appliance , N1 , N2 ,N3 , Phone , Address
    String appliance,repair,install,uninstall,address,phone;

    public ElectricalModel() {
    }

    public ElectricalModel(String address, String appliance, String install, String phone, String repair, String uninstall) {
        this.address = address;
        this.appliance = appliance;
        this.install = install;
        this.phone = phone;
        this.repair = repair;
        this.uninstall = uninstall;
    }

    public String getAddress() {
        return address;
    }

    public String getAppliance() {
        return appliance;
    }

    public String getInstall() {
        return install;
    }

    public String getPhone() {
        return phone;
    }

    public String getRepair() {
        return repair;
    }

    public String getUninstall() {
        return uninstall;
    }
}
