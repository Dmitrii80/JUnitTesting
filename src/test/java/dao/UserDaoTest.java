package dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    private UserDao dao;

    @Before
    public void setUp() throws Exception {
        this.dao = new UserDaoImpl();
    }

    @Test
    public void getUserByUsername_Should_Return_True() throws Exception {
        Map<String, String> remy = dao.getUserByUsername("remy@gmail.com");
        assertThat(remy).isNotNull();
        assertThat(remy.get("username")).isEqualTo("remy@gmail.com");
    }

    @Test
    public void getUserByUsername_Null_user() throws Exception {
        Map<String, String> alex = dao.getUserByUsername("alex@gmail.com");
        assertThat(alex).isNull();
    }

    @Test
    public void findAllUsers_Contain() throws Exception {
        List<Map<String, String>> allUsers = dao.findAllUsers();
        assertThat(allUsers).contains(new UserDaoImpl().users.get(0));

    }
}