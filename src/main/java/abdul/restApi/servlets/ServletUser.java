package abdul.restApi.servlets;

import abdul.restApi.controller.UserController;
import abdul.restApi.model.User;
import abdul.restApi.repository.repositoryImpl.UserRepositoryImpl;
import abdul.restApi.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletUser extends HttpServlet {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final UserService userService = new UserService(new UserRepositoryImpl());
    private final UserController userController = new UserController(userService);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(userController.getAllUser().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");
        User user = GSON.fromJson(req.getReader(), User.class);
        int id = userController.createUser(user).getId();
        printWriter.println("Object created successfully id: \n" + id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User userUpdate = GSON.fromJson(req.getReader(), User.class);
        userController.updateUser(userUpdate);
        resp.getWriter().println("The object was successfully updated");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        userController.deleteUser(Integer.parseInt(req.getParameter("id")));
        resp.getWriter().println( "Object deleted ");
    }
}
