package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.controllers.ShoppingCartController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;

public class ShoppingCartDetailWidget extends Widget<ShoppingCartProduct> {

  private ShoppingCartController controller;
  private final Long shoppingCartId;
  private final Page shoppingCardPage;

  public ShoppingCartDetailWidget(ShoppingCartProduct data, Long idShoppingCart, Page page) {
    super(data);
    shoppingCartId = idShoppingCart;
    shoppingCardPage = page;

  }

  @Override
  public void build() {
    ImageIcon image = ImageUtil.loadFromURL(Constants.PRODUCT_IMAGE_URL +
                    data.getProduct().getProduct().getId() + "_small.jpg",
            70, 80);

    JLabel lblImgProduct = new javax.swing.JLabel(image);
    JButton btnDeleteShoppingCardProduct = new javax.swing.JButton();
    JLabel lblNameProduct = new javax.swing.JLabel();
    JLabel lblPrice = new javax.swing.JLabel();

    this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

    this.setBackground(new Color(255, 255, 255));

    controller = new ShoppingCartController();
    btnDeleteShoppingCardProduct.setText("Eliminar");
    btnDeleteShoppingCardProduct.setBackground(new Color(220, 53, 69));
    btnDeleteShoppingCardProduct.setForeground(new Color(255, 255, 255));

    btnDeleteShoppingCardProduct.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        controller.deleteShoppingCart(shoppingCartId, data.getId());
        shoppingCardPage.refresh();
      }
    });

    String nombreProducto = data.getProduct().getProduct().getName();
    nombreProducto = nombreProducto.length() >= 18 ? nombreProducto.substring(0, 15) + "..." : nombreProducto;
    // lblNameProduct.setText(data.getProduct().getProduct().getName());
    lblNameProduct.setText(nombreProducto);
    lblPrice.setText("$ " + data.getProduct().getPrice());

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(this);
    this.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImgProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(btnDeleteShoppingCardProduct))
                                    .addComponent(lblNameProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNameProduct)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPrice)
                            .addGap(0, 0, 0)
                            .addComponent(btnDeleteShoppingCardProduct)
                            .addContainerGap())
    );

  }
}
