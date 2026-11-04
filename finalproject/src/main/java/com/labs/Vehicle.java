/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each vehicle in company
*/


package com.labs;

import java.util.*;
import java.time.*;

public class Vehicle{//traits of every held vehicle

Integer CompanyID;//must be unique, key in hashmap maybe?

String VIN;// also must be unique
String licensePlate;
String make;
String model;
String year;
String type;
LocalDate acquisitionDate;
ArrayList<String> OperationalStatus = new ArrayList<>();//[1] is status(operational, maintenance, retired, unavailable), any after are "outstanding safety restrictions or maintenance requirements"
Integer mileage;// have the ability to keep history somehow(file probably)
ArrayList<String> requirements = new ArrayList<>();//each are a different requirement or equipment for operation

//maintenance info
ArrayList<Integer> maintHistory = new ArrayList<>();//id of historical info of each maintenance job as well 

//LocalDate lastMaint = (maintHistory.get(maintHistory.size()-1)).maintDay;//last time maintenance was performed (calculated from last day in maintHistory)
LocalDate scheduledMaint;//next maintenance scheduled for vehicle
Integer maintFrequencyDays;//how many days between each scheduled maintenance(if based on elapsed time)
Integer maintFrequencyMiles;//how many miles between each scheduled maintenance(if based on elapsed time)
String maintFrequencyMode;//whether to calculate frequency with days, miles, or both


public void maintSchedule(LocalDate lastMaint){//change scheduled maintenance depending on mode and numbers
    switch (maintFrequencyMode){
        case "Days":

            scheduledMaint = lastMaint.plusDays(maintFrequencyDays);
            break;

        case "Miles":
            scheduledMaint = lastMaint.plusDays(maintFrequencyMiles);
            break;

        case "Both"://uses the shorter timeperiod of the tw
            Integer closer;
            if (maintFrequencyDays > maintFrequencyMiles){
                scheduledMaint = lastMaint.plusDays(maintFrequencyDays);
            }
            else{
                scheduledMaint = lastMaint.plusDays(maintFrequencyMiles);
            }
            break;
    }
}


}