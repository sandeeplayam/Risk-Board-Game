import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Board model;
    private View view;
    private int menu;
    private int numPlayers;

    public Controller(View view) {

        this.view = view;
        menu = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (menu) {
            case 0:
                startPerformed(e);
                break;

            case 1:
                selectLevelPerformed(e);
                break;

            default:
                jMenuBarPerformed(e);
                break;
        }

    }

    private void startPerformed(ActionEvent e) {
        String input;

        if (e.getSource().getClass() == JButton.class) {
            JButton placeHolder = (JButton) e.getSource();
            input = placeHolder.getText();

            if (input.equals("Start")) {
                view.createNumOfPlayers();
                menu = 1;
            } else if (input.equals("Rules")) {
                view.showRules();
            }
        }
    }

    private void jMenuBarPerformed(ActionEvent e) {
    }

    private void selectLevelPerformed(ActionEvent e) {
    }

}
