package jdbc.Service;
import jdbc.dao.DaoException;
import jdbc.dao.UserDao;

/**
 * Created by Allen Yang
 * 2018/4/30 21:58
 */
public class UserService {
    private UserDao userDao;
    public void regist(jdbc.domain.User user){
        try{
            this.userDao.addUser(user);
        }catch (DaoException e){
            //todosomething
        }
        //sendMail.send(user);
    }
}
