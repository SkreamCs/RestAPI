package abdul.restApi.rest;

import abdul.restApi.model.Event;
import abdul.restApi.model.Message;
import abdul.restApi.repository.repositoryImpl.EventRepositoryImpl;
import abdul.restApi.service.EventService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RestEventControllerV1 extends HttpServlet {
    private final EventService eventService = new EventService(new EventRepositoryImpl());
    private final Gson GSON = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().println(eventService.getAllEvent().toString());
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Event event = GSON.fromJson(request.getReader(), Event.class);
        eventService.updateEvent(event);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Message message = new Message(new Date(), "Update..");
        out.print(GSON.toJson(message));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        eventService.deleteEvent(Integer.parseInt(request.getParameter("id")));
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Message message = new Message(new Date(), "Delete");
        out.print(GSON.toJson(message));
    }
}
