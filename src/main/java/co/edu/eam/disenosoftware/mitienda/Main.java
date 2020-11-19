/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda;

import co.edu.eam.disenosoftware.mitienda.exceptions.ExceptionHandler;
import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;

/**
 * @author caferrerb
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    Navigator.goToFrame("UserLoginPage");
    
  }

}
