package com.ranq.spring4.ch4.chiro.multirealm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author dsir
 * @create 2017-07-21 9:52
 **/
public class MyRealm3 implements Realm {
    private Logger logger = Logger.getLogger(getClass());

    public String getName() {
        return "MyRealm3";
    }

    public boolean supports(AuthenticationToken token) {
        logger.info("MyRealm3.supports");
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("MyRealm3.getAuthenticationInfo");
        String username = (String) token.getPrincipal(); //得到用户名
        String password = new String((char[]) token.getCredentials()); //得到密码
        if (!"zhang".equals(username)) {//如果用户名错误
            throw new UnknownAccountException("不存在用户名");
        }
        if (!"123".equals(password)) { //如果密码错误
            throw new IncorrectCredentialsException("用户名/密码不正确");
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo("zhang@163.com", password, getName());
    }
}
