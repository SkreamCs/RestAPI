package abdul.restApi.rest;

import abdul.restApi.model.Message;
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
import java.util.Date;

public class RestUserControllerV1 extends HttpServlet {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final UserService userService = new UserService(new UserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().println(userService.getAllUser());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        User user = GSON.fromJson(req.getReader(), User.class);
        user = userService.saveUser(user);
        printWriter.println(user);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        User userUpdate = GSON.fromJson(req.getReader(), User.class);
        userService.updateUser(userUpdate);
        Message message = new Message(new Date(), "Update..");
        resp.getWriter().println(GSON.toJson(message));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        userService.deleteUser(Integer.parseInt(req.getParameter("id")));
        Message message = new Message(new Date(), "Delete");
        resp.getWriter().println(GSON.toJson(message));
    }
}
