package cn.hit.oliver.dao;

import cn.hit.oliver.entity.Major;

import java.util.List;

public interface MajorDao {
    void addMajor(Major major);
    String getByMid(String mid);
    public List<Major> getMajor(String sql);
}
