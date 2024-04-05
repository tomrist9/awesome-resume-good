package com.example.awesomeresume.dao.inter;

import com.example.awesomeresume.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int userId);
}
