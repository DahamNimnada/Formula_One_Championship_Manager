package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

import static java.awt.Font.CENTER_BASELINE;

public class JTable {
    protected DefaultTableModel csv = new DefaultTableModel();
    protected ArrayList<Integer> TD = new ArrayList<>();//Driver id arraylist
    protected ArrayList<String> JName = new ArrayList<>();//Driver name arraylist
    protected ArrayList<String> Location = new ArrayList<>();//Driver location arraylist
    protected ArrayList<String> Team = new ArrayList<>();//Driver team arraylist
    protected ArrayList<Integer> First = new ArrayList<>();//Total First positions arraylist
    protected ArrayList<Integer> Second = new ArrayList<>();//Total Second positions arraylist
    protected ArrayList<Integer> Third = new ArrayList<>();//Total Third positions arraylist
    protected ArrayList<Integer> TP = new ArrayList<>();//Total races arraylist
    protected int ID = 0;
    protected int TR = 0;
    protected int tempId;
    protected int FirstPositions;
    protected int SecondPositions;
    protected int ThirdPositions;
    protected int noPoints;
    private final JFrame frame;
    private final javax.swing.JTable jTable;
    private final JButton GoToMenu;
    private final JButton SortPoints;
    private final JButton SortPositions;
    private final JButton Exit;

    public JTable() {

        frame = new JFrame();
        jTable = new javax.swing.JTable();
        GoToMenu = new JButton("Go Back To Menu");
        SortPoints = new JButton("Sort Points");
        SortPositions = new JButton("Sort Positions");
        Exit = new JButton("Exit Application");
    }
    //Setting up GUI
    public void SetupGUI() {
        ReadData();
        SortData();
        Container pane = frame.getContentPane();
        BoxLayout Box = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(Box);
        frame.setSize(1500, 500);
        frame.setTitle("Formula 01 Driver Table");
        jTable.setModel(csv);
        jTable.setGridColor(Color.BLACK);
        jTable.isFocusable();
        jTable.setRowHeight(25);
        jTable.getTableHeader().setOpaque(false);
        jTable.getTableHeader().setBackground(new Color(117, 0, 39));
        jTable.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable.setFont(new Font("Helvetica", CENTER_BASELINE, 12));
        jTable.getTableHeader().setFont((new Font("Helvetica", CENTER_BASELINE, 14)));
        JScrollPane Scroll = new JScrollPane();
        Scroll.getViewport().add(jTable);
        pane.add(Scroll);
        pane.add(SortPoints);
        pane.add(SortPositions);
        pane.add(GoToMenu);
        pane.add(Exit);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SetupButtonListeners();
    }
//Closing This GUI When Opening New GUI
    public void Close() {
        WindowEvent CloseWindow = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(CloseWindow);
    }

    public void ReadData() {
        String line;
        int Index;
        int startLine = 1;
        int Counter = startLine;
        try {
            BufferedReader readData = new BufferedReader(new FileReader("Driver_And_Race Details.csv"));

            //reading all data on the file until lines become null
            while ((line = readData.readLine()) != null) {
                String[] Data = line.split(",");//Storing first line of the file to  array
                //Storing all data in the same order data saved in to the same position
                if (Counter > startLine) {
                    Index = Integer.parseInt(Data[0]);
                    JName.add(Index, Data[1]);
                    Location.add(Index, Data[2]);
                    Team.add(Index, Data[3]);
                    First.add(Index, Integer.parseInt(Data[4]));
                    Second.add(Index, Integer.parseInt(Data[5]));
                    Third.add(Index, Integer.parseInt(Data[6]));
                    TP.add(Index, Integer.parseInt(Data[7]));
                    TR = Integer.parseInt(Data[8]);
                    TD.add(Index, Integer.parseInt(Data[9]));
                    ID = Integer.parseInt(Data[9]);
                    tempId = Integer.parseInt(Data[9]);
                }

                Counter++;
            }
        } catch (Exception exception) {
            System.out.println("Error Opening File");
        }
    }

    public void SortData() {

        ArrayList<Integer> DecoyTotalPoints = new ArrayList<>();
        //ArrayList<Integer> DecoyDriverFirstPositions = new ArrayList<>();

        //Copying all Total Points and Driver First position data to a decoy arrays
        for (int copy = 0; copy < tempId; ) {

            DecoyTotalPoints.add(copy, TP.get(copy));
            //DecoyDriverFirstPositions.add(copy, TR.get(copy));
            copy++;
        }

        int minimum = DecoyTotalPoints.get(0);
        int loop = 0;
        int minIndexCount;

        //loop to find all minimum values
        while (loop < tempId) {
            //checking what's the min value
            for (int i = 0; i < tempId; ) {

                    if (DecoyTotalPoints.get(i) < minimum) {
                        minimum = DecoyTotalPoints.get(i);//Adding min value to variable min
                    }
                    i++;
                }

            minIndexCount = DecoyTotalPoints.indexOf(minimum);//adding index of min value in decoy total points array to minIndexCount variable
//Adding Above read data to JTable
               if (loop ==0) {
                   //Columns
                   csv.addColumn("Name");
                   csv.addColumn("Location");
                   csv.addColumn("Team");
                   csv.addColumn("First Positions");
                   csv.addColumn("Second Positions");
                   csv.addColumn("Third Positions");
                   csv.addColumn("Total Points");
                   csv.addColumn("Total Races");
                   csv.addColumn("Drivers Participated");
               }
               //Rows
                    Vector <String> row = new Vector<>();
                    row.add(JName.get(minIndexCount));
                    row.add(Location.get(minIndexCount));
                    row.add(Team.get(minIndexCount));
                    row.add(String.valueOf(First.get(minIndexCount)));
                    row.add(String.valueOf(Second.get(minIndexCount)));
                    row.add(String.valueOf(Third.get(minIndexCount)));
                    row.add(String.valueOf(TP.get(minIndexCount)));
                    row.add(String.valueOf(TR));
                    row.add(String.valueOf(TD.get(minIndexCount)));
                    csv.addRow(row);

            DecoyTotalPoints.set(minIndexCount, 9999);
            minimum = DecoyTotalPoints.get(0);
            loop++;
            }

        }

    public void SortDataUP() {

        ArrayList<Integer> DecoyTotalPoints = new ArrayList<>();
        //ArrayList<Integer> DecoyDriverFirstPositions = new ArrayList<>();

        //Copying all Total Points and Driver First position data to a decoy arrays
        for (int copy = 0; copy < tempId; ) {

            DecoyTotalPoints.add(copy, TP.get(copy));
            //DecoyDriverFirstPositions.add(copy, TR.get(copy));
            copy++;
        }

        int max = DecoyTotalPoints.get(0);
        int loop = 0;
        int maxIndexCount;

        //loop to find all minimum values
        while (loop < tempId) {
            //checking what's the max value
            for (int i = 0; i < tempId; ) {

                if (DecoyTotalPoints.get(i) > max) {
                    max = DecoyTotalPoints.get(i);//Adding max value to variable min
                }
                i++;
            }

            maxIndexCount = DecoyTotalPoints.indexOf(max);//adding index of max value in decoy total points array to maxIndexCount variable
//Adding Above read data to JTable
            if (loop ==0) {
                //Columns
                csv.addColumn("Name");
                csv.addColumn("Location");
                csv.addColumn("Team");
                csv.addColumn("First Positions");
                csv.addColumn("Second Positions");
                csv.addColumn("Third Positions");
                csv.addColumn("Total Points");
                csv.addColumn("Total Races");
                csv.addColumn("Drivers Participated");
            }
            //Rows
            Vector <String> row = new Vector<>();
            row.add(JName.get(maxIndexCount));
            row.add(Location.get(maxIndexCount));
            row.add(Team.get(maxIndexCount));
            row.add(String.valueOf(First.get(maxIndexCount)));
            row.add(String.valueOf(Second.get(maxIndexCount)));
            row.add(String.valueOf(Third.get(maxIndexCount)));
            row.add(String.valueOf(TP.get(maxIndexCount)));
            row.add(String.valueOf(TR));
            row.add(String.valueOf(TD.get(maxIndexCount)));
            csv.addRow(row);

            DecoyTotalPoints.set(maxIndexCount, 0);
            max = DecoyTotalPoints.get(0);
            loop++;
        }

    }

    public void SortPositions() {

        ArrayList<Integer> DecoyDriverFirstPositions = new ArrayList<>();

        //Copying all Driver First position data to a decoy arrays
        for (int copy = 0; copy < tempId; ) {
            DecoyDriverFirstPositions.add(copy, First.get(copy));
            copy++;
        }

        int max = DecoyDriverFirstPositions.get(0);
        int loop = 0;
        int maxIndexCount;

        //loop to find all minimum values
        while (loop < tempId) {
            //checking what's the max value
            for (int i = 0; i < tempId; ) {
                    if (DecoyDriverFirstPositions.get(i) > max) {
                        max = DecoyDriverFirstPositions.get(i);//Adding max value to variable min
                    }
                i++;
            }

            maxIndexCount = DecoyDriverFirstPositions.indexOf(max);//adding index of max value in decoy total points array to maxIndexCount variable
//Adding Above read data to JTable
            //Columns
            if (loop ==0) {
                csv.addColumn("Name");
                csv.addColumn("Location");
                csv.addColumn("Team");
                csv.addColumn("First Positions");
                csv.addColumn("Second Positions");
                csv.addColumn("Third Positions");
                csv.addColumn("Total Points");
                csv.addColumn("Total Races");
                csv.addColumn("Drivers Participated");
            }
            //Rows
            Vector <String> row = new Vector<>();
            row.add(JName.get(maxIndexCount));
            row.add(Location.get(maxIndexCount));
            row.add(Team.get(maxIndexCount));
            row.add(String.valueOf(First.get(maxIndexCount)));
            row.add(String.valueOf(Second.get(maxIndexCount)));
            row.add(String.valueOf(Third.get(maxIndexCount)));
            row.add(String.valueOf(TP.get(maxIndexCount)));
            row.add(String.valueOf(TR));
            row.add(String.valueOf(TD.get(maxIndexCount)));
            csv.addRow(row);

            DecoyDriverFirstPositions.set(maxIndexCount, 0);
            max = DecoyDriverFirstPositions.get(0);
            loop++;
        }

    }

        public void Remove(){
        csv = (DefaultTableModel)jTable.getModel();
        //Clear all the column name on jTable
        csv.setColumnCount(0);

        csv.getDataVector().removeAllElements();
        csv.fireTableDataChanged();// notifies the JTable that the model has changed
        }
    //Adding Action Listeners To Buttons
        public void SetupButtonListeners () {
            ActionListener ButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Object i = ae.getSource();
                    if (i == GoToMenu) {
                        Close();
                        F1_GUI GUI = new F1_GUI();
                        GUI.SetupGUI();
                    }
                    else  if (i == SortPoints){
                        Remove();
                        SortDataUP();
                    }
                    else if (i == SortPositions){
                        Remove();
                        SortPositions();
                    }
                    else if (i == Exit){
                        System.exit(0);
                    }
                }
            };

            GoToMenu.addActionListener(ButtonListener);
            SortPoints.addActionListener(ButtonListener);
            SortPositions.addActionListener(ButtonListener);
            Exit.addActionListener(ButtonListener);
        }
    //Main Method
        public static void main (String[]args){
            JTable Table = new JTable();
            Table.SetupGUI();
        }
    }