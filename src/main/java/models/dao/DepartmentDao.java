package models.dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {

    //add department to db
    void addDepartment(Department department);

    //Return all departments
    List<Department> allDepartments();
}
