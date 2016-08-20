package com.web.formBean;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zheng1617 on 16-7-21.
 */
public class registerFormBean {
    private String userName;
    private String userPwd;
    private String confirmPwd;
    private String email;
    private String birthday;

    private Map<String, String> errors = new HashMap<String, String>();
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    public boolean validate() {
        boolean isOk = true;
        if(this.userName == null || this.userName.trim().equals("")) {
            isOk = false;
            errors.put("userName", "User Name should not be valid");
        }else {
            if (!this.userName.matches("[a-zA-Z]{3,8}")){
                isOk = false;
                errors.put("userName", "User Name must be the letter of 3-8 bit");
            }
        }
        if(this.userPwd == null || this.userPwd.trim().equals("")) {
            isOk = false;
            errors.put("userPwd", "Pass word not be valid");
        }else {
            if(!this.userPwd.matches("\\d{3,8}")){
                isOk = false;
                errors.put("userPwd", "Pass word must be the number of 3-8 bits");
            }
        }
        if(this.confirmPwd != null) {
            if(!this.confirmPwd.equals(this.userPwd)) {
                isOk = false;
                errors.put("confirmPwd", "Two pass word is not same");
            }
        }
        if(this.email != null && !this.email.trim().equals("")) {
            if(!this.email.matches("\\w+@\\w+(\\.\\w+)")) {
                isOk = false;
                errors.put("email", "This is not a legal email");
            }
        }
        if(this.birthday != null && !this.birthday.trim().equals("")) {
            try{
                DateLocaleConverter conver = new DateLocaleConverter();
                conver.convert(this.birthday);
            }catch (Exception e) {
                isOk = false;
                errors.put("birthday", "Birthday must be a date");
            }
        }
        return isOk;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }
    public String getConfirmPwd() {
        return confirmPwd;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthday() {
        return birthday;
    }
}
