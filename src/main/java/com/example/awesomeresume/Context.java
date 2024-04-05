package com.example.awesomeresume;

import com.example.awesomeresume.dao.impl.UserDaoImpl;
import com.example.awesomeresume.dao.impl.UserSkillDaoImpl;
import com.example.awesomeresume.dao.inter.UserDaoInter;
import com.example.awesomeresume.dao.inter.UserSkillDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
}
