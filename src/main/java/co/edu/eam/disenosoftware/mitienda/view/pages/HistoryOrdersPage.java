package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.view.controllers.HistoryOrdersController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.HistoryOrdersWidget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Page History Orders
 */
public class HistoryOrdersPage extends Page {

  /**
   *Page Controller
   */
  private HistoryOrdersController historyOrdersController;

  @Override
  public void init() throws Exception {

  }

  @Override
  public JComponent buildContent() throws Exception {

    historyOrdersController = new HistoryOrdersController();

    Long userId = (Long) getParam("userId");
    userId = 11L;
    List<Order> orderList = historyOrdersController.getOrderList(userId);

    JPanel panelGeneral = new JPanel();
    panelGeneral.setLayout(new GridLayout(3,1));
    panelGeneral.setBackground(Color.WHITE);

    JPanel panelUser1 = new JPanel();
    JPanel panelUser2 = new JPanel();
    JPanel panelUser3 = new JPanel();

    JLabel label1 = new JLabel("IN_CURSE");
    panelUser1.add(label1);

    JLabel label2 = new JLabel("ORDERS_FINISHED");
    panelUser2.add(label2);

    JLabel label3 = new JLabel("ORDERS_CANCELED");
    panelUser3.add(label3);

    for (Order order: orderList) {
      if (order.getState().equals("created")){
        HistoryOrdersWidget wdgt = new HistoryOrdersWidget(order);
        panelUser1.add(wdgt);
      }else if (order.getState().equals("finished")){
        HistoryOrdersWidget wdgt = new HistoryOrdersWidget(order);
        panelUser2.add(wdgt);
      }else if (order.getState().equals("canceled")){
        HistoryOrdersWidget wdgt = new HistoryOrdersWidget(order);
        panelUser3.add(wdgt);
      }
    }

    panelUser1.setLayout(new BoxLayout(panelUser1,BoxLayout.Y_AXIS));
    panelUser1.setBackground(Color.WHITE);

    panelUser2.setLayout(new BoxLayout(panelUser2,BoxLayout.Y_AXIS));
    panelUser2.setBackground(Color.WHITE);

    panelUser3.setLayout(new BoxLayout(panelUser3,BoxLayout.Y_AXIS));
    panelUser3.setBackground(Color.WHITE);

    panelGeneral.add(panelUser1);
    panelGeneral.add(panelUser2);
    panelGeneral.add(panelUser3);

    JScrollPane  scrollPane = new JScrollPane(panelGeneral);
    return scrollPane;
  }

  @Override
  public JComponent buildHeader() throws Exception {
    JPanel panelOrder = new JPanel();
    panelOrder.setLayout(new GridLayout(1,1));
    panelOrder.setBackground(Constants.COLOR_GREEN);

    JLabel label = new JLabel("Order History");
    label.setPreferredSize(new Dimension(label.getPreferredSize().width,2));
    panelOrder.add(label);
    return panelOrder;

  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }
}
