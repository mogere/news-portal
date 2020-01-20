package models.dao;


import models.User;

import java.util.List;

public interface UserDao {

    //add user to DB
    void add(User user);

    //return list of all users
    List<User> getAll();

    //return list of all users in a department
    List<User> getAllUsersInDepartment(int departmentId);

    //return specific information about a user
    User getUserInfo(int userId);

}
