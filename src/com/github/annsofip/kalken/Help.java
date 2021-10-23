package com.github.annsofip.kalken;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Help extends JFrame implements ActionListener {

    private static int level = 1;

    public Help() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();


        //----------------------------------------CENTER--------------------------------//
        ImageIcon imgHelp1 = new ImageIcon(Objects.requireNonNull(cl.getResource("help1.png")));
        ImageIcon imgHelp2 = new ImageIcon(Objects.requireNonNull(cl.getResource("help2.png")));
        ImageIcon imgHelp3 = new ImageIcon(Objects.requireNonNull(cl.getResource("help3.png")));
        ImageIcon imgHelp4 = new ImageIcon(Objects.requireNonNull(cl.getResource("help4.png")));

        JLabel lblHelp;
        if (level == 1) {
            lblHelp = new JLabel(imgHelp1);
        } else if (level == 2) {
            lblHelp = new JLabel(imgHelp2);
        } else if (level == 3) {
            lblHelp = new JLabel(imgHelp3);
        } else {
            lblHelp = new JLabel(imgHelp4);
        }
        lblHelp.setBounds(0, 0, 450, 263);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.add(lblHelp);
        //pnlCenter.setPreferredSize(new Dimension(3200,200));

        JButton btnOk = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("ok.png"))));
        btnOk.setBounds(390, 215, 40, 30);
        pnlCenter.add(btnOk);
        btnOk.addActionListener(this);

        //-----------------------------------CONTAINER----------------------------------//
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(pnlCenter, BorderLayout.CENTER);
        setSize(450, 280);
        setVisible(true);
        setResizable(false);
        setLocation(580, 280);
    }

    public static void setLevel(int lev) {
        level = lev;

    }


    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }


}