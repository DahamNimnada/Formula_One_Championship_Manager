package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateRace {

    JTable Table = new JTable();
    private final JFrame frame;
    private final JLabel Label;
    private final JButton Button1;
    protected int number;
    protected int i;

    public GenerateRace() {
        frame = new JFrame();
        Label = new JLabel();
        Button1 = new JButton("View Table");
    }
//Setting up GUI
    public void SetUpGUI() {
        Container pane = frame.getContentPane();
        BoxLayout Box = new BoxLayout(pane, BoxLayout.X_AXIS);
        pane.setLayout(Box);
        frame.setSize(500, 500);
        Label.setText("Race Created Click On Table Button To View Results");
        Label.setHorizontalTextPosition(JLabel.CENTER);
        Label.setVerticalTextPosition(JLabel.CENTER);
        Label.setSize(300, 50);
        pane.add(Label);
        pane.add(Button1);
        frame.setTitle("Formula 01 Championship Race Created");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        SetupButtonListeners();
    }
    //Closing This GUI When Opening New GUI
    public void Close() {
        WindowEvent CloseWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(CloseWindow);
    }

    public void RandomNumber() {
        Formula1ChampionshipManager Manager = new Formula1ChampionshipManager();
        Manager.loadData();//Loading Saved Data
        Table.ReadData();//Reading Saved Data
        Random obj = new Random();
        for (i = 0; i < Table.ID; i++) {
            number = obj.nextInt(1, Table.ID);
//getting driver positions from console class and incrementing positions and the total points of each driver using switch loop
            switch (number) {
                case 1 -> {
                    Table.FirstPositions = Table.First.get(i);
                    Table.noPoints = Table.TP.get(i);
                    Table.FirstPositions++;
                    Table.noPoints = Table.noPoints + 25;
                    Table.First.set(i, Table.FirstPositions);
                    Table.TP.set(i, Table.noPoints);
                }
                case 2 -> {
                    Table.SecondPositions = Table.Second.get(i);
                    Table.noPoints = Table.TP.get(i);
                    Table.SecondPositions++;
                    Table.noPoints = Table.noPoints + 18;
                    Table.Second.set(i, Table.SecondPositions);
                    Table.TP.set(i, Table.noPoints);
                }
                case 3 -> {
                    Table.ThirdPositions = Table.Third.get(i);
                    Table.noPoints = Table.TP.get(i);
                    Table.ThirdPositions++;
                    Table.noPoints = Table.noPoints + 15;
                    Table.Third.set(i, Table.ThirdPositions);
                    Table.TP.set(i, Table.noPoints);
                }
                case 4 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 12;
                    Table.TP.set(i, Table.noPoints);
                }
                case 5 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 10;
                    Table.TP.set(i, Table.noPoints);
                }
                case 6 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 8;
                    Table.TP.set(i, Table.noPoints);
                }
                case 7 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 6;
                    Table.TP.set(i, Table.noPoints);
                }
                case 8 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 4;
                    Table.TP.set(i, Table.noPoints);
                }
                case 9 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 2;
                    Table.TP.set(i, Table.noPoints);
                }
                case 10 -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.noPoints = Table.noPoints + 1;
                    Table.TP.set(i, Table.noPoints);
                }
                default -> {
                    Table.noPoints = Table.TP.get(i);
                    Table.TP.set(i, Table.noPoints);
                }
            }
        }
        Table.TR++;

        int Count = 0;
        //Checking if file successfully created or not
        try {
            PrintWriter saveData = new PrintWriter("Driver_And_Race Details.csv");//creating file
            //Making headers of the file and creating data store format
            saveData.append("DriverId");
            saveData.append(",");
            saveData.append("Name");
            saveData.append(",");
            saveData.append("Location");
            saveData.append(",");
            saveData.append("Team");
            saveData.append(",");
            saveData.append("First Positions");
            saveData.append(",");
            saveData.append("Second Positions");
            saveData.append(",");
            saveData.append("Third Positions");
            saveData.append(",");
            saveData.append("Total Points");
            saveData.append(",");
            saveData.append("Total Races");
            saveData.append(",");
            saveData.append("Total Drivers Participated");
            saveData.append("\n");

            //Storing all the data to created file
            while (Count < Table.ID) {
                saveData.append(String.valueOf(Count));
                saveData.append(",");
                saveData.append(Table.JName.get(Count));
                saveData.append(",");
                saveData.append(Table.Location.get(Count));
                saveData.append(",");
                saveData.append(Table.Team.get(Count));
                saveData.append(",");
                saveData.append(String.valueOf(Table.First.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Table.Second.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Table.Third.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Table.TP.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Table.TR));
                saveData.append(",");
                saveData.append(String.valueOf(Table.ID));
                saveData.append("\n");

                saveData.write("");

                Count++;
            }
            //After saving all data to the file closing it
            saveData.close();

            System.out.println("Successfully Exported");
        }
        //if file not created prompting user with  error message
        catch (Exception FailedFile) {
            System.out.println("File Not Created Try Again");
            System.out.println("Failed To Save To File 'Driver_And_Race Details.csv'");

        }
    }
    //Adding Action Listeners To Buttons
    public void SetupButtonListeners() {
        ActionListener ButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object i = ae.getSource();
                if (i == Button1) {
                    Close();
                    Table.SetupGUI();
                }
            }
        };

        Button1.addActionListener(ButtonListener);
    }
    //Main Method
        public static void main (String[]args){
            GenerateRace Race = new GenerateRace();
            Race.SetUpGUI();
        }
    }
