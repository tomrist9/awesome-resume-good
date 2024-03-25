package com.example.awesomeresume.dao.impl;

import com.example.awesomeresume.bean.User;
import com.example.awesomeresume.dao.inter.AbstractDAO;
import com.example.awesomeresume.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        try {
            Connection connection = connect();
            Statement stmt = connection.createStatement();
            stmt.execute("select * from user");
            ResultSet resultSet = stmt.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                result.add(new User(id, name, surname, phone, email));

            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean updateUser(User user) {
        try( Connection connection = connect()) {

            PreparedStatement stmt = connection.prepareStatement("update user set name =?, surname=?, phone=?, email=? where id=?");
            stmt.setString(1, user.getName());

            stmt.setString(2, user.getSurname());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getEmail());
            stmt.setInt(5, user.getId());
            return stmt.execute();

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;

        }
    }


    @Override
    public boolean removeUser(int id) {
        try {
            Connection connection = connect();
            Statement stmt = connection.createStatement();
            return stmt.execute("delete from user where id=1");

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;

        }
    }
}
