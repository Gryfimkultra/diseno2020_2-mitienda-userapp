package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.view.controllers.UserLoginController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class UserLoginPage extends Page {

  @Override
  public void init() {

  }


  @Override
  public JComponent buildContent() {

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setLayout(null);
    scrollPane.setBackground(Color.white);

    JLabel tittle = new JLabel("<html><h2><strong>" + getString("userloginpage.title") + "</strong></h2></html>");
    JLabel description = new JLabel(("<html><h3><font color='gray'><strong>" + getString("userloginpage.description") + "</strong></font></h3></html>"));

    JTextField userName = new JTextField("");
    userName.setBorder(null);
    JPasswordField password = new JPasswordField("");
    password.setBorder(null);

    TextPrompt placeUser = new TextPrompt(getString("userloginpage.username"), userName);
    TextPrompt placePassword = new TextPrompt(getString("userloginpage.password"), password);
    JSeparator line1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line2 = new JSeparator(SwingConstants.HORIZONTAL);

    JButton buttonSignIn = new JButton(getString("userloginpage.buttonsignin"));
    buttonSignIn.setOpaque(true);
    buttonSignIn.setBorderPainted(false);
    buttonSignIn.setBackground(new Color(95, 144, 81).brighter());
    buttonSignIn.setForeground(Color.WHITE);

    scrollPane.add(tittle);
    scrollPane.add(description);
    scrollPane.add(userName);
    scrollPane.add(password);
    scrollPane.add(line1);
    scrollPane.add(line2);
    scrollPane.add(buttonSignIn);

    buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UserLoginController userLoginController = new UserLoginController();

        UserLoginRequest userLoginRequest = new UserLoginRequest(userName.getText(), password.getText());
        userLoginController.userLogin(userLoginRequest);

        JOptionPane.showMessageDialog(null, getString("userloginpage.userloggedin"));

        goToFrame("StoresOpenPage");
      }
    });

    tittle.setLocation(22, 10);
    tittle.setSize(300, 80);

    description.setLocation(22, 40);
    description.setSize(300, 80);

    userName.setLocation(22, 130);
    userName.setSize(300, 20);

    password.setLocation(22, 200);
    password.setSize(300, 20);

    line1.setLocation(22, 150);
    line1.setSize(300, 20);

    line2.setLocation(22, 220);
    line2.setSize(300, 20);

    buttonSignIn.setLocation(217, 255);
    buttonSignIn.setSize(100, 40);

    return scrollPane;
  }

  @Override
  public JComponent buildHeader() {

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(Color.white);

    panel.setMaximumSize(new Dimension(500, 200));

    JLabel signIn = new JLabel("<html><font color='green'><strong>" + getString("userloginpage.singin") + "</strong></font></html>");
    JLabel signUp = new JLabel("<html>" + getString("userloginpage.singup") + "</html>");

    signUp.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        goToFrame("RegisterUserPage");
      }
    });

    panel.add(signIn, java.awt.BorderLayout.LINE_START);
    panel.add(signUp, java.awt.BorderLayout.LINE_END);

    return panel;
  }

  @Override
  public JComponent buildFooter() {
    return null;
  }
}
