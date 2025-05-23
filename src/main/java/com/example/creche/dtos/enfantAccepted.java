package com.example.creche.dtos;

public class enfantAccepted {
    private long parentid;
    private long enfantid;
    public enfantAccepted(long parentid , long enfantid){
        this.enfantid = enfantid;
        this.parentid = parentid;
    }

    public long getEnfantid() {
        return enfantid;
    }public long getParentid() {
        return parentid;
    }public void setEnfantid(long enfantid) {
        this.enfantid = enfantid;
    }public void setParentid(long parentid) {
        this.parentid = parentid;
    }

}
