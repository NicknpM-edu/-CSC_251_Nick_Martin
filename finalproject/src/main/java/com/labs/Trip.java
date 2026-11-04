/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each Trip completed in company
*/


package com.labs;

import java.util.*;
import java.time.*;

public class Trip{//traits of every held Trip

Integer tripId;// must be unique/hashmapID
String origin;//where trip start
String destination;//where trip end
LocalDate expDeparture;//when trip was scheduled to begin
LocalDate expArrival;// when trip was scheduled to end MUST AFTER EXPDEPARTURE
String purpose;//stated goal of trip
Integer driverId;
Integer vehicleId;
LocalDate trueDeparture;//when the trip actually started
LocalDate trueArrival;//when the trip actually ended MUST AFTER DEPARTURE
String status;//what the trip is now: (delayed, in-progress, completed, cancelled)


}