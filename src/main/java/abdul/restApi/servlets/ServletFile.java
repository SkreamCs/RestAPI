package abdul.restApi.servlets;

import abdul.restApi.controller.FileController;
import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.repository.repositoryImpl.EventRepositoryImpl;
import abdul.restApi.repository.repositoryImpl.FileRepositoryImpl;
import abdul.restApi.repository.repositoryImpl.UserRepositoryImpl;
import abdul.restApi.service.EventService;
import abdul.restApi.service.FileService;
import abdul.restApi.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletFile extends HttpServlet {
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final FileService fileService = new FileService( new UserService(new UserRepositoryImpl()), new EventService(new EventRepositoryImpl()), new FileRepositoryImpl());
    private final FileController fileController = new FileController(fileService);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(fileController.getAllFile().toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("text/html");
        int id = fileController.uploadFile(GSON.fromJson(req.getReader(), File.class), Integer.parseInt(req.getParameter("userId"))).getId();
        printWriter.println("Object created successfully id: " + id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        File fileUpdate = GSON.fromJson(req.getReader(), File.class);
        if (fileUpdate.getFilePath() == null) fileUpdate.setFilePath(fileService.getByIdFile(fileUpdate.getId()).getFilePath());
        fileController.updateFile(fileUpdate);
        resp.getWriter().println("Update");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        fileController.deleteFile(Integer.parseInt(req.getParameter("id")));
        resp.getWriter().println("Object deleted");
    }
}

