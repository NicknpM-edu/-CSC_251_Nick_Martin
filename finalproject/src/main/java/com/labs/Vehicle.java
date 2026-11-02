/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each vehicle in company
*/




import java.util.*;

public class Vehicle{//traits of every held vehicle

Integer CompanyID;//must be unique, key in hashmap maybe?

String VIN;// also must be unique
String licensePlate;
String make;
String model;
String year;
String type;
Date acquisitionDate;
ArrayList<String> OperationalStatus = new ArrayList<>();//[1] is status(operational, maintenance, retired, unavailable), any after are "outstanding safety restrictions or maintenance requirements"
Integer mileage;// have the ability to keep history somehow(file probably)
ArrayList<String> requirements = new ArrayList<>();//each are a different requirement or equipment for operation

//maintenance info



}