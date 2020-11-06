package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.OrderProduct;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class OrderProductDetailWidget extends Widget<OrderProduct> {

  public OrderProductDetailWidget(OrderProduct data) {
    super(data);
  }

  @Override
  public void build() {

    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
            data.getProductStore().getProduct().getId() + "_small.jpg",
            80,120);

    this.setAlignmentX(0.0f);
    JLabel lblImage = new JLabel(image);
    this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

    this.setPreferredSize(new Dimension(getPreferredSize().width, 150));

    JPanel panelInfo = new JPanel();
    panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));

    JLabel lblPrecio = new JLabel(NumberFormat.getCurrencyInstance().format(data.getProductStore().getPrice()));
    JLabel lblNombre = new JLabel(data.getProductStore().getProduct().getName());
    panelInfo.add(lblNombre);
    panelInfo.add(lblPrecio);

    this.add(lblImage);
    this.add(panelInfo);
  }
}
