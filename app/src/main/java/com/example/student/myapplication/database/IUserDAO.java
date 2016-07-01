package com.example.student.myapplication.database;

import java.util.List;

/**
 * Created by rome03 on 21/06/2016.
 */
public interface IUserDAO {
    public long addUser(User user);
    public User getUser(int id);
    public List<User> getUsers();
    public void deleteUser(int id);
    public int updateUser(User user);

}
