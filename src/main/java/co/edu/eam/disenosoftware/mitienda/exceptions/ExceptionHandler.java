package co.edu.eam.disenosoftware.mitienda.exceptions;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * class to config exception handling.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {


  @Override
  public void uncaughtException(Thread thread, Throwable t) {
    String message = t.getMessage();

    if (message == null || message.length() == 0) {
      message = "Fatal: " + t.getClass();
    }

    if (t instanceof APIException) {
      APIException exc = (APIException) t;

      Locale locale = Locale.getDefault();
      ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);

      String errorMessage = resourceBundle.getString("error." + exc.getMessage());
      JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, message, "General Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
