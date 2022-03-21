package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import java.util.*;

public abstract class Driver {
    private String Name;
    private String Location;
    private String TeamName;
    protected int Id = 0;
    protected int totalRaces = 0;
    protected ArrayList<String> DName = new ArrayList<>();
    protected ArrayList<String> DLocation = new ArrayList<>();
    protected ArrayList<String> DTeam = new ArrayList<>();

    //Getting Drivers Name
    protected String getName() {
        return this.Name;
    }
    //Setting Drivers Name
    protected void setName(String name) {
        this.Name = name;
    }
    //Getting Drivers Location
    protected String getLocation() {
        return this.Location;
    }
    //Setting Drivers Location
    protected void setLocation(String location) {
        this.Location = location;
    }
    //Getting Drivers teamName
    protected String getTeamName() {
        return this.TeamName;
    }
    //Setting Drivers teamName
    protected void setTeamName(String teamName) {
        this.TeamName = teamName;
    }

}
