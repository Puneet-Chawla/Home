package com.example.student.hsar;

/**
 * Created by Student on 7/9/2017.
 */

public class AcModel {
    public String acType,service,address,id,servicingno,installno,repairno,phone,uninstallno;
    // n1 , n2 , n3 , Phon , Address , s1 , acType
    public AcModel() {
    }

    public AcModel(String acType, String address, String id, String installno, String phone, String repairno, String service, String servicingno, String uninstallno) {
        this.acType = acType;
        this.address = address;
        this.id = id;
        this.installno = installno;
        this.phone = phone;
        this.repairno = repairno;
        this.service = service;
        this.servicingno = servicingno;
        this.uninstallno = uninstallno;
    }
}
