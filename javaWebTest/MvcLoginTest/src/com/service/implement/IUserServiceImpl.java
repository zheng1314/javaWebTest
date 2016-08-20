package com.service.implement;

import com.dao.IUserDao;
import com.dao.implement.IUserDaoImpl;
import com.domain.User;
import com.exception.UserExistException;
import com.service.IUserService;

/**
 * Created by zheng1617 on 16-7-20.
 */
public class IUserServiceImpl implements IUserService{
    private IUserDao userDao = new IUserDaoImpl();
    @Override
    public void registerUser(User user) throws UserExistException{
        if(userDao.find(user.getUserName()) != null)
        {
            throw new UserExistException("注册的用户名已存在！！！");
        }
        userDao.add(user);
    }
    @Override
    public User loginUser(String userName, String userPwd) {
        return userDao.find(userName, userPwd);
    }
}
