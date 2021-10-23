package com.github.annsofip.kalken;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class About extends JFrame implements ActionListener {

    public About() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();


        //----------------------------------------CENTER--------------------------------//
        ImageIcon imgAbout = new ImageIcon(Objects.requireNonNull(cl.getResource("om.png")));

        JLabel lblAbout = new JLabel(imgAbout);

        lblAbout.setBounds(0, 0, 450, 263);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.add(lblAbout);

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

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}