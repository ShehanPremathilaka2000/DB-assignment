package db.Assignement.service;

import db.Assignement.model.User;

public interface UserService {
    public User addUser(String name, String pin, int balance);
    public boolean Login(String name, String pin);
    public boolean checkUser(String name);
    public int getBalance(String name);
    public boolean transaction(String name, String receiverName, int amount);
    public boolean updateUserBalance(String name, int amount);
    public boolean updateReceiverBalance(String name, int amount);
}
