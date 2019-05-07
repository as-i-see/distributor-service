package dev.asisee.controller;

import dev.asisee.controller.command.Command;
import dev.asisee.controller.command.get.GetCommandFactory;
import dev.asisee.controller.command.post.PostCommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "/signin", "/signup"})
public class ServletController extends HttpServlet {

  private static final Logger logger = LogManager.getLogger(ServletController.class);

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String requestedURL = request.getRequestURI().replaceAll(request.getContextPath() + "/", "");
    Command command = PostCommandFactory.getCommand(requestedURL);
    String redirectURL = command.perform(request, response);
    response.sendRedirect(redirectURL);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
//     final AsyncContext async = request.startAsync();
//     async.start(
//     WebLoggerContextUtils.wrapExecutionContext(
//     this.getServletContext(),
//     () -> {
//     final Logger logger = LogManager.getLogger(ServletController.class);
//     logger.info("Servlet path: " + request.getServletPath());
//     }));
    String requestedURL = request.getRequestURI().replaceAll(request.getContextPath() + "/", "");
    Command command = GetCommandFactory.getCommand(requestedURL);
    String forwardURL = command.perform(request, response);
    response.sendRedirect(forwardURL);
//    ServletContext servletContext = getServletContext();
//    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(forwardURL);
//    requestDispatcher.forward(request, response);
  }
}
