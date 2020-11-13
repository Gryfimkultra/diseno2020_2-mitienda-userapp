package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoresOpenController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoresOpenWidget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * stores open page
 */
public class StoresOpenPage extends Page {


  /**
   * page stores open controller
   */
  private StoresOpenController controller;

  /**
   * controller stores open
   */
  public StoresOpenPage() {
    controller = new StoresOpenController();
  }

  @Override
  public void init() throws Exception {
    controller = new StoresOpenController();

    List<Store> stores = controller.getOpenStores();
  }

  @Override
  public JComponent buildContent() throws Exception {

    List<Store> stores = controller.getOpenStores();

    for (Store store : stores) {
      System.out.println(store.getName());
    }

    List<StoresOpenWidget> storesWidgets = new ArrayList<>();

    JPanel panlerStores = new JPanel();
    System.out.println(stores.size());

    double cantidad = stores.size()/2;
    System.out.println("cantidad normal "+cantidad);
    System.out.println("cantidad con math.ceil : "+Math.ceil(cantidad));
    panlerStores.setLayout(new GridLayout(5, 2 ));

    for (Store store : stores) {
      StoresOpenWidget wdgt = new StoresOpenWidget(store);
      panlerStores.add(wdgt);
    }

    panlerStores.setBackground(Color.white);

    return new JScrollPane(panlerStores);
  }

  @Override
  public JComponent buildHeader() throws Exception {

    JPanel panelHeader = new JPanel();
    panelHeader.setLayout(new GridLayout(1,1));
    panelHeader.setBackground(Constants.COLOR_GREEN);

    JLabel label = new JLabel("Tus tiendas cercanas");
    label.setFont(Constants.TITLE_FONT);
    label.setPreferredSize(new Dimension(panelHeader.getPreferredSize().width,120));
    label.setAlignmentX(0.5f);

    panelHeader.add(label);
    return panelHeader;
  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }
}
