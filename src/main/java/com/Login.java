package com;

import DTOs.CreateUserDTO;
import DTOs.LoginDTO;
import DTOs.UserDTO;
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

@WebServlet("/login")
public class Login  extends HttpServlet  {
    private static final long serialVersionUID = 1L;

    private IUserService _userService;

    public Login() {
        _userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDTO user = new LoginDTO();
        user.email = request.getParameter("email");
        user.password = request.getParameter("password");

        try {
            Result<UserDTO> result = _userService.loginUser(user);

            if (result.getIsSuccess()) {
                request.setAttribute("username", result.getData().username);
                request.setAttribute("email", result.getData().email);
                request.setAttribute("balance", result.getData().balance);
                request.getRequestDispatcher("/fintech-home.jsp").forward(request, response);
            } else {
                request.setAttribute("message", result.getMessage());
            }
        } catch (SQLException ex) {
            request.setAttribute("message", "Não foi possivel criar usuário");
            request.getRequestDispatcher("/CreateUserServlet").forward(request, response);
        }
    }
}