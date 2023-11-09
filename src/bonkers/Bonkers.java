package bonkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Bonkers extends JPanel {

    private JLabel statusMessage = new JLabel();

    private Integer numberToGuess;
    private ArrayList<DigitPanel> digits = new ArrayList<>();

    public Bonkers(Integer number) {
        numberToGuess=number;
        Integer reversedNumber=0;

        while(number > 0) {
            Integer lowPlace = number %10;
            reversedNumber= reversedNumber * 10 + lowPlace;
            //add(new DigitPanel(lowPlace));
            number = number/10;
            System.out.println(reversedNumber);
        }

        while(reversedNumber>0) {
            DigitPanel d = new DigitPanel(reversedNumber%10);
            add(d);
            digits.add(d);
            reversedNumber= reversedNumber/10;
        }



        JButton checkButton = new JButton("Check");

        // Anonymous Class below
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Boolean isCorrect=true;
                for(DigitPanel d : digits) {
                    isCorrect = isCorrect && d.isCorrect();

                    if (isCorrect) {
                        statusMessage.setText("You Win!");
                    } else {
                        statusMessage.setText("Not Quite");
                    }
                }

            }
        });

        add(checkButton);
        add(statusMessage);
    }




}
