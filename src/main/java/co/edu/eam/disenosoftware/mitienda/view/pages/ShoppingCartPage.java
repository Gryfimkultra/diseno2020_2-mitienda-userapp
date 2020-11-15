package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCart;
import co.edu.eam.disenosoftware.mitienda.model.entities.ShoppingCartProduct;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.controllers.OrderDetailController;
import co.edu.eam.disenosoftware.mitienda.view.controllers.ShoppingCartController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.ShoppingCartDetailWidget;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartPage extends Page {

  private ShoppingCartController controller;
  private OrderDetailController orderController;
  private ShoppingCart shoppingCart;

  public ShoppingCartPage(){
    controller=new ShoppingCartController();
  }

  @Override
  public void init() throws Exception {
    controller=new ShoppingCartController();
    orderController=new OrderDetailController();
    Long storeId=LocalStorage.getData("storeId",Long.class);
    Long userId=LocalStorage.getData("userId",Long.class);

    this.shoppingCart=controller.getShoppingCard(storeId,userId);
    System.out.println(shoppingCart.getId());
  }

  @Override
  public JComponent buildContent() throws Exception {

    JScrollPane scrollProduct = new javax.swing.JScrollPane();
    JPanel panelFlowScrollProduct = new javax.swing.JPanel();
    JPanel panelGridScrollProduct = new javax.swing.JPanel();

    panelGridScrollProduct.setLayout(new java.awt.GridLayout(this.shoppingCart.getProduct().size()/2, 2, 5, 5));

    for (ShoppingCartProduct shoppingCartProduct:this.shoppingCart.getProduct()) {

      if(shoppingCartProduct!=null){
        ShoppingCartDetailWidget wdgt= new ShoppingCartDetailWidget(shoppingCartProduct,shoppingCart.getId(),this);
        panelGridScrollProduct.add(wdgt);
      }else{
        System.out.println("Empty");
      }


    }

    panelFlowScrollProduct.add(panelGridScrollProduct);

    //scrollProduct.setViewportView(panelProduct);

    JScrollPane scrollPane=new JScrollPane(panelFlowScrollProduct);



    return scrollPane;
  }

  @Override
  public JComponent buildHeader() throws Exception {

    JPanel panelHeader = new javax.swing.JPanel();
   JLabel lblHeader = new javax.swing.JLabel();
    JLabel lblTotalValue = new javax.swing.JLabel();
    JLabel lblTotalProduct = new javax.swing.JLabel();

    panelHeader.setBackground(Constants.COLOR_GREEN);

    lblHeader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    lblHeader.setText("ShoppingCart");

    lblHeader.setForeground(new Color(255,255,255));

    lblTotalValue.setText("Total: " + this.shoppingCart.getTotalValue());

    lblTotalValue.setForeground(new Color(255,255,255));

    lblTotalProduct.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

    lblTotalValue.setForeground(new Color(255,255,255));

    lblTotalProduct.setForeground(new Color(255,255,255));
    lblTotalProduct.setText("Total Products:" + this.shoppingCart.getProduct().size());

    javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
    panelHeader.setLayout(panelHeaderLayout);
    panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelHeaderLayout.createSequentialGroup()
                                            .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblTotalProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addContainerGap())
    );
    panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblHeader)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalValue)
                                    .addComponent(lblTotalProduct))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    //body
    panelHeader.setPreferredSize(new Dimension(panelHeader.getPreferredSize().width,57));
    panelHeader.setMaximumSize(new Dimension(409,57));

    return panelHeader;
  }

  @Override
  public JComponent buildFooter() throws Exception {

    JPanel panelBuyNow=new JPanel();

    panelBuyNow.setLayout(new GridLayout(1,0));

    JButton btnBuyNow=new JButton(" Buy Now " );
    panelBuyNow.add(btnBuyNow);
    btnBuyNow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {

        try {
          orderController.createOrden(shoppingCart.getId());

          Map<String, Object> params = new HashMap<>();

          Navigator.goToFrame("HistoryOrdersPage");

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
    panelBuyNow.setPreferredSize(new Dimension(panelBuyNow.getPreferredSize().width,50));
    panelBuyNow.setMaximumSize(new Dimension(500,50));
   return  panelBuyNow;
  }
  @Override
  public void refresh() throws Exception {
    super.refresh();
  }
}
