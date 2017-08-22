package com.example.student.hsar;

/**
 * Created by Student on 7/10/2017.
 */

public class FeedbackModel {
    String rating,memberid,complaint,service,phone;

    public FeedbackModel() {
    }

    public FeedbackModel(String complaint, String memberid, String rating, String service,String phone) {
        this.complaint = complaint;
        this.memberid = memberid;
        this.rating = rating;
        this.service = service;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getMemberid() {
        return memberid;
    }

    public String getRating() {
        return rating;
    }

    public String getService() {
        return service;
    }
}
