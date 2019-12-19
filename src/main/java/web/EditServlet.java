package web;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    UserService userService = UserService.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        User user;
        user = userService.findUserById(id);
        req.setAttribute("id", user.getId());
        req.setAttribute("name", user.getName());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("country", user.getCountry());
        req.setAttribute("mobile", user.getMobile());
        req.getRequestDispatcher("user_update.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        String mobile = req.getParameter("mobile");

        if (userService.editUser(new User(id, name, email, country, mobile))) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/");
        }
    }
}
