package com.hf.springmvc.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hf.springmvc.beans.Permission;
import com.hf.springmvc.beans.Role;
import com.hf.springmvc.beans.User;
import com.hf.springmvc.beans.UserRole;
import com.hf.springmvc.dao.BaseDaoImpl;

@Service
public class AccountService {
	 /**** 
     * 通过用户名获取用户对象 
     *  
     * @param username 
     * @return 
     */  
    public User getUserByUserName(String username) {  
    	Map<String, String> map=new HashMap<String, String>();
    	map.put("username", username);
        return (User)dao.findByParams("User", map).get(0);  
    }  
  
    /*** 
     * 通过用户名获取权限资源 
     *  
     * @param username 
     * @return 
     */  
    public List<String> getPermissionsByUserName(String username) {  
        System.out.println("调用");  
        User user = getUserByUserName(username);  
        if (user == null) {  
            return null;  
        }  
        List<String> list = new ArrayList<String>();  
    	
        // System.out.println(user.getUserRoles().get(0).get);  
        for (UserRole userRole : user.getUserRoles()) {  
        	Map<String, String> map=new HashMap<String, String>();
            Role role = userRole.getRole(); 
            map.put("roleId",  role.getId()+"" );
            
            List<Object> permissions =dao.findByParams("Permission", map);
            for (Object p : permissions) {  
                list.add(((Permission)p).getUrl());  
            }  
        }  
        return list;  
    }  
  
    // 公共的数据库访问接口  
    // 这里省略BaseDao dao的编写  
    @Autowired  
    private BaseDaoImpl dao;  
}  
