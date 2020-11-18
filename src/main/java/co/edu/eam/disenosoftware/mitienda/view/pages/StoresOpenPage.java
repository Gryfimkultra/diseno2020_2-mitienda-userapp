package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoresOpenController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoresOpenWidget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
  public void init() {
    controller = new StoresOpenController();

    List<Store> stores = controller.getOpenStores();
  }

  @Override
  public JComponent buildContent() {

    List<Store> stores = controller.getOpenStores();

    List<StoresOpenWidget> storesWidgets = new ArrayList<>();

    JPanel panlerStores = new JPanel();

    panlerStores.setLayout(new GridLayout(stores.size(), 1));

    for (Store store : stores) {
      StoresOpenWidget wdgt = new StoresOpenWidget(store);
      panlerStores.add(wdgt);
    }

    panlerStores.setBackground(Color.white);

    return new JScrollPane(panlerStores);
  }

  @Override
  public JComponent buildHeader() {

    JPanel panelHeader = new JPanel();
    panelHeader.setLayout(new GridLayout(1, 1));
    panelHeader.setBackground(Constants.COLOR_GREEN);

    //Internacionalizacion I18N
    //es_US, en_
    //Locale defaultLocale = Locale.getDefault();
    //ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", defaultLocale);
    //ResourceBundle

    JLabel label = new JLabel(getString("storesopenpage.title"));
    label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 20));
    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
    label.setPreferredSize(new Dimension(panelHeader.getPreferredSize().width, 50));
    label.setAlignmentX(0.5f);
    label.setForeground(Color.WHITE);

    panelHeader.add(label, CENTER_ALIGNMENT);
    return panelHeader;
  }

  @Override
  public JComponent buildFooter() {
    return null;
  }
}
