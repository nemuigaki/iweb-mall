package com.iweb.mall.portal.util;

import com.iweb.mall.model.User;

import java.util.Date;
import java.util.HashMap;

/**
 * UserUtil工具类，用来简化初始化user的操作
 */
public class UserUtil {

    public static User getUser(User originUser,String username,String password,String telephone){
        HashMap<String,Object> userInfo = new HashMap<>();
        password = MD5Util.getMD5(password);
        userInfo.put("username",username);
        userInfo.put("password",password);
        userInfo.put("telephone",telephone);
        //遍历每个key
        for (String key:userInfo.keySet()){
            handleKey(originUser,key,userInfo);
        }
        return originUser;
    }

    //处理每个key值
    public static void handleKey(User user,String key,HashMap<String,Object> userInfo){
        //初始化
        if (key == "username" && userInfo.get("username") != null)user.setUsername((String) userInfo.get("username"));
        if (key == "password" && userInfo.get("password") != null)user.setPassword((String) userInfo.get("password"));
        if (key == "telephone"&& userInfo.get("telephone") != null)user.setPhone((String) userInfo.get("telephone"));
        //如果更新时间不为空，则修改更新时间
        if (user.getUpdatetime() != null )user.setCreatetime(new Date());
    }
}
