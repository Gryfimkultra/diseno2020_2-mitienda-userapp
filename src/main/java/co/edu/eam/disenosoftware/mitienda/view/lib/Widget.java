package co.edu.eam.disenosoftware.mitienda.view.lib;

import javax.swing.*;

/**
 * Generic widget
 */
public abstract class Widget<D> extends JPanel {

  /**
   * ehlp data to render the widget
   */
  protected D data;

  /**
   * parente page.
   */
  protected Page parentPage;

  public Widget(D data) {
    this.data = data;
    build();
  }

  /**
   * constructor
   * @param data
   * @param parentPage
   */
  public Widget(D data, Page parentPage) {
    this.data = data;
    this.parentPage = parentPage;
    build();
  }

  /**
   * abstract where implement the render of the data
   */
  public abstract void build();

}
