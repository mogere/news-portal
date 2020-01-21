package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    public Department setUpDepartment(){
        return new Department ("Admin", "Administrative issues");
    }

    @Test
    public void instantiates(){
        Department newDepartment = setUpDepartment();
        assertEquals(true, newDepartment instanceof Department);
    }


    @Test
    public void getDepartmentNameTest() {
        Department newDepartment = setUpDepartment();
        assertEquals("Admin", newDepartment.getDepartmentName());
    }


    @Test
    public void setDepartmentNameTest() {
        Department newDepartment = setUpDepartment();
        newDepartment.setDepartmentName("HR");
        assertEquals("HR", newDepartment.getDepartmentName());
    }


    @Test
    public void getDescriptionTest() {
        Department newDepartment = setUpDepartment();
        newDepartment.setDescription("HumanResources");
        assertEquals("HumanResources", newDepartment.getDescription());
    }

    @Test
    public void setDepartmentIdTest() {
        Department newDepartment = setUpDepartment();
        newDepartment.setDepartmentId(5);
        assertEquals(5, newDepartment.getDepartmentId());
    }

    @Test
    public void getDepartmentIdTest() {
        Department newDepartment = setUpDepartment();
        newDepartment.setDepartmentId(5);
        assertEquals(5, newDepartment.getDepartmentId());
    }



}