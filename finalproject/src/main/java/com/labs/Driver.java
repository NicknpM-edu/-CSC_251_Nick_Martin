/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each Driver in company
*/





import java.util.*;

public class Driver{//traits of every held Driver

String name;
Integer empId;
String empStatus;//
String license;
String licenseClassification;
Date licenseExpiration;
ArrayList<String> special = new ArrayList<>();//each are a different requirement or certification for operation, then expiration date
ArrayList<Date> offTime = new ArrayList<>();//each are a different day or time period employee is unavailable
ArrayList<String> history = new ArrayList<>();//each are a different trip id they have been associated with
HashMap<Date, String> reports = new HashMap<>();//hashmap of incident report history with an associated date for each?



}