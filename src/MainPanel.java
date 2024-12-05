import javax.swing.*;
import java.awt.*;
public class MainPanel extends JPanel {
    JTextField binary;
    JTextField decimal;
    JTextField hexa;
    JButton minus;
    JButton plus;
    public MainPanel() {
        binary = new JTextField();
        decimal = new JTextField();
        hexa = new JTextField();
        super(new GridLayout(3,1));
        JPanel labels = new JPanel(new GridLayout(1,3));
        JLabel binaryLabel = new JLabel("Binary");
        JLabel decimalLabel = new JLabel("Decimal");
        JLabel hexaLabel = new JLabel("Hexadecimal");
        labels.add(binaryLabel);
        labels.add(decimalLabel);
        labels.add(hexaLabel);
        JPanel boxes = new JPanel(new GridLayout(1,3));
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
