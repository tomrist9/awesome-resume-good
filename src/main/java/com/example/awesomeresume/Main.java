package com.example.awesomeresume;

import com.example.awesomeresume.dao.inter.UserSkillDaoInter;
import com.example.awesomeresume.entity.User;
import com.example.awesomeresume.dao.impl.UserDaoImpl;
import com.example.awesomeresume.dao.inter.UserDaoInter;

public class Main extends javax.swing.JFrame{

    public static void main(String[] args) throws Exception {
        UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
        System.out.println(userSkillDao.getAllSkillByUserId(6));

    }
}
