import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static javax.swing.SwingConstants.WEST;

public class Frame extends JFrame {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new Frame("Mouse tester").start();
        });
    }

    public Frame(String title) throws HeadlessException{
        super(title);

        Random generator = new Random();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1000, 1000);
        setLayout(null);

        JButton btnCatchMe = new JButton("Catch me!");
        btnCatchMe.setMnemonic(KeyEvent.VK_0);
        add(btnCatchMe);
        btnCatchMe.setBounds(5,5,100,50);

        JButton btnReset = new JButton("Reset");
        btnReset.setMnemonic(KeyEvent.VK_0);
        add(btnReset);
        btnReset.setBounds(120,5,100,50);
        btnCatchMe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (e.getX() < 60) {
                        super.mouseEntered(e);
                        int x = generator.nextInt(700);
                        int y = generator.nextInt(700);
                        btnCatchMe.setLocation(x, y);
                    } else {
                        btnCatchMe.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                btnCatchMe.setLocation(5, 5);
                                KanwaOn(btnCatchMe, btnReset);


                            }
                        });
                    }
                }
            });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCatchMe.setLocation(5, 5);
            }
        });



    }
    private void start(){ setVisible(true); }

    public void KanwaOn(JButton btnCatchMe, JButton btnReset){
        JPanel kanwa = new Kanwa();
        remove(btnCatchMe);
        remove(btnReset);
        kanwa.setBounds(10,300,200,200);
        getContentPane().add(kanwa);
        kanwa.setBackground(Color.darkGray);
        kanwa.setLayout(null);
    }
}
