package com.ep.domain;

public class QuotaBean {
    private int id;
    private int quota;  //前两个参数用于接收修改导师招生名额
    private int sid;
    private int tid;       //用于修改招生关系

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "QuotaBean{" +
                "id=" + id +
                ", quota=" + quota +
                ", sid=" + sid +
                ", tid=" + tid +
                '}';
    }
}
