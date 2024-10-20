package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();
    public void addUser(User user);
    public User getUser(int id);
    public void updateUser(User user);
    public void deleteUser(int id);
}