package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;

public class StoreHomeProductWidget extends Widget<ProductStore> {

  public StoreHomeProductWidget(ProductStore data) {
    super(data);
  }

  @Override
  public void build() {
    this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    JPanel productInfo = new JPanel();
    productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
    productInfo.setBackground(Color.WHITE);
    productInfo.setBorder(BorderFactory.createLineBorder(Constants.COLOR_GREEN));
    productInfo.setMaximumSize(new Dimension(150, 170));

    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL+
            data.getProduct().getId()+"_small.jpg",
            150, 150);

    JLabel productImage = new JLabel();
    productImage.setIcon(image);

    String product = data.getProduct().getName();
    product = product.length() >=22? product.substring(0,22)+"...":product;

    JPanel productDetailInfo = new JPanel();
    productDetailInfo.setLayout(new BoxLayout(productDetailInfo, BoxLayout.Y_AXIS));
    productDetailInfo.setBorder(BorderFactory.createMatteBorder(10,10,10,10,Color.WHITE));
    productDetailInfo.setBackground(Color.WHITE);

    JLabel productName  = new JLabel(product);
    productName.setMaximumSize(new Dimension(140,productName.getPreferredSize().height));

    JLabel productPrice = new JLabel("$"+data.getPrice());
    productPrice.setMaximumSize(new Dimension(150,productPrice.getPreferredSize().height));

    productDetailInfo.add(productName);
    productDetailInfo.add(productPrice);
    productInfo.add(productImage);
    productInfo.add(productDetailInfo);
    productInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.add(productInfo);

  }
}
