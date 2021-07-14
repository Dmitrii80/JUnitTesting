package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    public List<Map<String, String>> users;

    public UserDaoImpl() {
        this.users = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String, String>() {{
                put("username", "olesya@gmail.com");
                put("role", "GUEST");
            }});
            add(new HashMap<String, String>() {{
                put("username", "kirill@gmail.com");
                put("role", "USER");
            }});
            add(new HashMap<String, String>() {{
                put("username", "remy@gmail.com");
                put("role", "ADMIN");
            }});
        }};
    }

    @Override
    public Map<String, String> getUserByUsername(String username) throws Exception {
        return users.stream()
                .filter(u -> u.get("username").equals(username))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Map<String, String>> findAllUsers() {
        return users;
    }

}
