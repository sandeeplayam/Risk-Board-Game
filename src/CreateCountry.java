import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseListener;

public class CreateCountry extends JButton {

    private int x =0;
    private int y =0;

    public CreateCountry(String name){

        setBorder(new LineBorder(Color.BLUE, 3));
        setBackground(Color.WHITE);
        setBounds(x, y, 100, 100);
        setOpaque(false);
        setName(name);

       // addMouseListener(new MouseListener){

       // }

    }

}
