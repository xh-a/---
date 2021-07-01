/*
 * Created by JFormDesigner on Wed Jun 30 21:35:24 CST 2021
 */

package com.neu.view;

import com.neu.service.impl.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author 1
 */
public class RegisterUI extends JFrame {
    Service serve = new Service();
    LoginUI loginUI;//??到底哪里错了

    public RegisterUI() {
        initComponents();
    }
    public RegisterUI(Service service, LoginUI loginUI) {
        this.serve = service;
        this.loginUI = loginUI;
        initComponents();
    }

    private void confirmKeyPressed(KeyEvent e) {

    }

    private void backKeyPressed(KeyEvent e) {

    }

    private void confirmMouseClicked(MouseEvent e) {
        System.out.println("你好");
        String name = host.getText();
        String pw1 = password1.getText();
        String pw2 = password2.getText();
        if(name != null && pw1 != null && pw2 != null && name.length() != 0 && pw1.equals(pw2)){
            if(serve.openAccount(name,pw1,0,0)){
                JOptionPane.showMessageDialog(null,"注册成功!");
                this.setVisible(false);
                loginUI.setVisible(true);
                return;
            }else{
                JOptionPane.showMessageDialog(null,"用户名错误或密码不同 注册失败");
                return ;
            }
        }
    }

    private void backMouseClicked(MouseEvent e) {
        this.setVisible(false);
        loginUI.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        host = new JTextField();
        password1 = new JTextField();
        password2 = new JTextField();
        confirm = new JButton();
        back = new JButton();
        label4 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u7528\u6237\u540d:");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(45, 65), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u5bc6\u7801:");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(45, 115), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u786e\u8ba4\u5bc6\u7801:");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(45, 165), label3.getPreferredSize()));
            panel1.add(host);
            host.setBounds(120, 65, 200, host.getPreferredSize().height);
            panel1.add(password1);
            password1.setBounds(120, 115, 200, password1.getPreferredSize().height);
            panel1.add(password2);
            password2.setBounds(120, 165, 200, password2.getPreferredSize().height);

            //---- confirm ----
            confirm.setText("\u786e\u8ba4");
            confirm.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    confirmKeyPressed(e);
                }
            });
            confirm.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    confirmMouseClicked(e);
                }
            });
            panel1.add(confirm);
            confirm.setBounds(new Rectangle(new Point(110, 215), confirm.getPreferredSize()));

            //---- back ----
            back.setText("\u8fd4\u56de");
            back.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    backKeyPressed(e);
                }
            });
            back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backMouseClicked(e);
                }
            });
            panel1.add(back);
            back.setBounds(new Rectangle(new Point(230, 215), back.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u7528\u6237\u6ce8\u518c");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(175, 20), label4.getPreferredSize()));

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
        panel1.setBounds(0, 0, 400, 260);

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField host;
    private JTextField password1;
    private JTextField password2;
    private JButton confirm;
    private JButton back;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
