package dev.asisee.controller.command.post;

import dev.asisee.controller.command.Command;

public class PostCommandFactory {
    public static Command getCommand(String URL) {
        switch (URL) {
            case "signup":
                return new SignUp();
            case "signin":
                return new SignIn();
            default:
                return null;
        }
    }
}
