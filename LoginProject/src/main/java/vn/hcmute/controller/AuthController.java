package vn.hcmute.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"", "/home", "/login", "/error"})
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (path.equals("/error")) {
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
        } else if (path.equals("/home")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") != null) {
                req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String remember = req.getParameter("remember");

        if ("admin".equals(user) && "123".equals(pass)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", user);
            session.setMaxInactiveInterval(30 * 60);

            if ("true".equals(remember)) {
                Cookie cookie = new Cookie("username", user);
                cookie.setMaxAge(30);
                resp.addCookie(cookie);
            }

            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}