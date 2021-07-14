package services;

import dao.UserDao;
import dao.UserDaoImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    @Mock
    private UserDao dao;

    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
        this.userService = new UserService(dao);
    }

    @Test
    public void checkUserPresence() throws Exception {
        // определяем поведение getUserByUsername() для checkUserPresence()
        given(dao.getUserByUsername("anyString()")).willReturn(
                new UserDaoImpl().getUserByUsername("olga@gmail.com"));

        boolean userExists = userService.checkUserPresence(
                dao.getUserByUsername("olga@gmail.com")
        );

        // проверяем действие checkUserPresence()
        assertThat(userExists).isTrue();

        // verify // проверяем выполнение действия
        verify(dao).getUserByUsername("olga@gmail.com");


    }

//    @Test
//    public void checkUserPresence_Should_Return_False() throws Exception {
//
//        given(dao.getUserByUsername("olga@gmail.com")).willReturn(
//                null);
//
//        boolean userExists = userService.checkUserPresence(
//                dao.getUserByUsername("olga@gmail.com"));
//
//        assertThat(userExists).isFalse();
//
//    }

    @Test(expected = Exception.class)
    public void checkUserPresence_Should_Throw_Exception() throws Exception {

        given(dao.getUserByUsername(anyString())).willThrow(Exception.class);

        userService.checkUserPresence(
                dao.getUserByUsername("polina@gmail.com"));

    }

    @Test
    public void testCaptor() throws Exception {
        given(dao.getUserByUsername("olga@gmail.ru")).willReturn(
                new UserDaoImpl().getUserByUsername("olga@gmail.com")
        );

        boolean b = userService.checkUserPresence(dao.getUserByUsername("olga@gmail.com"));

//        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//
//        verify(dao).getUserByUsername(captor.capture());
//        String argument = captor.getValue();
//
//        assertThat(argument).isEqualTo("olga@gmail.com");
//        System.out.println(argument);
//        System.out.println(captor.getValue());
    }

}