package models.dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private final Sql2o sql2o;

    public Sql2oDepartmentDao( Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void addDepartment(Department department) {
        String sql = "INSERT INTO departments (name, description) VALUES (:name, :description)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setDepartmentId(id);
        }
        catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> allDepartments() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments;")
                    .executeAndFetch(Department.class);
        }
    }
}
