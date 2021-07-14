package services;

import dao.UserDao;

import java.util.Map;

public class UserService {

    private UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public boolean checkUserPresence(Map<String, String> user) throws Exception {
        Map<String, String> u = dao.getUserByUsername(user.get("username"));
        return u != null;
    }

}
