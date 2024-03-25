package com.example.awesomeresume;

import com.example.awesomeresume.bean.User;
import com.example.awesomeresume.dao.impl.UserDaoImpl;
import com.example.awesomeresume.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = new UserDaoImpl();
      User user= new User();
      user.setId(2);
        user.setName("Nazrin");
        userDao.updateUser(user);

    }
}
