package dev.asisee.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
  String perform(HttpServletRequest request, HttpServletResponse response);
}
