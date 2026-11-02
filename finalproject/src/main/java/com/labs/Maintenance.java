/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for the maintenance of each vehicle in company
*/




import java.util.*;

public class Maintenance{//maintenance information 

Date lastMaint;//last time maintenance was performed
Date scheduledMaint;//next maintenance scheduled for vehicle
Integer maintFrequencyDays;//how many days between each scheduled maintenance(if based on elapsed time)
Integer maintFrequencyMiles;//how many miles between each scheduled maintenance(if based on elapsed time)
String maintFrequencyMode;//whether to calculate frequency with days, miles, or both


public void maintSchedule(Integer miles){
    Calendar c = Calendar.getInstance();
    switch (maintFrequencyMode){
        case "Days":

            c.setTime(lastMaint);
            c.add(Calendar.DATE,maintFrequencyDays);
            scheduledMaint = c.getTime();
            break;

        case "Miles":
            c.setTime(lastMaint);
            c.add(Calendar.DATE,maintFrequencyMiles);
            scheduledMaint = c.getTime();
            break;

        case "Both"://uses the shorter timeperiod of the two
            Integer closer;
            if (maintFrequencyDays > maintFrequencyMiles){
                closer = maintFrequencyMiles;
            }
            else{
                closer = maintFrequencyDays;
            }
            c.setTime(lastMaint);
            c.add(Calendar.DATE,closer);
            scheduledMaint = c.getTime();
            break;
    }
}



}