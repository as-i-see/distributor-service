package dev.asisee.controller.command.get;

import dev.asisee.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetIndex implements Command {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        return request.getContextPath() + "/index.jsp";
    }
}
