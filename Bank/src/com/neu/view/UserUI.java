/*
 * Created by JFormDesigner on Wed Jun 30 22:08:41 CST 2021
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
public class UserUI extends JFrame {
    private Service serve = new Service();
    private LoginUI loginUI;

    public UserUI(LoginUI loginUI, Service serve){
        initComponents();
        this.serve = serve;
        hostname.setText(serve.getName());
        Account.setText(serve.getMoney()+"");
        SavingAccount.setText(serve.getSaving()+"");
        this.loginUI = loginUI;
    }

    private void button3MouseClicked(MouseEvent e) {
        serve.logout();
        this.setVisible(false);
        loginUI.setVisible(true);
    }

    private void depositMouseClicked(MouseEvent e) {
        Object[] options = {"存信用卡", "存实际卡"};
        int m = JOptionPane.showOptionDialog(null,"请选择你要存储的账户:","存钱",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if(m == 0){
            String  s = (String) JOptionPane.showInputDialog(null,"请输入你有多少钱要存入:\n","存信用卡",
                    JOptionPane.PLAIN_MESSAGE,null,null,"请输入数字");
            if(s.matches("\\d+(.\\d+)?")){
                System.out.println("存入"+s);
                double money = Double.parseDouble(s);
                System.out.println(money);
                if(serve.depositChecking(money)){
                    JOptionPane.showMessageDialog(null,"存储成功","提示",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"存储错误","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"存储失败","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            String  s = (String) JOptionPane.showInputDialog(null,"请输入你有多少钱要存入:\n","存实际卡",
                    JOptionPane.PLAIN_MESSAGE,null,null,"请输入数字");
            if(s.matches("\\d+(.\\d+)?")){
                System.out.println("存入"+s);
                double money = Double.parseDouble(s);
                System.out.println(money);
                if(serve.depositSaving(money)){
                    JOptionPane.showMessageDialog(null,"存储成功","提示",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"存储错误","提示",JOptionPane.PLAIN_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"存储失败","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
        Account.setText(serve.getMoney()+"");
        SavingAccount.setText(serve.getSaving()+"");

    }

    private void drawMouseClicked(MouseEvent e) {
        String  s = (String) JOptionPane.showInputDialog(null,"请输入你有多少钱要取出:\n","存实际卡",
                JOptionPane.PLAIN_MESSAGE,null,null,"请输入数字");
        if(s.matches("\\d+(.\\d+)?")){
            double money = Double.parseDouble(s);
            if(serve.draw(money)){
                JOptionPane.showMessageDialog(null,"取出成功");
            }else{
                JOptionPane.showMessageDialog(null,"取出失败","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"取出失败","提示",JOptionPane.PLAIN_MESSAGE);
        }
        Account.setText(serve.getMoney()+"");
        SavingAccount.setText(serve.getSaving()+"");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        hostname = new JLabel();
        Account = new JLabel();
        SavingAccount = new JLabel();
        draw = new JButton();
        deposit = new JButton();
        exit = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u5c0a\u656c\u7684\u7528\u6237, \u6b22\u8fce\u4f60\u7684\u5230\u6765");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            panel1.add(label1);
            label1.setBounds(0, 0, 400, label1.getPreferredSize().height);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d:");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(55, 55), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("\u4fe1\u7528\u8d26\u6237\u4f59\u989d:");
            panel1.add(label3);
            label3.setBounds(new Rectangle(new Point(55, 95), label3.getPreferredSize()));

            //---- label4 ----
            label4.setText("\u5b9e\u9645\u8d26\u6237\u4f59\u989d:");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(55, 135), label4.getPreferredSize()));

            //---- hostname ----
            hostname.setText("text");
            panel1.add(hostname);
            hostname.setBounds(185, 55, 130, 20);

            //---- Account ----
            Account.setText("text");
            panel1.add(Account);
            Account.setBounds(185, 95, 125, 15);

            //---- SavingAccount ----
            SavingAccount.setText("text");
            panel1.add(SavingAccount);
            SavingAccount.setBounds(185, 135, 120, 20);

            //---- draw ----
            draw.setText("\u53d6\u94b1");
            draw.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    drawMouseClicked(e);
                }
            });
            panel1.add(draw);
            draw.setBounds(new Rectangle(new Point(55, 195), draw.getPreferredSize()));

            //---- deposit ----
            deposit.setText("\u5b58\u94b1");
            deposit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    depositMouseClicked(e);
                }
            });
            panel1.add(deposit);
            deposit.setBounds(new Rectangle(new Point(165, 195), deposit.getPreferredSize()));

            //---- exit ----
            exit.setText("\u9000\u51fa");
            exit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel1.add(exit);
            exit.setBounds(new Rectangle(new Point(270, 195), exit.getPreferredSize()));

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
        panel1.setBounds(0, 0, 400, 270);

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
    private JLabel label4;
    private JLabel hostname;
    private JLabel Account;
    private JLabel SavingAccount;
    private JButton draw;
    private JButton deposit;
    private JButton exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
