package com.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import com.domain.User;
import com.exception.UserExistException;
import com.service.IUserService;
import com.service.implement.IUserServiceImpl;
import com.util.WebUtils;
import com.web.formBean.registerFormBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * Created by zheng1617 on 16-7-21.
 */
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        registerFormBean formBean = WebUtils.request2Bean(request, registerFormBean.class);
        if(formBean.validate() == false) {
            request.setAttribute("formBean", formBean);

            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            return;
        }
        User user = new User();
        try {
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            BeanUtils.copyProperties(user, formBean);
            user.setId(WebUtils.makeId());
            IUserService service = new IUserServiceImpl();

            service.registerUser(user);

            String message = String.format(
                    "Successful Register!!!<meta http-equiv='refresh' content='3;url=%s'/>",
                    request.getContextPath()+"/servlet/LoginUIServlet");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }catch(UserExistException e) {
            formBean.getErrors().put("userName", "The User is exist!!!");
            request.setAttribute("formBean", formBean);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }catch(Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Sorry, failed to Register");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
