package com.github.annsofip.kalken;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class Kalken extends JFrame implements ActionListener {

    private final JButton btnOne;
    private final JButton btnTwo;
    private final JButton btnThree;
    private final JButton btnFour;
    private final JButton btnFive;
    private final JButton btnSix;
    private final JButton btnSeven;
    private final JButton btnEight;
    private final JButton btnNine;
    private final JButton btnReset;
    private final JButton btnLevel;
    private final JButton btnHelp;
    private final JButton btnAbout;
    private final JLabel lblLevel;
    private final JLabel lblNrpoints;
    private final JLabel lblAnswer;
    private final JLabel lblSum;
    private final JLabel lblBig;
    private final JLabel lblProgress;
    private final JTextArea txtSum;
    private static int sum = 0, random = 0, points = 0;
    private boolean first = true;
    private static Object button;
    private static int level = 1, integer1 = 0, integer2 = 0;
    private static final int THRESHOLD = 50;
    private static final int ROOF = 20;
    private final JRadioButton chkHorse;
    private final JRadioButton chkBike;
    private final JRadioButton chkHuman;
    private final ImageIcon imgHuman;
    private final ImageIcon imgBike;
    private final ImageIcon imgHorse;
    private final JMenuItem itmExit;
    private final JMenuItem itmRestart;

    public Kalken() {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        //----------------------------MENU-----------------------------------//
        JMenuBar mnuBar = new JMenuBar();
        JMenu mnuIcon = new JMenu("Byt karaktär");
        JMenu mnuFile = new JMenu("Arkiv");
        itmExit = new JMenuItem("Avsluta");
        itmRestart = new JMenuItem("Starta om");

        chkHuman = new JRadioButton("Människa", true);
        chkHorse = new JRadioButton("Häst", false);
        chkBike = new JRadioButton("Motorcykel", false);

        chkHuman.addActionListener(this);
        chkHorse.addActionListener(this);
        chkBike.addActionListener(this);
        itmExit.addActionListener(this);
        itmRestart.addActionListener(this);

        mnuFile.add(itmRestart);
        mnuFile.add(itmExit);

        mnuIcon.add(chkHuman);
        mnuIcon.add(chkHorse);
        mnuIcon.add(chkBike);

        mnuBar.add(mnuFile);
        mnuBar.add(mnuIcon);

        setJMenuBar(mnuBar);
        //----------------------------------------CENTER--------------------------------//

        //--------Buttons-------//
        lblAnswer = new JLabel();
        txtSum = new JTextArea(3, 1);
        lblSum = new JLabel(" = " + sum);

        //--------Layout-------//
        txtSum.setBounds(45, 50, 250, 190);
        lblAnswer.setBounds(40, 0, 320, 60);
        txtSum.setLineWrap(true);
        lblSum.setBounds(200, 220, 100, 80);
        txtSum.setBorder(null);
        lblAnswer.setFont(new Font("Courier", Font.BOLD, 18));
        txtSum.setFont(new Font("Courier", Font.BOLD, 16));
        lblSum.setFont(new Font("Courier", Font.BOLD, 24));
        txtSum.setForeground(Color.WHITE);
        //Color myColor = new Color(61, 115, 156);
        txtSum.setBackground(Color.BLACK);
        txtSum.setEditable(false);

        //--------Layout-------//
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout(null);

        //pnlCenter.setBackground(myColor);
        pnlCenter.setPreferredSize(new Dimension(3200, 200));

        //--------Add-------//
        pnlCenter.add(txtSum);
        pnlCenter.add(lblSum);
        pnlCenter.add(lblAnswer);

        //---------------------------------------WEST-----------------------------------//
        //--------Buttons-------//
        JLabel lblKalken = new JLabel(new ImageIcon(Objects.requireNonNull(cl.getResource("kalken.png"))));
        btnOne = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("1.png"))));
        btnTwo = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("2.png"))));
        btnThree = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("3.png"))));
        btnFour = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("4.png"))));
        btnFive = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("5.png"))));
        btnSix = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("6.png"))));
        btnSeven = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("7.png"))));
        btnEight = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("8.png"))));
        btnNine = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("9.png"))));
        btnReset = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("angra.png"))));
        btnLevel = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("level.png"))));

        //--------Layout-------//
        lblKalken.setBounds(5, 8, 92, 33);
        btnOne.setBounds(25, 40, 45, 45);
        btnTwo.setBounds(75, 40, 45, 45);
        btnThree.setBounds(125, 40, 45, 45);
        btnFour.setBounds(25, 90, 45, 45);
        btnFive.setBounds(75, 90, 45, 45);
        btnSix.setBounds(125, 90, 45, 45);
        btnSeven.setBounds(25, 140, 45, 45);
        btnEight.setBounds(75, 140, 45, 45);
        btnNine.setBounds(125, 140, 45, 45);
        btnLevel.setBounds(5, 200, 110, 45);
        btnReset.setBounds(120, 200, 70, 45);

        btnLevel.setEnabled(false);
        JPanel pnlWest = new JPanel();
        pnlWest.setLayout(null);
        pnlWest.setPreferredSize(new Dimension(200, 200));


        //--------Add-------//
        pnlWest.add(lblKalken);
        pnlWest.add(btnOne);
        pnlWest.add(btnTwo);
        pnlWest.add(btnThree);
        pnlWest.add(btnFour);
        pnlWest.add(btnFive);
        pnlWest.add(btnSix);
        pnlWest.add(btnSeven);
        pnlWest.add(btnEight);
        pnlWest.add(btnNine);
        pnlWest.add(btnReset);
        pnlWest.add(btnLevel);

        //---------------------------------------EAST------------------------------------//
        //-------Labels-------//
        lblLevel = new JLabel("Level 1");
        JLabel lblPoints = new JLabel("Poäng");
        lblNrpoints = new JLabel("0");
        JLabel lblBoard = new JLabel(new ImageIcon(Objects.requireNonNull(cl.getResource("board.png"))));
        btnHelp = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("helpbutton.png"))));
        btnAbout = new JButton(new ImageIcon(Objects.requireNonNull(cl.getResource("about.png"))));

        //--------Layout--------//
        lblLevel.setBounds(15, 40, 60, 60);
        lblPoints.setBounds(15, 90, 60, 60);
        lblNrpoints.setBounds(40, 110, 60, 60);
        lblBoard.setBounds(0, 50, 80, 130);
        btnHelp.setBounds(20, 15, 30, 30);
        btnAbout.setBounds(55, 15, 30, 30);

        lblLevel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        lblPoints.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
        lblNrpoints.setFont(new Font("Courier", Font.BOLD, 18));
        JPanel pnlEast = new JPanel();
        pnlEast.setLayout(null);

        pnlEast.setPreferredSize(new Dimension(100, 200));

        //----------Add--------//
        pnlEast.add(lblLevel);
        pnlEast.add(lblNrpoints);
        pnlEast.add(lblPoints);
        pnlEast.add(lblBoard);
        pnlEast.add(btnHelp);
        pnlEast.add(btnAbout);

        //--------------------------------------SOUTH-------------------------------------//

        lblBig = new JLabel();
        random();
        JLabel lblTrack = new JLabel(new ImageIcon(Objects.requireNonNull(cl.getResource("travbana.png"))));
        imgHuman = new ImageIcon(Objects.requireNonNull(cl.getResource("human.png")));
        imgBike = new ImageIcon(Objects.requireNonNull(cl.getResource("bike.png")));
        imgHorse = new ImageIcon(Objects.requireNonNull(cl.getResource("horse.png")));

        lblProgress = new JLabel(imgHuman);


        //--------Layout--------//
        lblBig.setBounds(300, 10, 300, 60);
        lblTrack.setBounds(0, 0, 650, 100);
        lblProgress.setBounds(0, 40, 100, 60);
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(null);
        lblBig.setForeground(Color.WHITE);
        pnlSouth.setPreferredSize(new Dimension(550, 100));

        //----------Add--------//

        pnlSouth.add(lblBig);

        pnlSouth.add(lblProgress);
        pnlSouth.add(lblTrack);


        //-----------------------------ACTIONLISTENER-----------------------------------//
        btnOne.addActionListener(this);
        btnTwo.addActionListener(this);
        btnThree.addActionListener(this);
        btnFour.addActionListener(this);
        btnFive.addActionListener(this);
        btnSix.addActionListener(this);
        btnSeven.addActionListener(this);
        btnEight.addActionListener(this);
        btnNine.addActionListener(this);
        btnReset.addActionListener(this);
        btnLevel.addActionListener(this);
        btnHelp.addActionListener(this);
        btnAbout.addActionListener(this);

        //-----------------------------------CONTAINER----------------------------------//
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(pnlWest, BorderLayout.WEST);
        c.add(pnlEast, BorderLayout.EAST);
        c.add(pnlCenter, BorderLayout.CENTER);
        c.add(pnlSouth, BorderLayout.SOUTH);
        setSize(650, 425);
        setVisible(true);
        setResizable(false);
        setLocation(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //-------------------------------BUTTONENABLER-----------------------------------//
    public void buttonEnabler() {
        btnLevel.setEnabled(true);
        btnOne.setEnabled(false);
        btnTwo.setEnabled(false);
        btnThree.setEnabled(false);
        btnFour.setEnabled(false);
        btnFive.setEnabled(false);
        btnSix.setEnabled(false);
        btnSeven.setEnabled(false);
        btnEight.setEnabled(false);
        btnNine.setEnabled(false);
        btnReset.setEnabled(false);
    }

    //-------------------------------LEVELCHOOSER-----------------------------------//
    public void levelChooser() {
        if (level == 1) {
            level1();
            lblAnswer.setText("Addition ?+? = " + random);
            lblLevel.setText("Level 1");
        } else if (level == 2) {
            lblAnswer.setText("Subtraktion " + ROOF + " - ? = " + random);
            lblLevel.setText("Level 2");
            level2();


        } else if (level == 3) {
            level3();
            lblAnswer.setText("Multiplikation ? * ? = " + random);
            lblLevel.setText("Level 3");
        } else if (level == 4) {
            level4();
            lblAnswer.setText("Division " + random + " / ? = " + integer1);
            lblLevel.setText("Level 4");
        }
    }

    //------------------------------------MOVE--------------------------------------//
    public void move() {
        int tempx = (540 / THRESHOLD) * points;
        lblProgress.setBounds(tempx, 40, 100, 53);
    }

    //-----------------------------------RANDOM-------------------------------------//
    public void random() {
        //-------Labels-------//
        if (level == 1) {
            random = (int) Math.ceil(Math.random() * (ROOF - 1));
            lblAnswer.setText("Addition ? + ? = " + random);
            lblLevel.setText("Level 1");
        } else if (level == 2) {
            random = (int) Math.ceil(Math.random() * (ROOF - 1));
            lblAnswer.setText("Subtraktion " + ROOF + " - ? = " + random);
            sum = ROOF;
        } else if (level == 3) {
            int temp1 = (int) Math.ceil(Math.random() * 9);
            int temp2 = (int) Math.ceil(Math.random() * 9);
            random = temp1 * temp2;
            lblAnswer.setText("Multiplikation ? * ? = " + random);
            sum = 0;
        }

        //------level4-------//
        else if (level == 4) {
            integer1 = (int) Math.ceil(Math.random() * 9);
            integer2 = (int) Math.ceil(Math.random() * 9);

            random = integer1 * integer2;
            lblAnswer.setText("Division " + random + " / ? = " + integer1);

            sum = 0;
        }
    }

    //-----------------------------------EMPTY--------------------------------------//
    public void empty() {
        txtSum.setText("");
        first = true;
    }

    //---------------------------------RESTART---------------------------------------//
    public void restart() {
        level = 1;
        sum = 0;
        points = 0;
        lblNrpoints.setText("" + points);
        lblLevel.setText("Level 1");
        lblSum.setText(" = 0");
        random();
        empty();
        lblProgress.setBounds(0, 40, 100, 53);
        levelChooser();
    }

    //----------------------------------LEVEL 1-------------------------------------//
    public void level1() {
        if (first) {
            lblBig.setText("");
        }
        //---------1--------//
        if (button == btnOne) {
            if (first) {
                txtSum.setText("1");
                sum += 1;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 1");
                sum += 1;
                lblSum.setText(" = " + sum);
            }
        }
        //---------2--------//
        if (button == btnTwo) {
            if (first) {
                txtSum.setText("2");
                sum += 2;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 2");
                sum += 2;
                lblSum.setText(" = " + sum);
            }
        }
        //---------3--------//
        if (button == btnThree) {
            if (first) {
                txtSum.setText("3");
                sum += 3;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 3");
                sum += 3;
                lblSum.setText(" = " + sum);
            }
        }
        //---------4--------//
        if (button == btnFour) {
            if (first) {
                txtSum.setText("4");
                sum += 4;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 4");
                sum += 4;
                lblSum.setText(" = " + sum);
            }
        }
        //---------5--------//
        if (button == btnFive) {
            if (first) {
                txtSum.setText("5");
                sum += 5;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 5");
                sum += 5;
                lblSum.setText(" = " + sum);
            }
        }
        //---------6--------//
        if (button == btnSix) {
            if (first) {
                txtSum.setText("6");
                sum += 6;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 6");
                sum += 6;
                lblSum.setText(" = " + sum);
            }
        }
        //---------7--------//
        if (button == btnSeven) {
            if (first) {
                txtSum.setText("7");
                sum += 7;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 7");
                sum += 7;
                lblSum.setText(" = " + sum);
            }
        }
        //---------8--------//
        if (button == btnEight) {
            if (first) {
                txtSum.setText("8");
                sum += 8;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 8");
                sum += 8;
                lblSum.setText(" = " + sum);
            }
        }
        //---------9--------//
        if (button == btnNine) {
            if (first) {
                txtSum.setText("9");
                sum += 9;
                lblSum.setText(" = " + sum);
                first = false;
            } else if (txtSum.getLineCount() <= 9) {
                txtSum.append(" + 9");
                sum += 9;
                lblSum.setText(" = " + sum);
            }
        }
        //---------Reset--------//
        if (button == btnReset) {
            empty();
            lblSum.setText(" = 0");
            sum = 0;

        }
        //---------Correct answer--------//
        if (sum == random && !first) {
            lblBig.setText("Bra gjort!");
            empty();
            random();
            points += 5;
            lblNrpoints.setText("" + points);
            lblSum.setText(" = 0");
            sum = 0;
            move();
        }
        //---------Too big numbers--------//
        if (sum > random && !first) {
            lblBig.setText("Nu blev summan för stor, försök igen.");
            empty();
            points -= 1;
            lblNrpoints.setText("" + points);
            lblSum.setText(" = 0");
            sum = 0;
        }
        if (points >= THRESHOLD) {
            level = 2;
            random();
            lblBig.setText("Grattis! Du har nu nött Level 2.");
            points = 0;
            lblNrpoints.setText("" + points);
            lblProgress.setBounds(0, 40, 100, 53);
            buttonEnabler();
            Help.setLevel(level);
        }

    }

    //----------------------------------LEVEL 2-------------------------------------//
    public void level2() {
        if (first) {
            lblBig.setText("");
        }
        //---------1--------//
        if (button == btnOne) {
            if (first) {
                txtSum.setText(ROOF + " - 1");
                sum = ROOF - 1;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 1");
                sum -= 1;
                lblSum.setText(" = " + sum);
            }
        }
        //---------2--------//
        if (button == btnTwo) {
            if (first) {
                txtSum.setText(ROOF + " - 2");
                sum = ROOF - 2;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 2");
                sum -= 2;
                lblSum.setText(" = " + sum);
            }
        }
        //---------3--------//
        if (button == btnThree) {
            if (first) {
                txtSum.setText(ROOF + " - 3");
                sum = ROOF - 3;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 3");
                sum -= 3;
                lblSum.setText(" = " + sum);
            }
        }
        //---------4--------//
        if (button == btnFour) {
            if (first) {
                txtSum.append(ROOF + " - 4");
                sum = ROOF - 4;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 4");
                sum -= 4;
                lblSum.setText(" = " + sum);
            }
        }
        //---------5--------//
        if (button == btnFive) {
            if (first) {
                txtSum.append(ROOF + " - 5");
                sum = ROOF - 5;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 5");
                sum -= 5;
                lblSum.setText(" = " + sum);
            }
        }
        //---------6--------//
        if (button == btnSix) {
            if (first) {
                txtSum.append(ROOF + " - 6");
                sum = ROOF - 6;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 6");
                sum -= 6;
                lblSum.setText(" = " + sum);
            }
        }
        //---------7--------//
        if (button == btnSeven) {
            if (first) {
                txtSum.append(ROOF + " - 7");
                sum = ROOF - 7;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 7");
                sum -= 7;
                lblSum.setText(" = " + sum);
            }
        }
        //---------8--------//
        if (button == btnEight) {
            if (first) {
                txtSum.append(ROOF + " - 8");
                sum = ROOF - 8;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 8");
                sum -= 8;
                lblSum.setText(" = " + sum);
            }
        }
        //---------9--------//
        if (button == btnNine) {
            if (first) {
                txtSum.append(ROOF + " - 9");
                sum = ROOF - 9;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" - 9");
                sum -= 9;
                lblSum.setText(" = " + sum);
            }
        }
        //---------Reset--------//
        if (button == btnReset) {
            empty();
            lblSum.setText(" = " + ROOF);
        }
        //---------Correct answer--------//
        if (sum == random && !first) {
            lblBig.setText("Bra gjort!");
            empty();
            random();
            points += 5;
            lblNrpoints.setText("" + points);
            sum = ROOF;
            lblSum.setText(" = " + ROOF);
            move();
        }
        //---------Too big numbers--------//
        if (sum < random && !first) {
            lblSum.setText(" = " + ROOF);
            lblBig.setText("Nu blev differansen för liten, försök igen.");
            empty();
            points -= 1;
            lblNrpoints.setText("" + points);
        }
        if (points > THRESHOLD) {
            level = 3;
            random();
            lblBig.setText("Grattis! Du har nu nött Level 3.");
            points = 0;
            lblNrpoints.setText("" + points);
            lblProgress.setBounds(0, 40, 100, 53);
            btnLevel.setEnabled(true);
            sum = 0;
            lblSum.setText("= " + sum);
            buttonEnabler();
            Help.setLevel(level);
        }
    }

    //----------------------------------LEVEL 3-------------------------------------//
    public void level3() {
        if (first) {
            lblBig.setText("");
        }
        //---------1--------//
        if (button == btnOne) {
            if (first) {
                txtSum.setText("1");
                sum = 1;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 1");
                lblSum.setText(" = " + sum);
            }
        }
        //---------2--------//
        if (button == btnTwo) {
            if (first) {
                txtSum.setText("2");
                sum = 2;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 2");
                sum *= 2;
                lblSum.setText(" = " + sum);
            }
        }
        //---------3--------//
        if (button == btnThree) {
            if (first) {
                txtSum.setText("3");
                sum = 3;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 3");
                sum *= 3;
                lblSum.setText(" = " + sum);
            }
        }
        //---------4--------//
        if (button == btnFour) {
            if (first) {
                txtSum.append("4");
                sum = 4;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 4");
                sum *= 4;
                lblSum.setText(" = " + sum);
            }
        }
        //---------5--------//
        if (button == btnFive) {
            if (first) {
                txtSum.append("5");
                sum = 5;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 5");
                sum *= 5;
                lblSum.setText(" = " + sum);
            }
        }
        //---------6--------//
        if (button == btnSix) {
            if (first) {
                txtSum.append("6");
                sum = 6;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 6");
                sum *= 6;
                lblSum.setText(" = " + sum);
            }
        }
        //---------7--------//
        if (button == btnSeven) {
            if (first) {
                txtSum.append("7");
                sum = 7;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 7");
                sum *= 7;
                lblSum.setText(" = " + sum);
            }
        }
        //---------8--------//
        if (button == btnEight) {
            if (first) {
                txtSum.append("8");
                sum = 8;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 8");
                sum *= 8;
                lblSum.setText(" = " + sum);
            }
        }
        //---------9--------//
        if (button == btnNine) {
            if (first) {
                txtSum.append("9");
                sum = 9;
                lblSum.setText(" = " + sum);
                first = false;
            } else {
                txtSum.append(" * 9");
                sum *= 9;
                lblSum.setText(" = " + sum);
            }
        }
        //---------Reset--------//
        if (button == btnReset) {
            empty();
            lblSum.setText(" = 0");
        }
        //---------Correct answer--------//
        if (sum == random && !first) {
            lblBig.setText("Bra gjort!");
            empty();
            random();
            points += 5;
            lblNrpoints.setText("" + points);
            sum = 0;
            lblSum.setText(" = 0");
            move();
        }
        //---------Too big numbers--------//
        if (sum > random && !first) {
            lblSum.setText(" = 0");
            lblBig.setText("Nu blev produkten för stor, försök igen.");
            empty();
            points -= 1;
            lblNrpoints.setText("" + points);
        }
        if (points > THRESHOLD) {
            level = 4;
            random();
            lblBig.setText("Grattis! Du har nu nött Level 4.");
            points = 0;
            lblNrpoints.setText("" + points);
            lblProgress.setBounds(0, 40, 100, 53);
            btnLevel.setEnabled(true);
            sum = 0;
            lblSum.setText("= " + sum);
            buttonEnabler();
            Help.setLevel(level);
        }

    }

    //-----------------------------LEVEL 4--------------------------------------//
    public void level4() {
        if (first) {
            lblBig.setText("");
        }
        //---------1--------//
        if (button == btnOne) {
            sum = 1;
        }
        //---------2--------//
        if (button == btnTwo) {
            sum = 2;
        }
        //---------3--------//
        if (button == btnThree) {
            sum = 3;
        }
        //---------4--------//
        if (button == btnFour) {
            sum = 4;
        }
        //---------5--------//
        if (button == btnFive) {
            sum = 5;
        }
        //---------6--------//
        if (button == btnSix) {
            sum = 6;
        }
        //---------7--------//
        if (button == btnSeven) {
            sum = 7;
        }
        //---------8--------//
        if (button == btnEight) {
            sum = 8;
        }
        //---------9--------//
        if (button == btnNine) {
            sum = 9;
        }
        //---------Reset--------//
        if (button == btnReset) {
            empty();
            lblSum.setText(" = 0");
        }
        //---------Correct answer--------//
        if (sum == integer2) {
            lblBig.setText("Bra gjort!");
            empty();
            random();
            points += 5;
            lblNrpoints.setText("" + points);
            sum = 0;
            lblSum.setText(" = 0");
            move();
        }
        //---------Too big numbers--------//
        if (sum != integer2 && sum != 0) {
            lblSum.setText(" = 0");
            lblBig.setText(sum + " ör fel tal, försök igen.");
            empty();
            points -= 1;
            lblNrpoints.setText("" + points);
        }
        if (points > THRESHOLD) {
            buttonEnabler();
            restart();
            new End();
        }
    }

    //------------------------------ACTIONPERFORMED--------------------------------//
    public void actionPerformed(ActionEvent e) {
        button = e.getSource();

        if (button == btnLevel) {
            btnLevel.setEnabled(false);
            btnOne.setEnabled(true);
            btnTwo.setEnabled(true);
            btnThree.setEnabled(true);
            btnFour.setEnabled(true);
            btnFive.setEnabled(true);
            btnSix.setEnabled(true);
            btnSeven.setEnabled(true);
            btnEight.setEnabled(true);
            btnNine.setEnabled(true);
            btnReset.setEnabled(true);
            empty();
            sum = 0;
            lblSum.setText("= " + sum);
            levelChooser();
        } else if (button == itmRestart) {
            restart();
        } else if (button == chkHorse) {
            lblProgress.setIcon(imgHorse);
            chkHuman.setSelected(false);
            chkBike.setSelected(false);
        } else if (button == chkHuman) {
            lblProgress.setIcon(imgHuman);
            chkBike.setSelected(false);
            chkHorse.setSelected(false);
        } else if (button == chkBike) {
            lblProgress.setIcon(imgBike);
            chkHorse.setSelected(false);
            chkHuman.setSelected(false);
        } else if (button == itmExit) {
            System.exit(0);
        } else if (button == btnHelp) {
            new Help();
        } else if (button == btnAbout) {
            new About();
        } else {
            levelChooser();
        }
    }


    public static void main(String[] args) {
        new Kalken();
    }

}
