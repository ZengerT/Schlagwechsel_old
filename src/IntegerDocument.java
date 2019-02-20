import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class IntegerDocument extends PlainDocument {
    private static final long serialVersionUID = 1L;
    private int validLength;

    public IntegerDocument(int i) {
        this.validLength = i;
    }

    public int getLength() {
        return super.getLength();
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        String valid = "0123456789";

        for(int i = 0; i < str.length(); ++i) {
            if (valid.indexOf(str.charAt(i)) == -1 || this.getLength() + str.length() > this.validLength) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            super.insertString(offset, str, a);
        }

    }
}
