package co.edu.eam.disenosoftware.mitienda.view.controllers;

import co.edu.eam.disenosoftware.mitienda.model.entities.Store;
import co.edu.eam.disenosoftware.mitienda.repositories.StoresRepository;

import java.io.IOException;
import java.util.List;

/**
 * Controller page stores open
 */
public class StoresOpenController {

  /**
   * stores respository
   */
  private StoresRepository storesRepository;

  public StoresOpenController () {
    storesRepository = new StoresRepository();
  }

  /**
   * Get all open stores
   * @return listo of stores open
   * @throws IOException
   */
  public List<Store> getOpenStores () throws IOException {
    return storesRepository.getAllStoresOpen();
  }

}
