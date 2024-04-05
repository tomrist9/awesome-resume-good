package com.example.awesomeresume.dao.impl;

import com.example.awesomeresume.entity.Country;
import com.example.awesomeresume.entity.User;
import com.example.awesomeresume.dao.inter.AbstractDAO;
import com.example.awesomeresume.dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet resultSet) throws Exception {
     int id = resultSet.getInt("id");
     String name= resultSet.getString("name");
     String surname= resultSet.getString("surname");
     String phone= resultSet.getString("phone");
     String email= resultSet.getString("email");
     int nationalityId=resultSet.getInt("nationality_id");
     int birthplaceId=resultSet.getInt("birthplace_id");
     String nationalityStr= resultSet.getString("nationality");
     String birthPlaceStr= resultSet.getString("birthplace");

     Date birthdate=resultSet.getDate("birthdate");
     Country nationality= new Country(nationalityId, null,
             nationalityStr);
     Country birthplace=new Country(birthplaceId, birthPlaceStr, null);

     return new User(id, name, surname, phone, email, birthdate, nationality, birthplace);
    }


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        try( Connection connection = connect()) {

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
    public void addUser(User u){
        try(Connection connection=connect()){
            PreparedStatement statement= connect().prepareStatement("insert into user(name, surname, phone, email, profilDescription, address, birthdate, birthplace_id, nationality_id)");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getPhone());
            statement.setString(4, u.getEmail());
            statement.execute();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }


    @Override
    public User getById(int id) {
        User result=null;
        try(Connection connection=connect()){
            Statement statement=connection.createStatement();
            statement.execute("select "
                    +"u.*,"
                    +"n.nationality as nationality,"
                    +"c.name as birthplace"
                    +"from user u"
                    +"left join country  n on u.nationality.id=id"
                    + "left join on country c on u.birthplace_id=id where u.id="+id);
            ResultSet resultSet=statement.getResultSet();

            while(resultSet.next()){
                result=getUser(resultSet);
            }
        }catch (Exception exception){
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
