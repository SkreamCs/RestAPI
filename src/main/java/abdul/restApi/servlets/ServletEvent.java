package abdul.restApi.servlets;

import abdul.restApi.controller.EventController;
import abdul.restApi.model.Event;
import abdul.restApi.repository.repositoryImpl.EventRepositoryImpl;
import abdul.restApi.service.EventService;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletEvent extends HttpServlet {
    private final EventController eventController = new EventController(new EventService(new EventRepositoryImpl()));
    private final Gson GSON = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println(eventController.getAllEvent().toString());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Event event = GSON.fromJson(request.getReader(), Event.class);
        eventController.updateEvent(event);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("Update event ...");
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        eventController.deleteEvent(Integer.parseInt(request.getParameter("id")));
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("Delete event ...");
        out.flush();
    }
}
