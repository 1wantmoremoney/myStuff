package com.daytime.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: shiro 的realm
 * Author: Jiangchangpeng
 * Date: 2024/04/01/17:40
 */
public class Realm extends AuthorizingRealm {


    /**
     * 授权
     * 访问不同controller里接口进行授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 这个 username 是下面 doGetAuthenticationInfo 方法 return 的对象的第一个参数的值
        final String userName = (String) principals.getPrimaryPrincipal();
        System.out.println("执行授权：授权的用户名 " + userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> permissions = new HashSet<>();
        permissions.add("user:add");
        permissions.add("user:update");
        permissions.add("user:delete");
        simpleAuthorizationInfo.setStringPermissions(permissions);


        Set<String> roles = new HashSet<>();
        roles.add("admin");
        simpleAuthorizationInfo.setRoles(roles);


        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * 登录的时候进行验证
     *
     * @param token the authentication token containing the user's principal and credentials.
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证！！！！");
        final UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        /*
		//按数据库查询应该是以下代码，但为了方便起见，后面的写个假数据
		User user = userService.findUser(token.getUsername());
		if(user != null){
			// 当前 Realm 中的 doGetAuthorizationInfo 方法那个参数就是这个第一个参数，保存了当前用户信息
		    return new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    this.getName()
            );
		}
        */


        // 数据库查询用户名和密码（这里假作已经查询到了结果）
        String name = "zhangsan";
        String password = "123";
        if(name.equals(token1.getUsername())){
            return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
        }

        return null;
    }
}
