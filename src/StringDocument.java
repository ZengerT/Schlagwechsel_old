import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class StringDocument extends PlainDocument {
    private static final long serialVersionUID = 1L;
    private int validLength;

    public StringDocument(int i) {
        this.validLength = i;
    }

    public int getLength() {
        return super.getLength();
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        String invalid = "+-:;!\"§$%&/()=?*/#~<>|";

        for(int i = 0; i < str.length(); ++i) {
            if (invalid.indexOf(str.charAt(i)) >= 0 || this.getLength() + str.length() > this.validLength) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            super.insertString(offset, str, a);
        }

    }
}
