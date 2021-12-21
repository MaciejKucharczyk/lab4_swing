import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener {

    private char key;
    private int x,y;

    public Kanwa(){
        setFocusable(true);
        setVisible(true);
        requestFocus();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                key=e.getKeyChar();
                if(key=='o' || key=='O'){
                    key='o';
                    repaint();
                }

                if(key=='k' || key=='K'){
                    key='k';
                    repaint();
                }

            }
        });
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // x=e.getX();
       // y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // x=e.getX();
        //y=e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //x=e.getX();
        //y=e.getY();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //x=e.getX();
        //y=e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       // x=e.getX();
        //y=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
     // x=e.getX();
     // y=e.getY();
    }

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);
        Graphics2D graphic2D = (Graphics2D) graphic;
        if(key=='k'){
            graphic.setColor(Color.RED);
            graphic2D.drawRect(x,y,30,30);
            graphic2D.fillRect(x,y,30,30);
        }
        if(key=='o'){
            graphic.setColor(Color.GREEN);
            graphic2D.drawOval(x,y,30,30);
            graphic2D.fillOval(x,y,30,30);
            System.out.println(x); System.out.println(y);
        }
    }
}
