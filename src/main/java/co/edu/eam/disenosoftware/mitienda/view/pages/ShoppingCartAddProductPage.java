package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Product;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.ShoppingCartAddProductControllers;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ShoppingCartAddProductPage extends Page {

  private ShoppingCartAddProductControllers controller;
  ProductStore productStore;
  int quantity;
  Long userId;
  ResourceBundle resourceBundle;
  NumberFormat formatter;

  @Override
  public void init() {
    controller = new ShoppingCartAddProductControllers();

    productStore = (ProductStore) getParam("product");

    userId = LocalStorage.getData("userId", Long.class);

    quantity = 0;

    formatter = NumberFormat. getCurrencyInstance();
  }

  @Override
  public JComponent buildContent() {
    JPanel panel = new JPanel(new GridLayout(2, 0));
    panel.setBackground(Color.WHITE);
    panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height));
    panel.setMaximumSize(new Dimension(500, 800));


    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    productStore.getProduct().getImage(),
            300, 300);

    JLabel productImage = new JLabel();
    productImage.setIcon(image);
    productImage.setHorizontalAlignment(SwingConstants.CENTER);

    JPanel panelProductInfo = new JPanel();
    panelProductInfo.setLayout(new BoxLayout(panelProductInfo, BoxLayout.Y_AXIS));
    panelProductInfo.setBackground(Color.WHITE);
    panelProductInfo.setPreferredSize(new Dimension(500, panel.getPreferredSize().height));
    panelProductInfo.setMaximumSize(new Dimension(500, 800));

    JPanel panelInfo = new JPanel(new GridLayout(2, 0));
    panelInfo.setBackground(Color.WHITE);

    JPanel panelInfoDetail = new JPanel(new GridLayout(2, 0));
    panelInfo.setBackground(Color.WHITE);

    JLabel lblNombre = new JLabel(productStore.getProduct().getName());
    lblNombre.setOpaque(true);
    lblNombre.setBackground(Color.WHITE);
    lblNombre.setFont(new Font(lblNombre.getFont().getFontName(), Font.BOLD, 20));
    lblNombre.setBorder(BorderFactory.createMatteBorder(10, 10, 5, 10, Color.WHITE));

    String moneyString =formatter. format(productStore.getPrice());
    JLabel lblPrecio = new JLabel(moneyString);
    lblPrecio.setOpaque(true);
    lblPrecio.setBackground(Color.WHITE);
    lblPrecio.setFont(new Font(lblPrecio.getFont().getFontName(), Font.BOLD, 20));
    lblPrecio.setBorder(BorderFactory.createMatteBorder(10, 10, 5, 10, Color.WHITE));

    JPanel panelCantidad = new JPanel(new BorderLayout());
    panelCantidad.setBackground(Color.WHITE);
    panelCantidad.setPreferredSize(new Dimension(334, 300));
    panelCantidad.setMaximumSize(new Dimension(334, 300));

    JLabel lblQuantity = new JLabel(getString("shoppingcartaddpage.quantity"));
    lblQuantity.setFont(new Font(lblQuantity.getFont().getFontName(), Font.BOLD, 20));
    lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel lblCantidad = new JLabel(quantity + "");
    lblCantidad.setFont(new Font(lblCantidad.getFont().getFontName(), Font.BOLD, 20));
    lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);

    JLabel agregar = new JLabel(new ImageIcon(ImageUtil.class.getClassLoader().getResource("images/agregar.png")));
    agregar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    agregar.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (quantity < productStore.getStock()) {
          quantity++;
          lblCantidad.setText(quantity + "");
        }
      }
    });

    JLabel quitar = new JLabel(new ImageIcon(ImageUtil.class.getClassLoader().getResource("images/quitar.png")));
    quitar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    quitar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    quitar.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (quantity > 0) {
          quantity--;
          lblCantidad.setText(quantity + "");
        }
      }
    });

    panelInfoDetail.add(lblNombre);
    panelInfoDetail.add(lblPrecio);

    panelCantidad.add(lblQuantity, BorderLayout.NORTH);
    panelCantidad.add(lblCantidad, BorderLayout.CENTER);
    panelCantidad.add(agregar, BorderLayout.WEST);
    panelCantidad.add(quitar, BorderLayout.EAST);

    panelInfo.add(panelInfoDetail);
    panelInfo.add(panelCantidad);


    panel.add(productImage);
    panel.add(panelInfo);

    return panel;
  }

  @Override
  public JComponent buildHeader() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(Constants.COLOR_GREEN);
    panel.setMaximumSize(new Dimension(500, 50));

    JLabel label = new JLabel(productStore.getStore().getName());
    label.setForeground(Color.WHITE);
    label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 20));
    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
    label.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        returnStore();
      }
    });

    panel.add(label, BorderLayout.WEST);
    return panel;
  }

  @Override
  public JComponent buildFooter() {
    JPanel panel = new JPanel();
    panel.setBackground(Constants.COLOR_GREEN);
    panel.setPreferredSize(new Dimension(500, panel.getPreferredSize().height));
    panel.setMaximumSize(new Dimension(500, 50));

    JLabel label = new JLabel(getString("shoppingcartaddpage.addtoshoppingcart"));
    label.setForeground(Color.WHITE);
    label.setFont(new Font(label.getFont().getFontName(), Font.BOLD, 20));

    panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    panel.add(label);

    panel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (quantity > 0) {
          try {
            controller.shoppingCartAddProductControllers(productStore.getStore().getId(), productStore.getId(), userId, quantity);
            returnStore();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    });
    return panel;
  }

  public void returnStore() {
    Map<String, Object> params = new HashMap<>();
    params.put("storeId", productStore.getStore().getId());
    goToFrame("StoreHomePage", params);
  }
}
