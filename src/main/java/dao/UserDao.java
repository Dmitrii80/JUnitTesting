package dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
    Map<String, String> getUserByUsername(String username) throws Exception;

    List<Map<String, String>> findAllUsers();

}
