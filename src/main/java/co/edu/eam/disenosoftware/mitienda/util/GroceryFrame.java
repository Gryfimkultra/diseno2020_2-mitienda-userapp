/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda.util;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Base frame
 * @author caferrerb
 */
public class GroceryFrame extends JFrame {
    
    
    public static double WIDTH = 1242.0;
    public static double HEIGHT = 2688.0;
    
    public static double D_HEIGHT = 700.0;

    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuPerfil;
    private javax.swing.JMenuItem menuHome;
    private javax.swing.JMenuItem menuHistory;
    private javax.swing.JMenuItem menuBack;

 
    
    /**
     * params to send to gui
     */
    protected Map<String, Object> params;

    /**
     * Constructor 
     */
    public GroceryFrame() {
        params = new HashMap<>();
        buildComponents();
    }
    
    
    /**
     * Close this frame
     */
    public void close() {
        
    }

    /**
     * Set parametrers to the Frame
     * @param params 
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    
    
      // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void buildComponents() {

        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuPerfil = new javax.swing.JMenuItem();
        menuHome = new javax.swing.JMenuItem();
        menuHistory = new javax.swing.JMenuItem();
        menuBack = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setText("....");

        menuPerfil.setText("Perfil");
        menuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToFrame("Profile");
            }
            
        });
        menu.add(menuPerfil);

        menuHome.setText("Home");
        menuHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToFrame("Home");
            }
        });
        menu.add(menuHome);

        menuHistory.setText("Historial");
        menuHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToFrame("History");
            }
        });
        menu.add(menuHistory);
        
        
        menuBack.setText("Back");
        menuBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBack();
            }
        });
        menu.add(menuBack);
        
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        double ratio = HEIGHT / D_HEIGHT;
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, (int)(WIDTH / ratio), Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, (int)(HEIGHT / ratio), Short.MAX_VALUE)
        );
        pack();
        setResizable(false);
    }
    
       
    /**
     * go to frame
     * @param frame class name of the frame 
     */
    public void goToFrame(String frame) {
        Navigator.goToFrame(frame);
        setVisible(true);
        this.dispose();
    }
    
    /**
     * Go Back
     */
    public void goBack() {
        if(Navigator.goBack()!=null) {
              setVisible(true);
            this.dispose();  
        };
    }
    
    /**
     * method to navigate to a frame
     * @param frame class name of the frame
     * @param params param to send
     */
    public void goToFrame(String frame, Map<String, Object> params) {
        Navigator.goToFrame(frame, params);
        setVisible(true);
        this.dispose();
    }
    
    /**
     * method to get param
     * @param key
     * @return 
     */
    public Object getParam(String key) {
        return params.get(key);
    }
}
