package zerkinisoft;

import javax.swing.JTextArea;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b){
        textArea.append(String.valueOf((char)b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
