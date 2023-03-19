package cn.hit.oliver.entity;

public class Student {
    private String sid;
    private String sname;
    private String gender;
    private String age;
    private String birthday;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Student(String sid, String sname, String gender, String age, String birthday, String mid, String mname) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.mid = mid;
        this.mname = mname;
    }

    private String mid;
    private String mname;

    public Student() {
    }
}

