package com.psychosurvey;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
