package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StoreHomeProductWidget extends Widget<ProductStore> {

  Page page;

  public StoreHomeProductWidget(ProductStore data, Page page) {
    super(data);
    this.page = page;
  }

  @Override
  public void build() {
    this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel productInfo = new JPanel();
    productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
    productInfo.setBackground(Color.WHITE);
    productInfo.setBorder(BorderFactory.createLineBorder(Constants.COLOR_GREEN));
    productInfo.setMaximumSize(new Dimension(150, 170));

    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getProduct().getId() + "_small.jpg",
            150, 150);

    JLabel productImage = new JLabel();
    productImage.setIcon(image);

    String product = data.getProduct().getName();
    product = product.length() >= 22 ? product.substring(0, 22) + "..." : product;

    JPanel productDetailInfo = new JPanel();
    productDetailInfo.setLayout(new BoxLayout(productDetailInfo, BoxLayout.Y_AXIS));
    productDetailInfo.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
    productDetailInfo.setBackground(Color.WHITE);

    JLabel productName = new JLabel(product);
    productName.setMaximumSize(new Dimension(140, productName.getPreferredSize().height));

    JLabel productPrice = new JLabel("$" + data.getPrice());
    productPrice.setMaximumSize(new Dimension(150, productPrice.getPreferredSize().height));

    productDetailInfo.add(productName);
    productDetailInfo.add(productPrice);
    productInfo.add(productImage);
    productInfo.add(productDetailInfo);
    productInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    productInfo.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        agregarShoppingCart();
      }
    });
    this.add(productInfo);

  }

  public void agregarShoppingCart() {
    Map<String, Object> params = new HashMap<>();
    params.put("product", data);

    LocalStorage.saveData("productStore", data);

    Navigator.goToFrame("ShoppingCartAddProductPage", params);
    page.dispose();
  }

}
