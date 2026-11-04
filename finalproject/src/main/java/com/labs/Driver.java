/*
@author: Nick Martin
@date: 11/2/2026
@purpose: contained variables for each Driver in company
*/



package com.labs;

import java.util.*;
import java.time.*;

public class Driver{//traits of every held Driver

String name;
Integer empId;
String empStatus;//
String licenseID;
String licenseClassification;
LocalDate licenseExpiration;
ArrayList<String> special = new ArrayList<>();//each are a different requirement or certification for operation, then expiration date
ArrayList<LocalDate> offTime = new ArrayList<>();//each are a different day or time period employee is unavailable this month
ArrayList<String> history = new ArrayList<>();//each are a different trip id they have been associated with
HashMap<LocalDate, String> reports = new HashMap<>();//hashmap of incident report history with an associated trip id for each?



}