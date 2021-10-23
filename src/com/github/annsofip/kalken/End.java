package com.github.annsofip.kalken;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class End extends JFrame implements ActionListener {

    public End() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        //----------------------------------------CENTER--------------------------------//
        ImageIcon imgEnd = new ImageIcon(Objects.requireNonNull(cl.getResource("resources/end.png")));
        JLabel lblEnd = new JLabel(imgEnd);
        JButton btnRestart = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("resources/restart.png"))));
        btnRestart.setBounds(300, 180, 80, 40);
        lblEnd.setBounds(0, 0, 450, 263);

        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(null);
        pnlCenter.add(lblEnd);
        pnlCenter.add(btnRestart);

        btnRestart.addActionListener(this);

        //--------------------------------------SOUTH-------------------------------------//
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(null);

        //-----------------------------------CONTAINER----------------------------------//
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(pnlCenter, BorderLayout.CENTER);
        c.add(pnlSouth, BorderLayout.SOUTH);
        setSize(450, 280);
        setVisible(true);
        setResizable(false);
        setLocation(580, 280);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
			
		
