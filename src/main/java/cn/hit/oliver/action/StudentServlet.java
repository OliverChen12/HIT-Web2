package cn.hit.oliver.action;

import cn.hit.oliver.dao.MajorDao;
import cn.hit.oliver.dao.StudentDao;
import cn.hit.oliver.dao.impl.MajorDaoImpl;
import cn.hit.oliver.dao.impl.StudentDaoImpl;
import cn.hit.oliver.entity.Major;
import cn.hit.oliver.entity.Student;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if("getStudent".equals(action)){
            StudentDao studentDao = new StudentDaoImpl();
            List<Student> studentList = studentDao.getStudent("select * from student");
            out.println(JSON.toJSONString(studentList));
        }
        else{
            String sid = request.getParameter("sid");
            String sname = request.getParameter("sname");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            String mid = request.getParameter("mid");
            String mname = request.getParameter("mname");
            StudentDao studentDao = new StudentDaoImpl();
            studentDao.addStudent(new Student(sid, sname, gender, age, birthday, mid, mname));
            response.sendRedirect("student.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
