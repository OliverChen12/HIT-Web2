package cn.hit.oliver.dao;

import cn.hit.oliver.entity.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    boolean searchStudentBySid(String sid);
    List<Student> getStudent(String sql);
}
