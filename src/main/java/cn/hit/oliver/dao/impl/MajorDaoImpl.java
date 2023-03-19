package cn.hit.oliver.dao.impl;

import cn.hit.oliver.dao.MajorDao;
import cn.hit.oliver.db.DBUtil;
import cn.hit.oliver.entity.Major;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {
    @Override
    public void addMajor(Major major) {
        DBUtil dbUtil = new DBUtil();
        String mid = major.getMid();
        String mname = major.getMname();
        dbUtil.executeUpdate("insert into major(mid, mname) values('" + mid + "','" + mname + "')");
        dbUtil.close();
    }

    @Override
    public String getByMid(String mid) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery("select mname from major where mid = '" + mid + "'");
        String mname;
        try {
            if (rs.next()) {
                mname = rs.getString(1);
                return mname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return null;
        }
    }

    @Override
    public List<Major> getMajor(String sql) {
        DBUtil dbUtil = new DBUtil();
        ResultSet rs = dbUtil.executeQuery(sql);
        List<Major> majorList = new ArrayList<>();
        String mid, mname;

        try {
            while (rs.next()) {
                mid = rs.getString(1);
                mname = rs.getString(2);
                majorList.add(new Major(mid, mname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            dbUtil.close();
            return majorList;
        }
    }
}
