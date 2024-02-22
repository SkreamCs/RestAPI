package abdul.restApi.rest;

import abdul.restApi.model.File;
import abdul.restApi.model.Message;
import abdul.restApi.repository.repositoryImpl.EventRepositoryImpl;
import abdul.restApi.repository.repositoryImpl.FileRepositoryImpl;
import abdul.restApi.repository.repositoryImpl.UserRepositoryImpl;
import abdul.restApi.service.EventService;
import abdul.restApi.service.FileService;
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

public class RestFileControllerV1 extends HttpServlet {

    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final FileService fileService = new FileService(new UserService(new UserRepositoryImpl()), new EventService(new EventRepositoryImpl()), new FileRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().println(fileService.getAllFile().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        File file = fileService.uploadFile(req, Integer.parseInt(req.getParameter("userId")));
        printWriter.println(GSON.toJson(file));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        File fileUpdate = GSON.fromJson(req.getReader(), File.class);
        if (fileUpdate.getFilePath() == null)
            fileUpdate.setFilePath(fileService.getByIdFile(fileUpdate.getId()).getFilePath());
        fileService.updateFile(fileUpdate);
        Message message = new Message(new Date(), "Update");
        resp.getWriter().println(GSON.toJson(message));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        fileService.deleteFile(Integer.parseInt(req.getParameter("id")));
        Message message = new Message(new Date(), "Delete");
        resp.getWriter().println(GSON.toJson(message));
    }
}


