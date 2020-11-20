package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Order;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class HistoryOrdersWidget extends Widget<Order> {

  public HistoryOrdersWidget(Order data) {
    super(data);
  }


  @Override
  public void build() {
    ImageIcon imageIcon = ImageUtil.loadFromURL(Constants.STORE_IMAGE_URL + data.getStore().getId() +
            ".jpg", 130, 80);
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    JLabel lblImage = new JLabel(imageIcon);

    JPanel panelInfo = new JPanel();
    panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
    panelInfo.setBackground(Color.WHITE);

    Locale defaultLocale = Locale.getDefault();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", defaultLocale);

    JLabel lblName = new JLabel();
    lblName.setText(resourceBundle.getString("historyorderspage.store's_name") + data.getStore().getName());
    JLabel lblTotalProduct = new JLabel();
    lblTotalProduct.setText(resourceBundle.getString("historyorderspage.total_products") + data.getProduct().size());
    JLabel lblTotalOrder = new JLabel(NumberFormat.getCurrencyInstance().format(data.getTotalValue()));
    JLabel lblDate = new JLabel(SimpleDateFormat.getDateInstance().format(data.getDate()));

    JButton jButton = new JButton();
    jButton.setIcon(new ImageIcon(ImageUtil.class.getClassLoader().getResource("images/ver.png")));
    jButton.setBorder(BorderFactory.createEmptyBorder(6,10,6,10));
    jButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    jButton.setBackground(new Color(88, 214, 141 ));

    panelInfo.add(lblName);
    panelInfo.add(lblTotalProduct);
    panelInfo.add(lblTotalOrder);
    panelInfo.add(lblDate);

    ActionListener accion = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", data.getId());

        LocalStorage.saveData("orderId", data.getId());
        Navigator.goToFrame("OrderDetailPage", params);
      }
    };
    jButton.addActionListener(accion);
    panelInfo.add(jButton);

    this.setBackground(Color.WHITE);
    this.add(lblImage);
    this.add(panelInfo);
  }

}
