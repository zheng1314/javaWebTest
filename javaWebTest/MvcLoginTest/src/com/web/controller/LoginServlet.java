package com.web.controller;

import com.domain.User;
import com.service.IUserService;
import com.service.implement.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zheng1617 on 16-8-18.
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        IUserService service = new IUserServiceImpl();

        User user = service.loginUser(username, password);
        if(user == null) {
            String message = String.format(
                    "对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！" +
                            "<meta http-equiv='refresh' content='2;url=%s'",
                    request.getContextPath()+"/servlet/LoginUIServlet"
            );
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //if login success, save the user's info in session
        request.getSession().setAttribute("user", user);
        String message = String.format(
                "恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
                user.getUserName(),
                request.getContextPath()+"/index.jsp"
        );
        request.setAttribute("message", message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
