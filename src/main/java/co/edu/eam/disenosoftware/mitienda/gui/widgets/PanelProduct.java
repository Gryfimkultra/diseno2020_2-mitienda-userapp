package co.edu.eam.disenosoftware.mitienda.gui.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.gui.lib.Widget;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class PanelProduct extends Widget<ProductStore> {

  public PanelProduct(ProductStore data) {
    super(data);
  }

  public void build() {
    JLabel lblName = new JLabel("<html><center><p><b>" + data.getProduct().getName() + "</b></p></center></html>");
    lblName.setAlignmentX(0.5f);

    JLabel lblPrice = new JLabel(NumberFormat.getCurrencyInstance().format(data.getPrice()));
    lblPrice.setAlignmentX(0.5f);

    JLabel image = new JLabel(ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL + data.getProduct().getId() + "_small.jpg", 70, 90));
    image.setAlignmentX(0.5f);

    JButton btn = new JButton("Agregar");
    btn.setAlignmentX(0.5f);

    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Product: " + data.getProduct().getName());
      }
    });

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.setMaximumSize(new Dimension(150, 200));
    //this.setBackground(Color.WHITE);
    this.add(image);
    this.add(lblName);
    this.add(lblPrice);
    this.add(btn);
    this.setAlignmentX(Component.CENTER_ALIGNMENT);
  }
}
