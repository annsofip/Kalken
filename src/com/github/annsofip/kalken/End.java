package com.github.annsofip.kalken;

/*****************************************************
 TNM040
 Authors: Annsofi Pettersson & Gabriella Ivarsson
 University of Linköping - Campus Norrköping
 *****************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class End extends JFrame implements ActionListener {

    private final ClassLoader cl;
    private final ImageIcon imgEnd;
    private final JLabel lblEnd;
    private final JButton btnRestart;

    public End() {
        cl = ClassLoader.getSystemClassLoader();

        //----------------------------------------CENTER--------------------------------//
        imgEnd = new ImageIcon(cl.getResource("resources/end.png"));
        lblEnd = new JLabel(imgEnd);
        btnRestart = new JButton(new ImageIcon(cl.getResource("resources/restart.png")));
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
			
		
