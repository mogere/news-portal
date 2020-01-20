package models.dao;


import models.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> getAll();
    List<User> getAllUsersInDepartment(int departmentId);
    User getUserInfo(int userId);

}
