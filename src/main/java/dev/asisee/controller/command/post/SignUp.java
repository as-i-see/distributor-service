package dev.asisee.controller.command.post;

import dev.asisee.controller.command.Command;
import org.demo.data.record.UserRecord;
import org.demo.persistence.UserPersistence;
import org.demo.persistence.impl.jdbc.UserPersistenceJdbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class SignUp implements Command {
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        UserPersistence db = new UserPersistenceJdbc();
        if (Objects.isNull(db.findByEmail(request.getParameter("email")))) {
            UserRecord newUser = new UserRecord();
            newUser.setName(request.getParameter("name"));
            newUser.setEmail(request.getParameter("email"));
            newUser.setPassword(request.getParameter("pwd"));
            newUser.setRole("user");
            db.save(newUser);
            request.getSession().setAttribute("role", "user");
            return request.getContextPath() + "/index.jsp";
        } else {
            return request.getContextPath() + "/signup.html";
        }
    }
}
