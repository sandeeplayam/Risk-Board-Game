import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @Author Sudarsana Sandeep
 */
public class CustomCountry extends JButton {

    private int x =0;
    private int y =0;
    private int displayX = 0;
    private int displayY = 0;

    public CustomCountry(String name){

        setBorder(new LineBorder(Color.BLUE));
        setBackground(Color.WHITE);
        setBounds(0, 0, 50, 50);
        setOpaque(false);
        setText(name);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                displayX = e.getXOnScreen();
                displayY = e.getYOnScreen();

                x = getX();
                y = getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int relX = e.getXOnScreen() - displayX;
                int relY = e.getYOnScreen() - displayY;

                setLocation(x + relX, y + relY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
