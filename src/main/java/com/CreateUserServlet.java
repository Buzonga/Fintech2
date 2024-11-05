package com;

import DAOs.UserDao;
import DTOs.CreateUserDTO;
import DTOs.UserDTO;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserService;
import services.interfaces.IUserService;
import utils.Result;

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
        CreateUserDTO user = new CreateUserDTO();
        user.email = request.getParameter("email");
        user.username = request.getParameter("username");
        user.password = request.getParameter("password");
        user.confirmPassword = request.getParameter("cPassword");

        try {
           Result<UserDTO> result = _userService.createUser(user);

           if (result.getIsSuccess()) {
               request.setAttribute("user", result.getData());
               response.sendRedirect(request.getContextPath() + "/FintechHome");
           } else {
               request.setAttribute("message", result.getMessage());
           }

        } catch (SQLException ex) {
            request.setAttribute("message", "Não foi possivel criar usuário");
            request.getRequestDispatcher("/CreateUserServlet").forward(request, response);
        }
    }
}
