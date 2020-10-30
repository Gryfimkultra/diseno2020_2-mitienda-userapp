/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda.util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * HTTP retrofit client builder
 *
 * @author caferrerb
 */
public class RetroFitUtils {

  /**
   * Build the retrofit api client
   *
   * @param apiClientClass apiClient class
   * @param <T>
   * @return apiClient
   */
  public static <T> T buildAPIClient(Class<T> apiClientClass) {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://mitiendaappeam.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    return retrofit.create(apiClientClass);
  }
}
