package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.request.UserLoginRequest;
import co.edu.eam.disenosoftware.mitienda.view.controllers.UserLoginController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class UserLoginPage extends Page {

  @Override
  public void init() throws Exception {

  }


  @Override
  public JComponent buildContent() throws Exception {

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setLayout(null);
    scrollPane.setBackground(Color.white);

    JLabel tittle = new JLabel("<html><h1><strong>Sign in to Grocery App</strong></h1></html>");
    JLabel description = new JLabel(("<html><h3><font color='gray'><strong>Enter email & password to continue</strong></font></h3></html>"));
    JLabel forgot = new JLabel(("<html><h3><font color='gray'><strong>¿Forgot password?</strong></font></h3></html>"));

    JTextField userName = new JTextField("");
    userName.setBorder(null);
    JPasswordField password = new JPasswordField("");
    password.setBorder(null);

    TextPrompt placeUser = new TextPrompt("User Name", userName);
    TextPrompt placePassword = new TextPrompt("Password", password);
    JSeparator line1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line2 = new JSeparator(SwingConstants.HORIZONTAL);

    JButton buttonSignIn = new JButton("SIGN IN");
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
    scrollPane.add(forgot);
    scrollPane.add(buttonSignIn);

    buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UserLoginController userLoginController = new UserLoginController();

        UserLoginRequest userLoginRequest = new UserLoginRequest(userName.getText(), password.getText());

        try {
          userLoginController.userLogin(userLoginRequest);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    tittle.setLocation(22, 10);
    tittle.setSize(300, 80);

    description.setLocation(22, 40);
    description.setSize(300, 80);

    userName.setLocation(22,130);
    userName.setSize(300, 20);

    password.setLocation(22,200);
    password.setSize(300, 20);

    line1.setLocation(22,150);
    line1.setSize(300, 20);

    line2.setLocation(22,220);
    line2.setSize(300, 20);

    forgot.setLocation(22,265);
    forgot.setSize(200, 20);

    buttonSignIn.setLocation(217,255);
    buttonSignIn.setSize(100, 40);

    return scrollPane;
  }

  @Override
  public JComponent buildHeader() throws Exception {

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(Color.white);

    panel.setMaximumSize(new Dimension(500, 200));

    JLabel signIn = new JLabel("<html><font color='green'><strong>Sign in</strong></font></html>");
    JLabel signUp = new JLabel("<html>Sign up</html>");

    signUp.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {

        Navigator.goToFrame("RegisterUserPage");
        dispose();

      }
    });

    panel.add(signIn, java.awt.BorderLayout.LINE_START);
    panel.add(signUp, java.awt.BorderLayout.LINE_END);

    return panel;
  }

  @Override
  public JComponent buildFooter() throws Exception {
    return null;
  }
}
