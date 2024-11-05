package com;

import DAOs.UserDao;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserService;
import services.interfaces.IUserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IUserService _userService;

    public CreateUserServlet() {
        _userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPsw(request.getParameter("password"));
        user.setPicture("");

        _userService.createUser(user);
    }
}
