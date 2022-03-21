package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Formula1ChampionshipManager implements interfaceChampionshipManager {

    protected int inputNumber;
    protected String Answer;
    protected int DriverID = 0;
    protected int TeamID = 0;
    protected int Input=0;
    protected int RacesCompleted = 0;

    protected ArrayList<Integer> DecoyTotalPoints = new ArrayList<>();
    protected ArrayList<Integer> DecoyDriverFirstPositions = new ArrayList<>();

    //Formula1ChampionshipManager Creating Menu Based Text Input

    public void menu(){
        System.out.println(("""
                        _ _ _ _ _ _ _              _ _\040
                      /             /            /    /
                     /     _ _ _ _ /            /    /
                    /    /_ _ _ _              /    /
                   /            /             /    /
                  /      _ _ _ /             /    /
                 /     /                    /    /
                /     /_ _ _ _ _ _ _ _ _ _ /    /\040
                """).indent(11));

        System.out.println("---------------------------------------------------");
        System.out.println("(1) Create A New Driver");
        System.out.println("---------------------------------------------------");
        System.out.println("(2) Delete A Driver And The Team");
        System.out.println("---------------------------------------------------");
        System.out.println("(3) Change The Driver");
        System.out.println("---------------------------------------------------");
        System.out.println("(4) Generate Detailed Statistics Of A Driver");
        System.out.println("---------------------------------------------------");
        System.out.println("(5) Display Driver Table");
        System.out.println("---------------------------------------------------");
        System.out.println("(6) Add A Completed Race");
        System.out.println("---------------------------------------------------");
        System.out.println("(7) Save Details In To A File");
        System.out.println("---------------------------------------------------");
        System.out.println("(8) Exit Program");
        System.out.println("---------------------------------------------------");
        System.out.println("(9) Open GUI");
        System.out.println("---------------------------------------------------");
        System.out.println("Enter Your Choice (E.g.-'1')...");

        //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
        Scanner ConsoleInput = new Scanner(System.in);
        try {
            inputNumber = ConsoleInput.nextInt();
        }
        catch (Exception integer){
            System.out.println("--------------------------Please Select A Correct Value From Given Numbers--------------------------");
            menu();
        }

        //Validating users input and giving them correct selected task
        if (inputNumber == 1){
            System.out.println("---------------------------------");
            System.out.println("Welcome To Create Your Own Driver");
            System.out.println("---------------------------------");
            CreateDriver();
        }
        else if (inputNumber == 2) {
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            } else {
                DeleteDriver();
            }
        }
        else if (inputNumber == 3) {
            //Checking available drivers and if not a single driver is created informing user that at least one driver is needed to run this task
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            } else {
                System.out.println("-------------------------------");
                System.out.println("Current Drivers And Their Teams");
                System.out.println("-------------------------------");
                ChangeDriver();
            }
        }
        else if (inputNumber == 4) {
            //Checking available drivers and if not a single driver is created informing user that at least one driver is needed to run this task
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            } else {
                DriverStatics();
            }
        }
        else if (inputNumber == 5) {
            //Checking available drivers and if not a single driver is created informing user that at least one driver is needed to run this task
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            } else {
                DriverTable();
            }
        }
        else if (inputNumber == 6) {
            //Checking available drivers and if not a single driver is created informing user that at least one driver is needed to run this task
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            }
            else {
                addCompleteRace();
            }
        }
        else if (inputNumber == 7) {
            //Checking available drivers and if not a single driver is created informing user that at least one driver is needed to run this task
            if (Driver.Id == 0) {
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                System.out.println("*************************|No Drivers Available Please Create A New Driver First|*************************\n");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                menu();
            }
            else {
                saveData();
            }
        }
        else if (inputNumber == 8){
            System.exit(0);
        }
        else if (inputNumber == 9){
            F1_GUI GUI = new F1_GUI();
            GUI.SetupGUI();
            saveData();
        }

        //Start from where it ended
    }

    //Connecting Formula1Driver class to this class
    Formula1Driver Driver = new Formula1Driver();

    //Method to create drivers
    public void CreateDriver(){
            //Asking for users inputs
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Your Drivers Name");
            String DriverName = input.nextLine().toUpperCase();
            Driver.setName(DriverName);
            Driver.DName.add(Driver.Id, Driver.getName());
            Driver.DTeam.add(Driver.Id,"Decoy");//Making Driver team automatically fill with a temp value when drivers name is added to bypass null errors when checking for existing teams.
            Driver.DriverFirstPositions.add(Driver.Id, 0);//Making DriverFirstPosition automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.
            DecoyDriverFirstPositions.add(Driver.Id, 0);//Making DecoyDriverFirstPosition automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.
            Driver.DriverSecondPositions.add(Driver.Id, 0);//Making DriverSecondPosition automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.
            Driver.DriverThirdPositions.add(Driver.Id, 0);//Making DriverThirdPosition automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.
            Driver.TotalPoints.add(Driver.Id, 0);//Making DriverTotalPoints automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.
            DecoyTotalPoints.add(Driver.Id, 0);//Making DecoyTotalPoints automatically fill with a temp value when drivers name is added to bypass null errors when generating driver table.

            Scanner input2 = new Scanner(System.in);
            System.out.println("Enter Your Drivers Location");
            String DriverLocation = input2.nextLine().toUpperCase();
            Driver.setLocation(DriverLocation);
            Driver.DLocation.add(Driver.Id, Driver.getLocation());

            Scanner input3 = new Scanner(System.in);
            System.out.println("Enter The Team Your Driver Belongs To");
            String DriverTeamName = input3.nextLine().toUpperCase();

            //Checking if user entered team name is already existing name or not
            for (int i =0; i < Driver.Id;){
                String Decoy = Driver.DTeam.get(i);
                if (Decoy.contains(DriverTeamName)) {
                    Scanner input4 = new Scanner(System.in);
                    System.out.println("*************************|Team You Entered Is Already Exist Please Enter New Team|*************************");
                    System.out.println("To Enter New Team Press 'Y' Or Enter '999' To Exit");
                    String choice = input4.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        Driver.DName.remove(Driver.Id);
                        Driver.DLocation.remove(Driver.Id);
                        CreateDriver();
                    }
                    else{menu();}
                }
                i++;
            }
            Driver.setTeamName(DriverTeamName);
            Driver.DTeam.set(Driver.Id, Driver.getTeamName());

            //Giving user a summary of details what they entered
            System.out.println("-----------------------------------------");
            System.out.println("Your Desired Driver Successfully Created ");
            System.out.println("-----------------------------------------");
            System.out.println("Name - "+Driver.getName()+"\n"+
                    "Location - "+Driver.getLocation()+"\n"+
                    "Team - "+Driver.getTeamName());
            Driver.Id++;

            Relaunch();
        }

        //Method to relaunch the create driver method if user chooses to add new driver again
        public void Relaunch(){

            System.out.println("--------------------------------------");
            System.out.println("Do You Want To Create Another Driver ?");
            System.out.println("--------------------------------------");
            Scanner input4 = new Scanner(System.in);
            System.out.println("If 'Yes' Press 'Y' | If 'No' Press 'N'");
            Answer = input4.next();
            //validating users answer and if a wring input entered informing user to input correct value.
            if (Answer.equalsIgnoreCase("Y")){
                CreateDriver();
            }
            else{
                menu();
            }
        }

        //Method to display all driver details
        public void DriverDetails(){
            System.out.println("-------------------Driver Details-------------------");

            for (int i=0; i < Driver.Id;) {
                System.out.println(i + ". " + "Driver Name - " + Driver.DName.get(i));
                System.out.println("   Driver Location - " + Driver.DLocation.get(i));
                System.out.println("   Driver Team - " + Driver.DTeam.get(i) + "   (Driver ID - " + i + ")\n");
                i++;
            }
    }

        //Method to delete existing drivers
        public void DeleteDriver(){


            DriverDetails();
            Scanner Id = new Scanner(System.in);
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Enter The Driver Id You Wish To Delete (E.g. - '1') Or Enter '999' To Exit");
            System.out.println("--------------------------------------------------------------------------");
            //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
            try {
                Input = Id.nextInt();
            }
            catch (Exception integer){
                System.out.println("*************************|Please Select A Correct ID Value (E.g. - '1')|*************************\n");
                DeleteDriver();
            }
            //checking if user want to continue or user wants to quit
            if (Input == 999) {
                menu();
            }
            //checking if entered driver id is valid or not
            else if (Input < Driver.Id) {
                String temp;
                temp = Driver.DName.get(Input);//Storing name of the driver user deleting to a temp variable for future use
                Driver.DName.remove(Input);//remove driver name
                Driver.DLocation.remove(Input);//remove driver location
                Driver.DTeam.remove(Input);//remove driver team
                Driver.DriverFirstPositions.remove(Input);//remove driver first positions
                Driver.DriverSecondPositions.remove(Input);//remove driver Second positions
                Driver.DriverThirdPositions.remove(Input);//remove driver third positions
                Driver.TotalPoints.remove(Input);//remove driver total points
                Driver.Id = Driver.Id - 1;// decreasing array count size by one to keep every for loops in the program functioning without any errors.
                System.out.println("Driver ID "+Input);
                System.out.println("Name - "+temp+" "+"Successfully Removed\n");
            }
            else {
                System.out.println("*************************|Enter A Valid Driver Id Number|*************************\n");
                DeleteDriver();
            }
        //Asking if users want to delete another driver and validating their input
        System.out.println("--------------------------------------");
        System.out.println("Do You Want To Delete A Another Driver");
        System.out.println("--------------------------------------");
        Scanner Input = new Scanner(System.in);
        System.out.println("If Yes Enter 'Y' Or Enter 'N' To Exit");
        String Decision = Input.nextLine();
        if (Decision.equalsIgnoreCase("Y")){
            DeleteDriver();
        }
        else{
            menu();
        }
    }

    //method to change drivers
    public void ChangeDriver() {

            //showing all driver details for users to get clear idea about the drivers and teams
            DriverDetails();

                Scanner Name = new Scanner(System.in);
                System.out.println("Enter The Driver ID You Wish To Change For An Existing Team Or Enter '999' To Exit");
                //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
                try {
                    DriverID = Name.nextInt();
                } catch (Exception integer) {
                    System.out.println("*************************|Please Select A Correct ID Value (E.g. - '1')|*************************\n");
                    ChangeDriver();
                }
                //checking if user want to continue or user wants to quit
                if (DriverID == 999) {
                    menu();
                }
                //Showing available teams to change the selected driver
                else if (DriverID < Driver.Id){
                    System.out.println("---------------------------------------------------");
                    System.out.println("Available Teams To Change Drivers\n");
                    System.out.println("---------------------------------------------------");
                    for (int i = 0; i < Driver.Id; i++) {
                        //bypassing selected drivers existing team and showing other teams
                        if (i == DriverID) {
                            continue;
                        }
                        System.out.println(Driver.DTeam.get(i) + "(Team ID - " + i + ")");
                    }
                    //calling select team change method to swap and change the selected drivers and their teams
                    SelectTeamChange();
                }
                else {
                    System.out.println("*************************|Enter A Valid Team Id Number|*************************\n");
                    ChangeDriver();
                }
            //Asking if user wants to change another drivers team
            System.out.println("--------------------------------------------------------");
            System.out.println("Do You Want To Change Another Driver To A Different Team");
            System.out.println("--------------------------------------------------------");
            Scanner Input = new Scanner(System.in);
            System.out.println("If Yes Enter 'Y' Or Enter 'N' To Exit");
            String Decision = Input.nextLine();
            if (Decision.equalsIgnoreCase("Y")){
                ChangeDriver();
            }
            else {
                menu();
            }
        }
    // changing teams of the selected drivers from change driver method
    public void SelectTeamChange(){

            Scanner Team = new Scanner(System.in);
            System.out.println("Enter The Team ID You Wish To Change Your Selected Driver " + Driver.DName.get(DriverID) + " To Or Enter '999' To Exit");
            //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
            try {
                TeamID = Team.nextInt();
            } catch (Exception integer) {
                System.out.println("*************************|Please Select A Correct ID Value (E.g. - '1')|*************************\n");
                SelectTeamChange();
            }
            //checking if user want to continue or user wants to quit
            if (TeamID == 999) {
                menu();
            }
            //Checking if user entered team id is valid or not
            else if (TeamID < Driver.Id){
                String temp;
                int IntTemp;
                //Swapping and changing name,location,team,positions and total points of the driver
                temp = Driver.DName.get(DriverID);
                Driver.DName.set(DriverID, Driver.DName.get(TeamID));
                Driver.DName.set(TeamID, temp);
                temp = Driver.DLocation.get(DriverID);
                Driver.DLocation.set(DriverID, Driver.DLocation.get(TeamID));
                Driver.DLocation.set(TeamID, temp);
                IntTemp = Driver.DriverFirstPositions.get(DriverID);
                Driver.DriverFirstPositions.set(DriverID, Driver.DriverFirstPositions.get(TeamID));
                Driver.DriverFirstPositions.set(TeamID, IntTemp);
                IntTemp = Driver.DriverSecondPositions.get(DriverID);
                Driver.DriverSecondPositions.set(DriverID, Driver.DriverSecondPositions.get(TeamID));
                Driver.DriverSecondPositions.set(TeamID, IntTemp);
                IntTemp = Driver.DriverThirdPositions.get(DriverID);
                Driver.DriverThirdPositions.set(DriverID, Driver.DriverThirdPositions.get(TeamID));
                Driver.DriverThirdPositions.set(TeamID, IntTemp);
                IntTemp = Driver.TotalPoints.get(DriverID);
                Driver.TotalPoints.set(DriverID, Driver.TotalPoints.get(TeamID));
                Driver.TotalPoints.set(TeamID, IntTemp);
                System.out.println("Your Desired Driver " + Driver.DName.get(TeamID) + " Successfully Changed To Team " + Driver.DTeam.get(TeamID));
                DriverDetails();
            }
            else {
                System.out.println("*************************|Enter A Valid Id Number|*************************\n");
                SelectTeamChange();
            }
        }

        //Driver static method
        public void DriverStatics() {

                int SelectID = 0;
                //Displaying available driver names to view statics
                System.out.println("-------------------|Available Drivers|-------------------");
                for (int i = 0; i < Driver.Id; i++) {
                    System.out.println(i + ". " + Driver.DName.get(i));
                    System.out.println("(Driver ID - " + i + ")");
                }
                System.out.println("Select Driver ID You Wish To Display Statistics Or Enter '999' To Exit");
                Scanner Input = new Scanner(System.in);
                //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
                try {
                    SelectID = Input.nextInt();
                } catch (Exception integer) {
                    System.out.println("*************************|Please Select A Correct ID Value (E.g. - '1')|*************************\n");
                    DriverStatics();
                }
                //Checking if user wants to quit
                if (SelectID == 999) {
                    menu();
                }
                //Checking user selected driver id is valid or not
                else if (SelectID < Driver.Id) {
                    System.out.println("Driver Name - " + Driver.DName.get(SelectID));
                    System.out.println("Driver Location - " + Driver.DLocation.get(SelectID));
                    System.out.println("Driver Team - " + Driver.DTeam.get(SelectID));
                    System.out.println("First Positions - " + Driver.DriverFirstPositions.get(SelectID));
                    System.out.println("Second Positions - " + Driver.DriverSecondPositions.get(SelectID));
                    System.out.println("Third Positions - " + Driver.DriverThirdPositions.get(SelectID));
                    System.out.println("Total Points - " + Driver.TotalPoints.get(SelectID));
                    System.out.println("(Driver ID - " + SelectID + ")");
                } else {
                    System.out.println("*************************|Enter A Valid Id Number|*************************\n");
                    DriverStatics();
                }

                System.out.println("------------------------------------------------");
                System.out.println("Do You Want To View Statics For A Another Driver");
                System.out.println("------------------------------------------------");
                Scanner Input2 = new Scanner(System.in);
                System.out.println("If Yes Enter 'Y' Or Enter 'N' To Exit");
                String Decision = Input2.nextLine();
                if (Decision.equalsIgnoreCase("Y")) {
                    DriverStatics();
                } else {
                    menu();
                }
        }

        //Method Driver Table
        public void DriverTable() {

            //Creating table header and selecting format of the table
            String leftAlignFormat = "| %-15s | %-16s | %-18d | %-18d | %-18d | %-15d | %-13d | %n";

            System.out.format("+-----------------+------------------+--------------------+--------------------+--------------------+-----------------+---------------+%n");
            System.out.format("|  Driver Name    |      Team        |   First Positions  |   Second Positions |   Third Positions  |  Total Points   |  Total Races  |%n");
            System.out.format("+-----------------+------------------+--------------------+--------------------+--------------------+-----------------+---------------+%n");

            int tempId;
            tempId = Driver.Id;

            //Copying all Total Points and Driver First position data to a decoy arrays
            for (int copy = 0; copy < tempId;){

                DecoyTotalPoints.set(copy, Driver.TotalPoints.get(copy));
                DecoyDriverFirstPositions.set(copy, Driver.getDriverFirstPositions().get(copy));
                copy++;
            }

            int max = DecoyTotalPoints.get(0);
            int loop = 0;
            int higherFirstPositionCount;
           //loop to find all maximum values
           while (loop < tempId) {
               //checking what's the max value
                for (int i = 0; i < tempId;) {

                        if (DecoyTotalPoints.get(i) > max) {
                            max = DecoyTotalPoints.get(i);//Adding max value to variable max
                        }
                        i++;
                }
                int maxIndexCount;
                maxIndexCount = DecoyTotalPoints.indexOf(max);//adding index of max value in decoy total points array to maxIndexCount variable

               //Checking if total points array have equal points to max vale
               for (int j = 0; j < tempId;) {
                   if (j != maxIndexCount) {
                           if (Objects.equals(DecoyTotalPoints.get(j), max)) {
                               // if any equal max value found getting bigger number out of these equal values by checking which value has more first positions
                               if (DecoyDriverFirstPositions.get(j) > DecoyDriverFirstPositions.get(maxIndexCount)) {
                                   max = DecoyTotalPoints.get(j);//making value with more first positions max value
                                   higherFirstPositionCount = j;
                                   maxIndexCount = higherFirstPositionCount;
                               }
                           }
                   }

                   j++;
               }
               maxIndexCount = DecoyTotalPoints.indexOf(max);//adding index of max value in decoy total points array to maxIndexCount variable

               System.out.format(leftAlignFormat, Driver.DName.get(maxIndexCount), Driver.DTeam.get(maxIndexCount), Driver.DriverFirstPositions.get(maxIndexCount), Driver.DriverSecondPositions.get(maxIndexCount), Driver.DriverThirdPositions.get(maxIndexCount), Driver.TotalPoints.get(maxIndexCount), Driver.totalRaces);
               //making found max value to 0
               DecoyTotalPoints.set(maxIndexCount, 0);
               max = DecoyTotalPoints.get(0);

            loop++;

            }

            System.out.format("+-----------------+------------------+--------------------+--------------------+--------------------+-----------------+---------------+%n");

           Scanner input = new Scanner(System.in);
           System.out.println("To Go Back To Menu Enter 'M' Or Press '999' To Exit Application");
           String menu = input.nextLine();
           if (menu.equalsIgnoreCase("M")){
               menu();
           }
           else{
               System.exit(0);
           }
        }

        //Method to add complete race
        public void addCompleteRace() {


                String Date;
                int Position = 0;

                Scanner Input = new Scanner(System.in);
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Enter 'S' To Start The Process Of Entering A Finished Race Or Press '999' To Exit");
                System.out.println("---------------------------------------------------------------------------------");
                String Decision = Input.nextLine();
                //Checking id user wants to start adding race or user wants to quit
                if (Decision.equalsIgnoreCase("S")) {
                    Scanner input1 = new Scanner(System.in);
                    System.out.println("---------------------------------------------");
                    System.out.println("Enter Race Completed Date " + " " + "(DD-MM-YYYY)");
                    System.out.println("---------------------------------------------");
                    Date = input1.nextLine();
                    Driver.RaceDate.add(RacesCompleted, Date);
                    //displaying drivers one by one and asking for their positions
                    for (int i = 0; i < Driver.Id; ) {
                        Driver.setDriverId(i);
                        Scanner input2 = new Scanner(System.in);
                        System.out.println(i + ". " + "Driver Name - " + Driver.DName.get(i));
                        System.out.println("   Driver Location - " + Driver.DLocation.get(i));
                        System.out.println("   Driver Team - " + Driver.DTeam.get(i) + "   (Driver ID - " + i + ")");
                        System.out.println("Enter The Position This Driver Achieved (1 - 10)");
                        //Asking user to enter a correct integer value and giving them a custom error message if user enters wrong value
                        try {
                            Position = input2.nextInt();
                        } catch (Exception integer) {
                            System.out.println("*************************|Please Enter A Correct Position Value (E.g. - (1 - 10))|*************************\n");
                            addCompleteRace();
                        }
                        //Sending each driver position to Formula1 Driver class to calculate points
                        Driver.setRacePosition(Position);
                        i++;
                    }
                    System.out.println("-------------------------------");
                    System.out.println("Race Results Successfully Added");
                    System.out.println("-------------------------------\n");
                    RacesCompleted++;
                    Driver.totalRaces++;
                    System.out.println("----------------------------------------");
                    System.out.println("Do You Want To Add Another Complete Race");
                    System.out.println("----------------------------------------");
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("If Yes Enter 'Y' Or Enter 'N' To Exit");
                    String Decision1 = input3.nextLine();
                    if (Decision1.equalsIgnoreCase("Y")) {
                        addCompleteRace();
                    } else {
                        menu();
                    }

                } else {
                    menu();
                }
        }

        //Method to save data to a file
        public void saveData(){

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
            while (Count < Driver.Id) {
                saveData.append(String.valueOf(Count));
                saveData.append(",");
                saveData.append(Driver.DName.get(Count));
                saveData.append(",");
                saveData.append(Driver.DLocation.get(Count));
                saveData.append(",");
                saveData.append(Driver.DTeam.get(Count));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.DriverFirstPositions.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.DriverSecondPositions.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.DriverThirdPositions.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.TotalPoints.get(Count)));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.totalRaces));
                saveData.append(",");
                saveData.append(String.valueOf(Driver.Id));
                saveData.append("\n");

                saveData.write("");

                Count++;
            }
            //After saving all data to the file closing it
            saveData.close();

            System.out.println("Successfully Exported");
            menu();
        }
        //if file not created prompting user with  error message
        catch (Exception FailedFile){
                System.out.println("File Not Created Try Again");
                System.out.println("Failed To Save To File 'Driver_And_Race Details.csv'");
                menu();

        }
        }

        //Method to load data from a file
        public void loadData(){

        String line;
        int startLine = 1;
        int Counter = startLine;
        int Index;

        //Try to open selected file
        try{
            BufferedReader readData = new BufferedReader(new FileReader("Driver_And_Race Details.csv"));
            //reading all data on the file until lines become null
            while ((line = readData.readLine()) != null){
                String[] Data = line.split(",");//Storing first line of the file to  array
                //Storing all data in the same order data saved in to the same position
                if (Counter > startLine) {

                        Index = Integer.parseInt(Data[0]);
                        Driver.DName.add(Index, Data[1]);
                        Driver.DLocation.add(Index, Data[2]);
                        Driver.DTeam.add(Index, Data[3]);
                        Driver.DriverFirstPositions.add(Index, Integer.parseInt(Data[4]));
                        DecoyDriverFirstPositions.add(Index, Integer.parseInt(Data[4]));
                        Driver.DriverSecondPositions.add(Index, Integer.parseInt(Data[5]));
                        Driver.DriverThirdPositions.add(Index, Integer.parseInt(Data[6]));
                        Driver.TotalPoints.add(Index, Integer.parseInt(Data[7]));
                        DecoyTotalPoints.add(Index, Integer.parseInt(Data[7]));
                        Driver.totalRaces = Integer.parseInt(Data[8]);
                        Driver.Id = Integer.parseInt(Data[9]);

                }
                Counter++;
            }
        }
        //prompting error message to user if file failed to open
        catch (Exception FileNotFound){
            System.out.println("File Not Found, Create A New File And Try Again");
            menu();
        }
        }

    public static void main(String[] args) {
        Formula1ChampionshipManager Manager = new Formula1ChampionshipManager();
        Manager.loadData();//Reading Data From Saved File To Resume Program
        Manager.menu();//Calling Menu
    }

}









