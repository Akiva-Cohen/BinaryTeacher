import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MainPanel mainP = new MainPanel();
        JFrame frame = new JFrame("binary teacher");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.add(mainP);
        frame.setVisible(true);
    }
}
