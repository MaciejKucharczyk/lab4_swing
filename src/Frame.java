import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

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
        panel.setBounds(0, 200, 500, 500);
        setLayout(new FlowLayout());

        JPanel kanwa = new Kanwa();
        kanwa.setBounds(60,40,150,150);
        //panel.add(kanwa);
        getContentPane().add(kanwa);
        kanwa.setLayout(new FlowLayout());

        JButton btnCatchMe = new JButton("Catch me!");
        //btnCatchMe.setMnemonic(KeyEvent.VK_0);
        add(btnCatchMe);

        JButton btnReset = new JButton("Reset");
        //btnReset.setMnemonic(KeyEvent.VK_0);
        add(btnReset);

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
                                btnCatchMe.setLocation(btnReset.getX()-95, 5);
                                //kanwa.requestFocus(true);
                               // System.out.println(btnCatchMe.getX());
                            }
                        });
                    }
                }
            });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCatchMe.setLocation(btnReset.getX()-95, 5);
            }
        });

    }
    private void start(){ setVisible(true); }
}
