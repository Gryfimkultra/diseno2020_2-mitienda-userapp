/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoftware.mitienda.gui.lib;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 * Base frame
 * @author caferrerb
 */
public abstract class Page extends JFrame {
    public static double WIDTH = 500;
    public static double HEIGHT = 1000;
    
    public static double D_HEIGHT = 700.0;

    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem menuPerfil;
    private JMenuItem menuHome;
    private JMenuItem menuHistory;
    private JMenuItem menuBack;

    /**
     * params to send to gui
     */
    protected Map<String, Object> params;

    /**
     * Constructor 
     */
    public Page() {
        params = new HashMap<>();
        buildPage();
    }

    /**
     * Set parametrers to the Frame
     * @param params 
     */
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    /**
     * abstract methdo to implement conten of the page
     * @return component to render in the center of the page
     */
    public abstract JComponent buildContent();

    /**
     * abstract methdo to implement header of the page
     * @return component to render in the header of the page
     */
    public abstract JComponent buildHeader();

    /**
     * abstract methdo to implement footer of the page
     * @return component to render in the footer of the page
     */
    public abstract JComponent buildFooter();

    /**
     * Method to build the whole page
     */
    private void buildPage() {
        buildMenu();
        JComponent content = buildContent();
        JComponent header  = buildHeader();
        JComponent footer  = buildFooter();

        double ratio = HEIGHT / D_HEIGHT;

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        if(header != null) {
            getContentPane().add(header);
        }

        getContentPane().add(content);

        if(footer != null) {
            getContentPane().add(footer);
        }

        pack();
        setSize((int)(WIDTH / ratio), (int)(HEIGHT / ratio));
        setResizable(false);
    }


    /**
     * Build the app menu
     */
    private void buildMenu() {

        menuBar = new JMenuBar();
        menu = new JMenu();
        menuPerfil = new JMenuItem();
        menuHome = new JMenuItem();
        menuHistory = new JMenuItem();
        menuBack = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
