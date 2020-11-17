package co.edu.eam.disenosoftware.mitienda.view.widgets;

import co.edu.eam.disenosoftware.mitienda.config.Constants;
import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.util.ImageUtil;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.lib.Widget;

import javax.swing.*;
import java.awt.*;

public class StoreHomeCategoriesWidget extends Widget<Category> {

  Page page;

  public StoreHomeCategoriesWidget(Category data, Page page) {
    super(data);
    this.page = page;
  }

  @Override
  public void build() {
    this.setLayout(new BorderLayout());
    this.setBackground(Color.WHITE);
    this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    ImageIcon image = ImageUtil.loadFromURL(Constants.CATEGORY_IMAGE_URL +
            data.getIcon());
    JLabel categoryName = new JLabel(data.getName());

    JLabel categoryImage = new JLabel();
    categoryImage.setIcon(image);
    categoryImage.setPreferredSize(new Dimension(64, 64));
    categoryImage.setMaximumSize(new Dimension(64, 64));

    this.add(categoryImage, BorderLayout.CENTER);
    this.add(categoryName, BorderLayout.SOUTH);
    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        category(data.getId());
      }
    });
  }

  public void category(Long id) {

    LocalStorage.saveData("searchCategory", id);
    try {
      page.refresh();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
