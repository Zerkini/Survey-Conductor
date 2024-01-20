package zerkinisoft;

import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.PrintStream;

@Component
public class Window extends JPanel{

    private final JTextArea textArea;
    private SurveyManager surveyManager;

    public Window() throws HeadlessException {
        super(new GridBagLayout());
        textArea = new JTextArea(20, 100);
        textArea.setEditable(false);
        CustomOutputStream customOutputStream = new CustomOutputStream(textArea);
        PrintStream printStream = new PrintStream(customOutputStream);
        System.setOut(printStream);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JTextField textField = new JTextField("Twoja odpowiedź", 50);
        JScrollPane scrollPane2 = new JScrollPane(textField);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(scrollPane, gridBagConstraints);
        add(scrollPane2, gridBagConstraints);
        JButton nextQuestionButton = new JButton("Zatwierdź");
        add(nextQuestionButton, gridBagConstraints);

        JFrame frame = new JFrame("Badanie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);

        nextQuestionButton.addActionListener(evt -> {
            try {
                textArea.getDocument().remove(0,
                        textArea.getDocument().getLength());
                surveyManager.receiveAnswer(textField.getText());
                textField.setText("");
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
    }

    void setSurveyManager(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }
}
