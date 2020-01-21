package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    public User setUpUser(){
        return new User ("John", "Junior", "supervisor", 1);
    }

    @Test
    public void instantiates(){
        User newUser = setUpUser();
        assertEquals(true, newUser instanceof User);
    }


    @Test
    public void getUsernameTest() {
        User newUser = setUpUser();
        assertEquals("John", newUser.getUsername());
    }


    @Test
    public void setUsernameTest() {
        User newUser = setUpUser();
        newUser.setUsername("Bobby");
        assertNotEquals("John", newUser.getUsername());
    }


    @Test
    public void getUserIdTest() {
        User newUser = setUpUser();
        newUser.setUserId(5);
        assertEquals(5, newUser.getUserId());
    }

    @Test
    public void setUserIdTest() {
        User newUser = setUpUser();
        newUser.setUserId(5);
        assertEquals(5, newUser.getUserId());
    }

    @Test
    public void getPositionTest() {
        User newUser = setUpUser();
        assertEquals("Junior", newUser.getPosition());
    }

    @Test
    public void setPositionTest() {
        User newUser = setUpUser();
        newUser.setPosition("senior");
        assertEquals("senior", newUser.getPosition());
    }

    @Test
    public void getRoleTest() {
        User newUser = setUpUser();
        assertEquals("supervisor", newUser.getRole());
    }

    @Test
    public void setRoleTest() {
        User newUser = setUpUser();
        newUser.setRole("Supervisor");
        assertEquals("Supervisor", newUser.getRole());
    }

    @Test
    public void getDepartmentIdTest() {
        User newUser = setUpUser();
        newUser.setDepartment_id(5);
        assertEquals(5, newUser.getDepartment_id());
    }

    @Test
    public void setDepartmentIdTest() {
        User newUser = setUpUser();
        newUser.setDepartment_id(7);
        assertEquals(7, newUser.getDepartment_id());
    }
}