package com.example.awesomeresume.dao.inter;

import com.example.awesomeresume.entity.EmploymentHistory;

import java.sql.ResultSet;
import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryById(int userId);

}
