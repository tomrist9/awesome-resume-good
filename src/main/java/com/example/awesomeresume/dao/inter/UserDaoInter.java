package com.example.awesomeresume.dao.inter;

import com.example.awesomeresume.bean.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll();
    public boolean updateUser(User user);
    public boolean removeUser(int id);
}
