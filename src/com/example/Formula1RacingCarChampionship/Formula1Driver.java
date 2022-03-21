package com.example.Formula1RacingCarChampionship;

/*Demuni Sithija Daham Nimnada De Silva
w1830147
20200479”I confirm that I understand what plagiarism is and have read and understood the section on Assessment Offences in the Essential Information for Students. The work that I have submitted is entirely my own. Any work from other authors is duly referenced and acknowledged.”*/

import java.util.ArrayList;

public class Formula1Driver extends Driver {
    private int FirstPositions;
    private int SecondPositions;
    private int ThirdPositions;
    private int DriverId;

    protected ArrayList<Integer> TotalPoints= new ArrayList<>();
    protected ArrayList<Integer> DriverFirstPositions= new ArrayList<>();
    protected ArrayList<Integer> DriverSecondPositions= new ArrayList<>();
    protected ArrayList<Integer> DriverThirdPositions= new ArrayList<>();
    protected ArrayList<String> RaceDate = new ArrayList<>();
    /*private int noRaces;*/
    private int noPoints;
    private int RacePosition=10;



    @Override
    public String toString() {
        return "Formula1Driver{" +
                "FirstPositions=" + getFirstPositions() +
                ", SecondPositions=" + getSecondPositions() +
                ", ThirdPositions=" + getThirdPositions() +
                ", noPoints=" + getNoPoints() +
                '}';
    }

    protected int getFirstPositions() {
        return this.FirstPositions;
    }

    protected int getSecondPositions() {
        return this.SecondPositions;
    }

    protected int getThirdPositions() {
        return this.ThirdPositions;
    }

    protected int getNoPoints() {
        return this.noPoints;
    }


    protected int getRacePosition() {
        return RacePosition;
    }

    protected void setRacePosition(int racePosition) {
        RacePosition = racePosition;
        //getting driver positions from console class and incrementing positions and the total points of each driver using switch loop
        switch (getRacePosition()) {
            case 1 -> {
                FirstPositions = DriverFirstPositions.get(getDriverId());
                noPoints = TotalPoints.get(getDriverId());
                FirstPositions++;
                noPoints = noPoints + 25;
                DriverFirstPositions.set(getDriverId(), FirstPositions);
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 2 -> {
                SecondPositions = DriverSecondPositions.get(getDriverId());
                noPoints = TotalPoints.get(getDriverId());
                SecondPositions++;
                noPoints = noPoints + 18;
                DriverSecondPositions.set(getDriverId(), SecondPositions);
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 3 -> {
                ThirdPositions = DriverThirdPositions.get(getDriverId());
                noPoints = TotalPoints.get(getDriverId());
                ThirdPositions++;
                noPoints = noPoints + 15;
                DriverThirdPositions.set(getDriverId(), ThirdPositions);
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 4 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 12;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 5 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 10;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 6 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 8;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 7 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 6;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 8 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 4;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 9 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 2;
                TotalPoints.set(getDriverId(), noPoints);
            }
            case 10 -> {
                noPoints = TotalPoints.get(getDriverId());
                noPoints = noPoints + 1;
                TotalPoints.set(getDriverId(), noPoints);
            }
            default -> {
                noPoints = TotalPoints.get(getDriverId());
                TotalPoints.set(getDriverId(), noPoints);
            }
        }
    }

    protected ArrayList<Integer> getDriverFirstPositions() {
        return DriverFirstPositions;
    }

    protected int getDriverId() {
        return DriverId;
    }

    protected void setDriverId(int driverId) {
        DriverId = driverId;
    }
}
