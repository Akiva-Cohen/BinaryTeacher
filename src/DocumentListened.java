import javax.swing.event.*;
public interface DocumentListened extends DocumentListener {
    default void changedUpdate(DocumentEvent e) {
        thisUpdate();
    }
    default void insertUpdate(DocumentEvent e) {
        thisUpdate();
    }
    default void removeUpdate(DocumentEvent e) {
        thisUpdate();
    }
    void thisUpdate();
}
