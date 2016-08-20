package com.domain;

/**
 * Created by zheng1617 on 16-7-19.
 */
import java.io.Serializable;
import java.util.Date;
public class User implements Serializable{
    private static final long serialVersionUID = -4313782718477229465L;
    private String id;
    private String userName;
    private String userPwd;
    private String email;
    private Date birthday;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getBirthday() {
        return birthday;
    }
}
