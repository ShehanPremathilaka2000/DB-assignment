package db.Assignement.service;

import db.Assignement.model.User;
import db.Assignement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(String name, String pin, int balance){
        if (userRepository.findByName(name) != null) {
            return null;
        }
        User user = new User(name, pin, balance);
        return userRepository.save(user);
    }

    @Override
    public boolean Login(String name, String pin){
        User user = userRepository.findByNameAndPin(name, pin);
        if(user == null){
            System.out.println("user not found");
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUser(String name){
        User user = userRepository.findByName(name);
        if(user == null){
            System.out.println("user not found");
            return false;
        }
        return true;
    }

    @Override
    public int getBalance(String username){
        User user = userRepository.findByName(username);
        return user.getBalance();
    }

    @Override
    public boolean updateUserBalance(String name, int amount){
        User user = userRepository.findByName(name);
//        if (user == null || user.getBalance() < amount) {
//            return false;
//        }
        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateReceiverBalance(String name, int amount){
        User user = userRepository.findByName(name);
//        if (user == null) {
//            return false;
//        }
        user.setBalance(user.getBalance() + amount);
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional
    public boolean transaction(String name, String receiverName, int amount){
        boolean uRes = updateUserBalance(name, amount);
        boolean rRes = updateReceiverBalance(receiverName, amount);
        return true;
    }
}
