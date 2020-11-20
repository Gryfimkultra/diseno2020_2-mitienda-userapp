package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;
import co.edu.eam.disenosoftware.mitienda.view.pages.StoreHomePage;
import co.edu.eam.disenosoftware.mitienda.view.pages.StoresOpenPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class StoresOpenWidget extends Widget<Store> {
  public StoresOpenWidget(Store data, Page page) {
    super(data,page);
  }

  @Override
  public void build() {

    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

    ImageIcon imageIcon = ImageUtil.loadFromURL(Constants.STORE_IMAGE_URL +
                    data.getId() + ".jpg",
            130, 80);


    JLabel lblImage = new JLabel(imageIcon);

    String name = data.getName();

    name = name.length() >= 18 ? name.substring(0, 15) + "..." : name;

    JLabel lblName = new JLabel(name);


    JLabel lblPhone = new JLabel(data.getPhone());

    lblPhone.setForeground(Color.gray);

    JPanel content = new JPanel();
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.setBackground(Color.white);

    content.add(lblName);
    content.add(lblPhone);

    this.add(lblImage);
    this.add(content);

    this.setBackground(Color.white);

    this.setAlignmentX(CENTER_ALIGNMENT);

    this.setBorder(new EmptyBorder(15, 15, 15, 5));

    lblName.setBorder(new EmptyBorder(0, 20, 8, 0));

    lblPhone.setBorder(new EmptyBorder(0, 20, 20, 0));

    lblName.setFont(new Font("", Font.BOLD, 14));

    lblPhone.setFont(new Font("", Font.ITALIC, 12));

    this.setBackground(new Color(255, 255, 255));

    this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", data.getId());
        parentPage.goToFrame("StoreHomePage", params);
      }
    });

  }
}
