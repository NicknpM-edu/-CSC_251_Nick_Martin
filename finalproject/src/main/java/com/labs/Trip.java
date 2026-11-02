/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each Trip completed in company
*/




import java.util.*;

public class Trip{//traits of every held Trip

Integer tripId;// must be unique/hashmapID
String origin;//where trip start
String destination;//where trip end
Date expDeparture;//when trip was scheduled to begin
Date expArrival;// when trip was scheduled to end MUST AFTER EXPDEPARTURE
String purpose;//stated goal of trip
Driver driver;
Vehicle vehicle;
Date trueDeparture;//when the trip actually started
Date trueArrival;//when the trip actually ended MUST AFTER DEPARTURE
String status;//what the trip is now: (delayed, in-progress, completed, cancelled)


}