/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda;

import co.edu.eam.disenosoftware.mitienda.util.LocalStorage;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author caferrerb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Long[] ids = new Long[2];
        ids[0] =  3l;
        ids[1] = 1l;

        Map<String, Object> params = new HashMap<>();
        params.put("categoryId", ids);

        LocalStorage.saveData("categoryId", ids);

        Navigator.goToFrame("StoreHomePage",params);
    }
    
}
