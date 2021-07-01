/*
 * Created by JFormDesigner on Wed Jun 30 20:59:22 CST 2021
 */

package com.neu.view;

import com.neu.service.impl.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 1
 */
public class LoginUI extends JFrame {
    private Service serv = new Service();
    private RegisterUI registerUI = new RegisterUI(serv, this);
    UserUI userUI;

    public LoginUI(Service serv) throws HeadlessException {
        this.serv = serv;
        initComponents();
    }

    public LoginUI() {
        initComponents();
    }

    private void confirmMouseClicked(MouseEvent e) {
        String name = hostName.getText();
        String pw = password.getText();
        if(name != null && pw != null){
            if(serv.login(name,pw)){
                JOptionPane.showMessageDialog(null,"登录成功");
                //进入用户界面
                userUI = new UserUI(this, serv);
                this.setVisible(false);
                userUI.setVisible(true);

            }else{
                JOptionPane.showMessageDialog(null,"密码或用户名错误");
            }
        }
    }

    private void loginMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void exitMouseClicked(MouseEvent e) {
        System.exit(0);
    }

    private void registerMouseClicked(MouseEvent e) {
        this.setVisible(false);
        registerUI.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        heading = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        hostName = new JTextField();
        password = new JTextField();
        login = new JButton();
        register = new JButton();
        exit = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- heading ----
            heading.setText("\u94f6\u884c\u5ba2\u6237\u7cfb\u7edf");
            heading.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(heading);
            heading.setBounds(0, 0, 425, 90);

            //---- label3 ----
            label3.setText("\u7528\u6237\u540d:");
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            label3.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            panel1.add(label3);
            label3.setBounds(0, 100, 135, 45);

            //---- label4 ----
            label4.setText("\u5bc6\u7801   :");
            label4.setHorizontalAlignment(SwingConstants.RIGHT);
            label4.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            panel1.add(label4);
            label4.setBounds(0, 150, 135, 45);
            panel1.add(hostName);
            hostName.setBounds(140, 105, 225, 35);
            panel1.add(password);
            password.setBounds(140, 155, 225, 35);

            //---- login ----
            login.setText("\u767b\u5f55");
            login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    confirmMouseClicked(e);
                    loginMouseClicked(e);
                }
            });
            panel1.add(login);
            login.setBounds(new Rectangle(new Point(85, 210), login.getPreferredSize()));

            //---- register ----
            register.setText("\u6ce8\u518c");
            register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerMouseClicked(e);
                }
            });
            panel1.add(register);
            register.setBounds(new Rectangle(new Point(185, 210), register.getPreferredSize()));

            //---- exit ----
            exit.setText("\u9000\u51fa");
            exit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    exitMouseClicked(e);
                    exitMouseClicked(e);
                }
            });
            panel1.add(exit);
            exit.setBounds(new Rectangle(new Point(285, 210), exit.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 425, 265);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel heading;
    private JLabel label3;
    private JLabel label4;
    private JTextField hostName;
    private JTextField password;
    private JButton login;
    private JButton register;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
