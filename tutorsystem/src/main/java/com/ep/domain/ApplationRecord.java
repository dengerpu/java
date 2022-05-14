package com.ep.domain;

import java.util.Date;

public class ApplationRecord {
    private int id;
    private int tid;
    private int sid;
    private String sname;
    private String tname;
    private Date create_time;
    private Date update_time;
    private Boolean is_agree;
    private String major;
    private String susername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Boolean getIs_agree() {
        return is_agree;
    }

    public void setIs_agree(Boolean is_agree) {
        this.is_agree = is_agree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    @Override
    public String toString() {
        return "ApplationRecord{" +
                "id=" + id +
                ", tid=" + tid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", tname='" + tname + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", is_agree=" + is_agree +
                ", major='" + major + '\'' +
                ", susername='" + susername + '\'' +
                '}';
    }
}
