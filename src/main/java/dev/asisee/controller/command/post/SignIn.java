package dev.asisee.controller.command.post;

import dev.asisee.controller.command.Command;
import org.demo.data.record.UserRecord;
import org.demo.persistence.UserPersistence;
import org.demo.persistence.impl.jdbc.UserPersistenceJdbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignIn implements Command {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        UserRecord user = new UserRecord();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("pwd"));
        UserPersistence db = new UserPersistenceJdbc();
//        ?if (db.exists(user)) {
            request.getSession().setAttribute("role", "user");
//        }
        return request.getContextPath() + "/index.jsp";
    }

}
