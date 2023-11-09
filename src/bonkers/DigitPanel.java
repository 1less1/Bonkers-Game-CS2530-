package bonkers;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Each individual digit is a DigitPanel
public class DigitPanel extends JPanel{

    private Random generator = new Random();
    private JRadioButton isHigher = new JRadioButton();
    private JRadioButton isLower = new JRadioButton();

    private Boolean correctIsHigher;

    public DigitPanel(Integer correctNumber) {
        setLayout(new BorderLayout());
        add(new JLabel(""+correctNumber));

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(isHigher);
        radioButtons.add(isLower);



        Integer numberToDisplay = (correctNumber + 1 + generator.nextInt(9)) % 10;

        correctIsHigher = numberToDisplay < correctNumber;

        add(isHigher, BorderLayout.NORTH);
        add(new JLabel(""+numberToDisplay));
        add(isLower, BorderLayout.SOUTH);
    }

    public boolean isCorrect()  {
        return(correctIsHigher && isHigher.isSelected()) || (!correctIsHigher && isLower.isSelected());
    }
}
