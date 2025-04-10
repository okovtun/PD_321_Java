package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow extends Frame {
    Label lblLastName   = new Label("Last  name: ");
    Label lblFirstName  = new Label("First name: ");
    Label lblBirthDate  = new Label("Birth date: ");
    Label results = new Label("Results");

    TextField textLastName = new TextField();
    TextField textFirstName = new TextField();
    TextField textBirthDate = new TextField();

    public MainWindow() throws HeadlessException {

        this.setBounds(200,200,400,300);
        this.setTitle("AWT - Abstract Window Toolkit");
//        Button button = new Button("Button");
//        button.setBounds(50, 50, 100, 50);
//        add(button);


        Button btnSubmit = new Button("Submit");
        Button btnReset  = new Button("Reset");

//        lblLastName.setBounds(50, 50, 100, 32);
//        lblFirstName.setBounds(50, 100, 100, 32);
//        lblBirthDate.setBounds(50, 150, 100, 32);
//
//        textLastName.setBounds(200, 50, 100, 24);
//        textFirstName.setBounds(200, 100, 100, 24);
//        textBirthDate.setBounds(200, 150, 100, 24);
//
//        btnSubmit.setBounds(50, 200, 100, 50);
//        btnReset.setBounds(200, 200, 100, 50);

        this.add(lblLastName);
        this.add(textLastName);

        this.add(lblFirstName);
        this.add(textFirstName);

        this.add(lblBirthDate);
        this.add(textBirthDate);

        this.add(btnSubmit);
        this.add(btnReset);

        this.add(results);

        btnSubmit.addActionListener(this::btnSubmitHandler);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


        GridLayout grid = new GridLayout(5,2,10,30);
        this.setLayout(grid);
        this.setVisible(true);
    }
    public void btnSubmitHandler(ActionEvent e)
    {
        String results = textLastName.getText() + " " + textFirstName.getText() + " " + textBirthDate.getText();
        this.results.setText(results);
    }
    public void closeWindowHandler(ActionEvent e)
    {
        MainWindow mainWindow = this;
        mainWindow.dispose();
    }
}