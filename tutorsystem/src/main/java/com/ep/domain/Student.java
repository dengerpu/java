package com.ep.domain;

public class Student {

    private int id;            //id
    private String username;    //用户名
    private String name;        //姓名
    private String sex;         //性别
    private int age;            //年龄
    private String college;     //学院
    private String major;       //专业
    private String email;       //邮箱
    private String phone;       //电话
    private String image;       //头像
    private String interest;    //兴趣
    private String introduce;   //个人介绍
    private String introduce_brief; //精简版个人介绍
    private String honor;       //个人荣誉
    private String turtor;      //导师

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIntroduce_brief() {
        return introduce_brief;
    }

    public void setIntroduce_brief(String introduce_brief) {
        this.introduce_brief = introduce_brief;
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getTurtor() {
        return turtor;
    }

    public void setTurtor(String turtor) {
        this.turtor = turtor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", interest='" + interest + '\'' +
                ", introduce='" + introduce + '\'' +
                ", introduce_brief='" + introduce_brief + '\'' +
                ", honor='" + honor + '\'' +
                ", turtor='" + turtor + '\'' +
                '}';
    }
}
