package com.service;

/**
 * Created by zheng1617 on 16-7-20.
 */
import com.domain.User;
import com.exception.UserExistException;
public interface IUserService {
    void registerUser(User user) throws UserExistException;
    User loginUser(String userName, String userPwd);
}
