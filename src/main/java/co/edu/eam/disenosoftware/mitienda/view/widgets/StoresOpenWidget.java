package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class StoresOpenWidget extends Widget<Store> {
  public StoresOpenWidget(Store data) {
    super(data);
  }

  @Override
  public void build() {

    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

    ImageIcon imageIcon = ImageUtil.loadFromURL(Constants.STORE_IMAGE_URL +
            data.getId() + ".jpg",
            130,80);

    this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

    this.setAlignmentX(0.0f);

    JLabel lblImage = new JLabel(imageIcon);

    JLabel lblName = new JLabel(data.getName());

    this.add(lblImage);
    this.add(lblName);

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Map<String, Object> params = new HashMap<>();
        params.put("storeId", data.getId());
        System.out.println(params);
        //Navigator.goToFrame("ProductsStorePage",params);
      }
    });

  }
}
