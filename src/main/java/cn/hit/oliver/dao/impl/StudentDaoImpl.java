package cn.hit.oliver.dao.impl;

import cn.hit.oliver.dao.MajorDao;
import cn.hit.oliver.dao.StudentDao;
import cn.hit.oliver.db.DBUtil;
import cn.hit.oliver.entity.Major;
import cn.hit.oliver.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student student) {
        DBUtil dbUtil = new DBUtil();
        String sid = student.getSid();
        String age = student.getAge();
        String sname = student.getSname();
        String gender = student.getGender();
        String birthday = student.getBirthday();
        String mid = student.getMid();
        String mname = student.getMname();
        dbUtil.executeUpdate("insert into student(sid, sname, age, gender, birthday, mid, mname) values('" + sid + "','" + sname + "','" + age + "','" + gender + "','" + birthday + "','" + mid + "','" + mname + "')");
        dbUtil.close();
    }

    @Override
    public List<Student> getStudent(String sql) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Student> students = new ArrayList<>();
        String sid,sname,gender,birthday,age,mid,mname;
        try{
            while(rs.next()){
                sid = rs.getString(1);
                sname = rs.getString(2);
                gender = rs.getString(3);
                age = rs.getString(4);
                birthday = rs.getString(5);
                mid = rs.getString(6);
                mname = rs.getString(7);
                students.add(new Student(sid, sname, gender, age, birthday, mid, mname));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return students;
        }
    }

    @Override
    public boolean searchStudentBySid(String sid) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery("select sid from student");
        try {
            while(rs.next()){
                if(sid.equals(rs.getString(1)))
                    return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            dbUtil.close();
        }
        return false;
    }
}
