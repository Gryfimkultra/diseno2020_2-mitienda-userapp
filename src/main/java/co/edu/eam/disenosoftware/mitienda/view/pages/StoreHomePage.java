package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.StoreHomeController;
import co.edu.eam.disenosoftware.mitienda.view.lib.ListView;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreHomeCategoriesWidget;
import co.edu.eam.disenosoftware.mitienda.view.widgets.StoreHomeProductWidget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreHomePage extends Page {

  private StoreHomeController controller;
  List<Category> categories;
  List<ProductStore> productStores;
  Long searchCategory;

  @Override
  public void init() throws Exception {

    controller = new StoreHomeController();

    searchCategory = LocalStorage.getData("searchCategory", Long.class);

    Long storeId =  LocalStorage.getData("storeId", Long.class);

    this.categories = controller.getStoreCategories(storeId);
    this.productStores = controller.getProductsStore(storeId);
  }

  @Override
  public JComponent buildContent() throws Exception {

    JPanel containerPanel = new JPanel();
    containerPanel.setOpaque(false);
    containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));

    /**
     * Store Categories Section
     */

    JPanel categoriesPanel = new JPanel();
    categoriesPanel.setLayout(new BoxLayout(categoriesPanel, BoxLayout.X_AXIS));

    categoriesPanel.setBackground(Color.WHITE);

    for (Category category: categories){
      StoreHomeCategoriesWidget widget = new StoreHomeCategoriesWidget(category, this);
      categoriesPanel.add(widget);
    }

    JScrollPane categoriesScrollPane = new JScrollPane(categoriesPanel);
    categoriesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    categoriesScrollPane.setBackground(Constants.COLOR_GREEN);
    categoriesScrollPane.setPreferredSize(new Dimension(categoriesScrollPane.getMaximumSize().width, 170));
    categoriesScrollPane.setMaximumSize(new Dimension(categoriesScrollPane.getMaximumSize().width, 170));

    containerPanel.add(categoriesScrollPane);

    /**
     * Products Store Per Category WithOut Search
     */

    if (searchCategory == null || searchCategory.equals("")) {
      List<ListView<JComponent>> productWidgetsVertical = new ArrayList<>();

      for (Category category : categories) {

        List<StoreHomeProductWidget> productWidgetsHorizontal = new ArrayList<>();

        for (ProductStore productStore : productStores) {
          if (productStore.getCategory().getId().equals(category.getId())) {
            StoreHomeProductWidget widget = new StoreHomeProductWidget(productStore, this);
            productWidgetsHorizontal.add(widget);
          }
        }
        ListView<JComponent> listViewHorizontal = new ListView(productWidgetsHorizontal, ListView.ListViewOrientation.HORIZONTAL);
        listViewHorizontal.setPreferredSize(new Dimension(320, 270));
        listViewHorizontal.setMaximumSize(new Dimension(320, 270));
        listViewHorizontal.setBorder(BorderFactory.createTitledBorder(category.getName()));

        productWidgetsVertical.add(listViewHorizontal);
      }
      ListView<JComponent> listView = new ListView(productWidgetsVertical, ListView.ListViewOrientation.VERTICAL);
      listView.setPreferredSize(new Dimension(listView.getMaximumSize().width, 740));
      listView.setMaximumSize(new Dimension(listView.getMaximumSize().width, 740));

      containerPanel.add(listView);
    }
    /**
     * Products Store Per Category WithOut Search
     */
    else{

      List<StoreHomeProductWidget> productWidgetsHorizontal = new ArrayList<>();

        for (ProductStore productStore : productStores) {
          if (productStore.getCategory().getId().equals(searchCategory)) {
            StoreHomeProductWidget widget = new StoreHomeProductWidget(productStore, this);
            productWidgetsHorizontal.add(widget);
          }
        }

      ListView<JComponent> listView = new ListView(productWidgetsHorizontal, ListView.ListViewOrientation.VERTICAL);
      listView.setPreferredSize(new Dimension(listView.getMaximumSize().width, 740));
      listView.setMaximumSize(new Dimension(listView.getMaximumSize().width, 740));

      containerPanel.add(listView);

    }
    containerPanel.setBackground(Color.WHITE);
    containerPanel.setPreferredSize(new Dimension(500, containerPanel.getPreferredSize().height));
    containerPanel.setMaximumSize(new Dimension(500, 800));
    return containerPanel;
  }

  @Override
  public JComponent buildHeader() throws Exception {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(Constants.COLOR_GREEN);
    panel.setMaximumSize(new Dimension(500, 50));

    JLabel label = new JLabel(productStores.get(0).getStore().getName());
    label.setForeground(Color.WHITE);
    label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 20));
    label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    label.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        LocalStorage.saveData("searchCategory", null);
        try {
          refresh();
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    });

    JLabel cartIcon = new JLabel(new ImageIcon(ImageUtil.class.getClassLoader().getResource("images/shopping-cart.png")));
    cartIcon.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    cartIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
    cartIcon.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        shoppingCart(LocalStorage.getData("storeId", Long.class));
      }
    });

    panel.add(label, BorderLayout.WEST);
    panel.add(cartIcon, BorderLayout.EAST);
    return panel;
  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }

  public void shoppingCart (Long storeId){

    Map<String, Object> params = new HashMap<>();
    params.put("storeId", productStores.get(0).getStore().getId());

    LocalStorage.saveData("storeId", productStores.get(0).getStore().getId());

    Navigator.goToFrame("ShoppingCartPage",params);
  }

  @Override
  public void refresh() throws Exception {
    super.refresh();
  }
}
