package com.github.annsofip.kalken;

/*****************************************************
 TNM040
 Authors: Annsofi Pettersson & Gabriella Ivarsson
 University of Linköping - Campus Norrköping
 *****************************************************/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    private final ClassLoader cl;
    private final ImageIcon imgAbout;
    private final JLabel lblAbout;
    private final JButton btnOk;

    public About() {
        cl = ClassLoader.getSystemClassLoader();


        //----------------------------------------CENTER--------------------------------//
        imgAbout = new ImageIcon(cl.getResource("om.png"));

        lblAbout = new JLabel(imgAbout);

        lblAbout.setBounds(0, 0, 450, 263);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.add(lblAbout);

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

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}