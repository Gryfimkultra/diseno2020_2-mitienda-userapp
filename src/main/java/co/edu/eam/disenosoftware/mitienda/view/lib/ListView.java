package co.edu.eam.disenosoftware.mitienda.view.lib;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Listvwiew component
 *
 * @param <T>
 */
public class ListView<T extends JComponent> extends JScrollPane {

  /**
   * Enum values for orientation
   */
  public enum ListViewOrientation {
    HORIZONTAL,
    VERTICAL
  }

  /**
   * Components to render
   */
  private List<T> components;

  /**
   * Orientation to render
   */
  private ListViewOrientation orientation = ListViewOrientation.VERTICAL;

  /**
   * Constrtuctor
   *
   * @param components componente to render
   */
  public ListView(List<T> components) {
    this.components = components;
    build();
  }

  /**
   * componts to render in one direction
   *
   * @param components  components to render
   * @param orientation direction to render
   */
  public ListView(List<T> components, ListViewOrientation orientation) {
    this.components = components;
    this.orientation = orientation;
    build();
  }

  /**
   * COnstructor
   *
   * @param orientation desire direction to render
   */
  public ListView(ListViewOrientation orientation) {
    this.orientation = orientation;
    components = new ArrayList<>();
  }

  /**
   * Build component container
   *
   * @return container
   */
  private JPanel buildParent() {
    JPanel panel = new JPanel();
    //panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    if (orientation == ListViewOrientation.VERTICAL) {
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    } else {
      panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
      //panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 1000, 20));
    }

    return panel;
  }

  /**
   * Fill container whith components
   *
   * @param parent
   */
  private void fill(JPanel parent) {
    for (JComponent comp : components) {
      parent.add(comp);
    }
  }

  /**
   * Render all
   */
  private void build() {
    JPanel parent = buildParent();

    fill(parent);

    if (orientation == ListViewOrientation.VERTICAL) {
      setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
      setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
    } else {
      setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
      setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
      setPreferredSize(new Dimension(getPreferredSize().width, getPreferredSize().height + 30));
    }

    setBorder(BorderFactory.createEmptyBorder());
    setViewportView(parent);
  }

  /**
   * Set components to render
   *
   * @param components
   */
  public void setComponents(List<T> components) {
    this.components = components;
    build();
  }

  /**
   * set height of this component
   *
   * @param height
   */
  public void setHeight(int height) {
    setPreferredSize(new Dimension(getPreferredSize().width, height));
  }

  /**
   * Add component to render
   *
   * @param component
   */
  public void add(T component) {
    components.add(component);
  }

  /**
   * refresh gui
   */
  public void refresh() {
    build();
  }
}
