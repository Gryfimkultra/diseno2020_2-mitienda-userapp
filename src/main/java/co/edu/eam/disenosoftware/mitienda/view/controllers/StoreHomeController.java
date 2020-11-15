package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoresRepository;

import java.io.IOException;
import java.util.List;

/**
 * Store home Controller
 */
public class StoreHomeController {

  /**
   * Product Store Repository
   */
  private ProductStoresRepository productStoresRepository;
  private CategoryRepository categoryRepository;

  public StoreHomeController() {
    productStoresRepository = new ProductStoresRepository();
    categoryRepository = new CategoryRepository();
  }

  public List<ProductStore> getProductsStore(Long id) throws IOException {
    return productStoresRepository.getAllProductStoreByStoreId(id);
  }

  public List<Category> getStoreCategories(Long id) throws IOException {
    return categoryRepository.getCategoriesByStoreId(id);
  }

}
