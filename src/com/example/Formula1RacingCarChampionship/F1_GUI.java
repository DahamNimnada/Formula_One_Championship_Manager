package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class F1_GUI {
    private final JFrame frame;
    private final JButton Table;
    private final JButton GenerateRace;
    private final JButton FullRace;
    private final JButton ViewDates;
    private final JButton SearchDriver;

    public F1_GUI(){
        frame = new JFrame();
        Table = new JButton("Generate Driver Table");
        GenerateRace = new JButton("Generate Race");
        FullRace = new JButton("Generate Full Race");
        ViewDates = new JButton("View Dates");
        SearchDriver = new JButton("Search Driver");
    }
    //Setting up GUI
    public void SetupGUI(){
        Container pane = frame.getContentPane();
        GridLayout Grid = new GridLayout(5,1);
        pane.setLayout(Grid);
        frame.setSize(500,500);
        frame.setTitle("Formula 01 Championship GUI");
        pane.add(Table);
        pane.add(GenerateRace);
        pane.add(FullRace);
        pane.add(ViewDates);
        pane.add(SearchDriver);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        SetupButtonListeners();
    }
    //Closing This GUI When Opening New GUI
    public void Close(){
        WindowEvent CloseWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(CloseWindow);
    }
//Adding Action Listeners To Buttons
    public void SetupButtonListeners(){
        ActionListener ButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object i = ae.getSource();
                if (i == Table) {
                    Close();
                    JTable Table = new JTable();
                    Table.SetupGUI();
                }
                else if (i == GenerateRace) {
                    GenerateRace Race = new GenerateRace();
                    Race.RandomNumber();
                    Race.SetUpGUI();
                }
                else if (i == FullRace) {
                    System.out.println("Full Race");
                }
                else if (i == ViewDates) {
                    System.out.println("Dates");
                }
                else if (i == SearchDriver) {
                    System.out.println("Search Driver");
                }
            }
        };

        Table.addActionListener(ButtonListener);
        GenerateRace.addActionListener(ButtonListener);
        FullRace.addActionListener(ButtonListener);
        ViewDates.addActionListener(ButtonListener);
        SearchDriver.addActionListener(ButtonListener);
    }
//Main Method
    public static void main(String[] args) {
        F1_GUI GUI = new F1_GUI();
        GUI.SetupGUI();
    }

}
