package web;

import service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    UserService userService = UserService.getInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        userService.deleteUser(userService.findUserById(id));
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/");
    }
}