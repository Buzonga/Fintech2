package com;

import DAOs.UserDao;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CreateUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("nome"));
        user.setPsw(request.getParameter("senha"));
        user.setPicture("");
        UserDao userDao = new UserDao();
        try {
            userDao.createUser(user.getUsername(), user.getEmail(), request.getParameter("senha"), user.getPicture());
        } catch (SQLException sqlException) {
            System.out.println("sqlException");
        }


    }
}
