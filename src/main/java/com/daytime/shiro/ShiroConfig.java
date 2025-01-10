package com.daytime.shiro;


import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: shiro配置累
 * Author: Jiangchangpeng
 * Date: 2024/04/01/17:10
 */
public class ShiroConfig {



    @Bean(name = "userRealm")
    public Realm getRealm() {
        return new Realm();
    }


    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") Realm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置一个安全管理器来关联 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 默认登陆界面
        shiroFilterFactoryBean.setLoginUrl("/loginPage");

        // 设置权限（非注解方式设置对应 url 的权限）
        // 注意要用 LinkedHashMap 遍历列表时时候按顺序进行匹配判断 URL
        // 所以下面的 /** 要放在最后，否则如果放在第一个则所有的 URL 都
        // 可以被匹配到，那么之后的就失效了
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/loginPage", "anon");
        filterMap.put("/user/login", "anon");

        filterMap.put("/add", "perms[user:add, admin]");
        filterMap.put("/update", "perms[user:update]");

        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     *  开启Shiro的注解 (如@RequiresRoles,@RequiresPermissions)
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }











}
