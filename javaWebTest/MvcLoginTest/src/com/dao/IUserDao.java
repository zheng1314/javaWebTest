package com.dao;

/**
 * Created by zheng1617 on 16-7-19.
 */
import com.domain.User;
public interface IUserDao {
    User find(String username, String userPwd);
    User find(String name);
    void add(User user);
}
