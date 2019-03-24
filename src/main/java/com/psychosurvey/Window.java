package com.psychosurvey;

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

    private JTextArea textArea;
    private static JFrame frame;
    private CustomOutputStream customOutputStream;
    private JButton nextQuestionButton = new JButton("Zatwierdź");
    private SurveyManager surveyManager;

    public Window() throws HeadlessException {
        super(new GridBagLayout());
        textArea = new JTextArea(20, 100);
        textArea.setEditable(false);
        customOutputStream = new CustomOutputStream(textArea);
        PrintStream printStream = new PrintStream(customOutputStream);
        System.setOut(printStream);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JTextField textField = new JTextField("Twoja odpowiedź", 50);
        JScrollPane scrollPane2 = new JScrollPane(textField);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(scrollPane, gridBagConstraints);
        add(scrollPane2, gridBagConstraints);
        add(nextQuestionButton, gridBagConstraints);

        frame = new JFrame("TextDemo");
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

    public void setSurveyManager(SurveyManager surveyManager) {
        this.surveyManager = surveyManager;
    }
}
