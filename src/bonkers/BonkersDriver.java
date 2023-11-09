package bonkers;

import javax.swing.*;

public class BonkersDriver {

    public static void main(String args[]) {
        Bonkers b = new Bonkers(1234);
        JFrame jf = new JFrame("Bonkers Game");
        jf.add(b);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600,600);
        jf.setVisible(true);

    }
}
