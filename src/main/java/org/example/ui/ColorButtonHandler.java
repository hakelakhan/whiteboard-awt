package org.example.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonHandler implements ActionListener {

    private Color color;

    public ColorButtonHandler(Color color) {
        this.color = color;
    }

    WhiteBoardData whiteBoardData = WhiteBoardData.getInstance();
    @Override
    public void actionPerformed(ActionEvent e) {
        WhiteBoardData.setCurrentColor(this.color);


    }
}
