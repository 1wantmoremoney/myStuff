package net.woaoo.jcp;


import com.daytime.Application;
import com.daytime.shiro.Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ShiroTest {
    public static Integer teamId = 0;
    private static Integer leagueSeasonId =0;


    @Test
    public void test01() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new Realm());

        SecurityUtils.setSecurityManager(defaultSecurityManager);

        final  Subject subject = SecurityUtils.getSubject();
        // 前端发送来的账号和密码生成的通行令牌，用来让 Realm 的 doGetAuthenticationInfo 方法里执行认证过程
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123");



        try {
            subject.login(token);

            boolean permitted = subject.isPermitted("user:add");
            System.out.println("permitted!!!!!!!!!!!!!!!!!"+ permitted);

            System.out.println("success");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("userNameErr");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("passwordErr");
        }



    }



}
