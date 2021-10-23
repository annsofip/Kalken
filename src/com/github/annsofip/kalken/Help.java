package com.github.annsofip.kalken;

/*****************************************************
 TNM040
 Authors: Annsofi Pettersson & Gabriella Ivarsson
 University of Linköping - Campus Norrköping
 *****************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JFrame implements ActionListener {

    private final ClassLoader cl;
    private final ImageIcon imgHelp1;
    private final ImageIcon imgHelp2;
    private final ImageIcon imgHelp3;
    private final ImageIcon imgHelp4;
    private final JLabel lblHelp;
    private static int level = 1;
    private final JButton btnOk;

    public Help() {
        cl = ClassLoader.getSystemClassLoader();


        //----------------------------------------CENTER--------------------------------//
        imgHelp1 = new ImageIcon(cl.getResource("help1.png"));
        imgHelp2 = new ImageIcon(cl.getResource("help2.png"));
        imgHelp3 = new ImageIcon(cl.getResource("help3.png"));
        imgHelp4 = new ImageIcon(cl.getResource("help4.png"));

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

        btnOk = new JButton(new ImageIcon(cl.getResource("ok.png")));
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