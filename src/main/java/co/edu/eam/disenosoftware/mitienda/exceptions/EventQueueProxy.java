package co.edu.eam.disenosoftware.mitienda.exceptions;

import java.awt.*;

/**
 * Class to show exceptions...
 */
class EventQueueProxy extends EventQueue {

  /**
   * Exception manager
   *
   * @param newEvent
   */
  protected void dispatchEvent(AWTEvent newEvent) {
    try {
      super.dispatchEvent(newEvent);
    } catch (Throwable t) {
      new ExceptionHandler().uncaughtException(Thread.currentThread(), t);
    }
  }
}