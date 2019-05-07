package dev.asisee.controller.command.get;

import dev.asisee.controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class GetCommandFactory {
  public static Command getCommand(String uri) {
    switch (uri) {
      default:
        return new GetIndex();
    }
  }
}
