import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017-04-18.
 */
public class EvnTest {

    private UserService userService=new UserService();

     @Test
    public void testFindALlUser(){
         List<User> users=userService.FindAllUser();
         Assert.assertTrue(users.size()==15);
    }
}
