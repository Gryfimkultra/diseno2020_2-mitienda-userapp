package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Category;
import co.edu.eam.disenosoftware.mitienda.model.entities.ProductStore;
import co.edu.eam.disenosoftware.mitienda.repositories.CategoryRepository;
import co.edu.eam.disenosoftware.mitienda.repositories.ProductStoresRepository;

import java.util.List;

/**
 * Store home Controller
 */
public class StoreHomeController {

  /**
   * Product Store Repository
   */
  private final ProductStoresRepository productStoresRepository;
  private final CategoryRepository categoryRepository;

  public StoreHomeController() {
    productStoresRepository = new ProductStoresRepository();
    categoryRepository = new CategoryRepository();
  }

  public List<ProductStore> getProductsStore(Long id) {
    return productStoresRepository.getAllProductStoreByStoreId(id);
  }

  public List<Category> getStoreCategories(Long id) {
    return categoryRepository.getCategoriesByStoreId(id);
  }

}
