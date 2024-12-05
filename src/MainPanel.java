import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainPanel extends JPanel {
    JTextField binary;
    JTextField decimal;
    JTextField hexa;
    JButton minus;
    JButton plus;
    public MainPanel() {
        super(new GridLayout(3,1));
        binary = new JTextField();
        decimal = new JTextField();
        hexa = new JTextField();
        JPanel labels = new JPanel(new GridLayout(1,3));
        JLabel binaryLabel = new JLabel("Binary");
        JLabel decimalLabel = new JLabel("Decimal");
        JLabel hexaLabel = new JLabel("Hexadecimal");
        labels.add(binaryLabel);
        labels.add(decimalLabel);
        labels.add(hexaLabel);
        JPanel boxes = new JPanel(new GridLayout(1,3));
        binary.setText("0");
        decimal.setText("0");
        hexa.setText("0");
        boxes.add(binary);
        boxes.add(decimal);
        boxes.add(hexa);
        JPanel increments = new JPanel(new GridLayout(1,2));
        minus = new JButton("-1");
        plus = new JButton("+1");
        increments.add(minus);
        increments.add(plus);

        add(labels);
        add(boxes);
        add(increments);
        binary.getDocument().addDocumentListener(new DocumentListened() {
            public void thisUpdate() {
                setFromBinary();
            }
        });
        decimal.getDocument().addDocumentListener(new DocumentListened() {
            public void thisUpdate() {
                setFromInt();
            }
        });
        hexa.getDocument().addDocumentListener(new DocumentListened() {
            public void thisUpdate() {
                setFromHex();
            }
        });
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrement();
            }
        });
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increment();
            }
        });
    }
    public void increment() {
        try {
            int num = Integer.parseInt(decimal.getText());
            set(num + 1);
        } catch (NumberFormatException e) {
            set(0);
        }
    }
    public void decrement() {
        try {
            int num = Integer.parseInt(decimal.getText());
            set (num - 1);
        } catch (NumberFormatException e) {
            set(0);
        }
    }
    public void set(int num) {

        decimal.setText(Integer.toString(num));
        binary.setText(Integer.toBinaryString(num));
        hexa.setText(Integer.toHexString(num));
    }
    public void setFromInt() {
        int num;
        try {
            num = Integer.parseInt(decimal.getText());
            set(num);
        } catch (NumberFormatException e) {}
    }
    public void setFromBinary() {
        try {
            int num = Integer.parseInt(binary.getText(),2);
            set(num);
        } catch (NumberFormatException e) {}
    }
    public void setFromHex() {
        try {
            int num = Integer.parseInt(hexa.getText(), 16);
            set(num);
        } catch (NumberFormatException e) {}
    }
}
