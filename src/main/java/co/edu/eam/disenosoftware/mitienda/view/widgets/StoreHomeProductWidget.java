package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class StoreHomeProductWidget extends Widget<ProductStore> {

  public StoreHomeProductWidget(ProductStore data, Page page) {
    super(data, page);
  }

  @Override
  public void build() {
    this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JPanel productInfo = new JPanel();
    productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.X_AXIS));
    productInfo.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Constants.COLOR_GREEN));
    productInfo.setBackground(Color.WHITE);
    productInfo.setPreferredSize(new Dimension(265, 100));
    productInfo.setMaximumSize(new Dimension(265, 100));

    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getProduct().getId() + "_small.jpg",
            100, 100);

    JLabel productImage = new JLabel();
    productImage.setIcon(image);

    String product = data.getProduct().getName();
    product = product.length() >= 21 ? product.substring(0, 21) + "..." : product;

    JPanel productDetailInfo = new JPanel();
    productDetailInfo.setBackground(Color.WHITE);
    productDetailInfo.setLayout(new BoxLayout(productDetailInfo, BoxLayout.Y_AXIS));
    productDetailInfo.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

    JLabel productName = new JLabel(product);
    productName.setBackground(Color.WHITE);
    productName.setMaximumSize(new Dimension(140, productName.getPreferredSize().height));
    productName.setPreferredSize(new Dimension(140, productName.getPreferredSize().height));

    NumberFormat formatter = NumberFormat. getCurrencyInstance();
    String moneyString =formatter. format(data.getPrice());
    JLabel productPrice = new JLabel(moneyString);
    productPrice.setBackground(Color.WHITE);
    productPrice.setMaximumSize(new Dimension(150, productPrice.getPreferredSize().height));
    productPrice.setPreferredSize(new Dimension(150, productPrice.getPreferredSize().height));

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

    parentPage.goToFrame("ShoppingCartAddProductPage", params);
  }

}
