package co.edu.eam.disenosoftware.mitienda.view.pages;

import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.view.controllers.UserRegistreController;
import co.edu.eam.disenosoftware.mitienda.view.lib.Navigator;
import co.edu.eam.disenosoftware.mitienda.view.lib.Page;
import co.edu.eam.disenosoftware.mitienda.view.widgets.TextPrompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegisterUserPage extends Page {
  @Override
  public void init() {

  }

  @Override
  public JComponent buildContent() {

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setLayout(null);
    scrollPane.setBackground(Color.white);

    Locale defaulLocale = Locale.getDefault();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", defaulLocale);

    JLabel tittle = new JLabel("<html><h2><strong>" + resourceBundle.getString("userregisterpage.title") + "</strong></h2></html>");
    JLabel description = new JLabel(("<html><h3><font color='gray'><strong>" + resourceBundle.getString("userregisterpage.lets") + "</strong></font></h3></html>"));

    JTextField userName = new JTextField("");
    userName.setBorder(null);
    JTextField emailAddress = new JTextField("");
    emailAddress.setBorder(null);
    JTextField phone = new JTextField("");
    phone.setBorder(null);
    JPasswordField password = new JPasswordField("");
    password.setBorder(null);

    TextPrompt placeUser = new TextPrompt(resourceBundle.getString("userregisterpage.username"), userName);
    TextPrompt placePassword = new TextPrompt(resourceBundle.getString("userregisterpage.password"), password);
    TextPrompt placePhone = new TextPrompt(resourceBundle.getString("userregisterpage.phone"), phone);
    TextPrompt placeEmail = new TextPrompt(resourceBundle.getString("userregisterpage.email"), emailAddress);

    JSeparator line1 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line2 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line3 = new JSeparator(SwingConstants.HORIZONTAL);
    JSeparator line4 = new JSeparator(SwingConstants.HORIZONTAL);

    JButton buttonSignIn = new JButton(resourceBundle.getString("userregisterpage.buttonsignup"));
    buttonSignIn.setOpaque(true);
    buttonSignIn.setBorderPainted(false);
    buttonSignIn.setBackground(new Color(95, 144, 81).brighter());
    buttonSignIn.setForeground(Color.WHITE);

    scrollPane.add(tittle);
    scrollPane.add(description);
    scrollPane.add(userName);
    scrollPane.add(emailAddress);
    scrollPane.add(phone);
    scrollPane.add(password);
    scrollPane.add(line1);
    scrollPane.add(line2);
    scrollPane.add(line3);
    scrollPane.add(line4);
    scrollPane.add(buttonSignIn);

    tittle.setLocation(22, 10);
    tittle.setSize(300, 80);

    description.setLocation(22, 40);
    description.setSize(300, 80);

    userName.setLocation(22, 130);
    userName.setSize(300, 20);

    emailAddress.setLocation(22, 200);
    emailAddress.setSize(300, 20);

    phone.setLocation(22, 270);
    phone.setSize(300, 20);

    password.setLocation(22, 340);
    password.setSize(300, 20);

    line1.setLocation(22, 150);
    line1.setSize(300, 20);

    line2.setLocation(22, 220);
    line2.setSize(300, 20);

    line3.setLocation(22, 290);
    line3.setSize(300, 20);

    line4.setLocation(22, 360);
    line4.setSize(300, 20);

    buttonSignIn.setLocation(217, 400);
    buttonSignIn.setSize(100, 40);

    buttonSignIn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UserRegistreController userRegistreController = new UserRegistreController();

        User user = new User(userName.getText(), phone.getText(), emailAddress.getText(), password.getText());

        userRegistreController.userRegister(user);

        JOptionPane.showMessageDialog(null, resourceBundle.getString("userregisterpage.userRegistred"));

        Navigator.goToFrame("UserLoginPage");
      }
    });

    return scrollPane;
  }

  @Override
  public JComponent buildHeader() {

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBackground(Color.white);

    Locale defaulLocale = Locale.getDefault();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", defaulLocale);

    panel.setMaximumSize(new Dimension(500, 200));

    JLabel signIn = new JLabel("<html>" + resourceBundle.getString("userloginpage.singin") + "</html>");
    JLabel signUp = new JLabel("<html><font color='green'><strong>" + resourceBundle.getString("userloginpage.singup") + "</strong></font></html>");

    signIn.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {

        Navigator.goToFrame("UserLoginPage");
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
