package com.ep.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 制定成长培养计划
 * */
public class GrowthPlan implements Serializable {
    private int id;
    private String username;
    private int sid;
    private int tid;
    private String plan;
    private Date create_time;
    private Date update_time;
    private Date dateline;  //截止时间
    private String direction;//学习方向

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "GrowthPlan{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sid=" + sid +
                ", tid=" + tid +
                ", plan='" + plan + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", dateline=" + dateline +
                ", direction='" + direction + '\'' +
                '}';
    }
}
