package co.edu.eam.disenosoftware.mitienda.gui.pages;

import co.edu.eam.disenosoftware.mitienda.gui.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.gui.lib.Page;
import co.edu.eam.disenosoftware.mitienda.gui.widgets.PanelProduct;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoresRepository;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Profile extends Page {


  public JComponent fill() {
    int t=20;
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    for(int i =0;i<t;i++) {
      List<JComponent> panels  = new ArrayList<>();
      for(int j=0; j<(int)(Math.random()*5 + 5);j++) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(new JLabel("Producto " + j));
        p.add(new JTextField());
        p.add(new JButton("Agregar"));
        panels.add(p);
      }

      ListView<JComponent> lv = new ListView(panels, ListView.ListViewOrientation.HORIZONTAL);
      lv.setHeight(100);
      panel.add(new JLabel("categoria" + i));

      panel.add(lv);
    }

    return new JScrollPane(panel);
  }


  public JComponent test() {
    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

    List<JPanel> labels = new ArrayList<>();
    for(int i =0;i<50;i++) {
      JLabel l = new JLabel("categoria" + i);
      JTextField tf = new JTextField("");
      //tf.setPreferredSize(new Dimension(tf.getPreferredSize().width, 20));

      JButton b = new JButton("boton");

      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
      p.add(l);
      p.add(tf);
      p.add(b);
      //p.setPreferredSize(new Dimension(p.getPreferredSize().width, 200));

      labels.add(p);
    }

    ListView<JComponent> l1 = new ListView(labels, ListView.ListViewOrientation.HORIZONTAL);
    l1.setHeight(150);
    container.add(l1);

    List<JPanel> panels = new ArrayList<>();
    for(int i =0;i<30;i++) {
      JPanel p = new JPanel();
      p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
      p.add(new JLabel("ingrese valor " + i));
      p.add(new JTextField());

      panels.add(p);

    }

    ListView<JPanel> l2 = new ListView(panels);
    container.add(l2);

    return container;
  }

  @Override
  public JComponent buildContent() {
    JTabbedPane tab = new JTabbedPane();



    ListView<JComponent> b = new ListView<>(
            Arrays.asList(
                    new JTextField("a"),
                    new JLabel("b"),
                    new JButton("c"),
                    new JTextField("a"),
                    new JLabel("b"),
                    new JTextField("1" + 1),
                    new JLabel("2" + 2),
                    new JButton("3" + 3)
            )
    );

    try {
      tab.add("Products", testProducts());
    } catch (IOException e) {
      e.printStackTrace();
    }
    tab.add("FInished", fill());
    tab.add("Delivered", test());

    return tab;
  }


  public JComponent testProducts() throws IOException {
    ProductStoresRepository repo = new ProductStoresRepository();
    List<ProductStore> pss = repo.getProductsByStoreId(6L);

    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

    for(int i = 1 ; i<=7; i++) {
      int n = 1;
      ListView<PanelProduct> lv = new ListView<PanelProduct>(ListView.ListViewOrientation.HORIZONTAL);

      for (ProductStore ps : pss) {
        PanelProduct pp = new PanelProduct(ps);
        if(n%i == 0)
        lv.add(pp);
        n++;
      }
      lv.refresh();
      container.add(lv);
      lv.setHeight(200);
    }
    return new JScrollPane(container);
  }

  @Override
  public JComponent buildHeader() {
    return new JLabel("Profile");
  }

  @Override
  public JComponent buildFooter() {
    return null;
  }
}
