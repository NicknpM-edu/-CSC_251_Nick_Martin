/*
@author: Nick Martin
@date: 11/2/2026
@purpose: show and complete dashboard operations
@where i left off: finish driver "report" path
*/


package com.labs;

import java.io.*;
import java.util.*;
import java.time.*;


public class Main {
        public static HashMap<Integer, Vehicle> vehicles = new HashMap<>();//hashmap of Vehicles
        public static HashMap<Integer, Driver> drivers = new HashMap<>();//hashmap of Drivers
        public static HashMap<Integer, Trip> trips = new HashMap<>();//hashmap of Trips
        public static HashMap<Integer, Maintenance> workOrders = new HashMap<>();//hashmap of maintenence work orders

    public static void main(String[] args) {

        String Vpath = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\finalproject\\vehicles.csv";//path for Vehicle csv
        String Dpath = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\finalproject\\drivers.csv";//path for drivers csv
        String Tpath = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\finalproject\\trips.csv";//path for trips csv
        String Mpath = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\finalproject\\workOrders.csv";//path for workOrders csv

        //DashBoard
        Boolean leave = false;
        Scanner speak = new Scanner(System.in);//make scanner
        loadItems(Dpath,"driver");//load driver hashmap
        loadItems(Vpath,"vehicle");//load vehicle hashmap
        loadItems(Tpath,"trip");//load trips hashmap
        loadItems(Mpath,"workOrders");//load workOrders hashmap
        while(leave == false){
            System.out.println("What is your company role (please input exact option) \n [Driver] [Dispatcher] [Maintenance Supervisor] [Maintenance Technician] [Fleet Manager] \n(input \"Leave\" to exit program)");
            String entry = speak.nextLine();
            

            if(entry.equals("Leave")){
                leave = true;
                break;
            }
            System.out.println("Welcome "+entry);

            if(entry.equals("Driver")){//if user enters driver
                

                System.out.println("Please enter employee ID");
                entry = speak.nextLine();//receive id
                
                Driver user = drivers.get(Integer.parseInt(entry));

                while(user != null && (!entry.equals("Leave"))){
                    System.out.println("What would you like to see? \n review assigned [trips], [report] vehicle problem");
                    entry = speak.nextLine();//receive id

                    if (entry.equals("trips")){//iterate through trips and make list of those that belong to user
                        ArrayList<Trip> assigned = new ArrayList<>();
                        for (Trip trip : trips.values()) {
                            if (trip.driverId == user.empId){
                                System.out.println(trip.info());
                                assigned.add(trip);

                                
                            }
                        }
                        if(assigned.size() > 0){
                            System.out.println("What would you like to do with assigned trips? \n [confirm] trip completion, [Leave] program");
                            entry = speak.nextLine();//entry

                            if(entry.equals("confirm")){
                                System.out.println("give the ID number of the trip you would like to confirm");
                                entry = speak.nextLine();//entry

                                for (Trip trip : assigned){
                                    if (trip.tripId == Integer.parseInt(entry)){
                                        if(trip.status.equals("in-progress")){
                                        Boolean properEntry = false;
                                        while(properEntry == false && (!entry.equals("Leave"))){
                                            try{
                                            System.out.println("What was the Departure time for the trip \n in xxxx(year)-xx(month)-xx(day) format");
                                            String entryDeparture = speak.nextLine();//entry

                                            System.out.println("What was the Arrival time for the trip \n in xxxx(year)-xx(month)-xx(day) format");
                                            String entryArrival = speak.nextLine();//entry
                                            if(LocalDate.parse(entryArrival).isAfter(LocalDate.parse(entryDeparture))){
                                                trip.status = "completed";
                                                System.out.println("Update complete");
                                                properEntry = true;
                                            }
                                            else{
                                                System.out.println("Improper entry, arrival date must be after departure date");
                                            }
                                            }
                                            catch(Exception e){
                                                System.out.println("Improper entry, format must be xxxx(year)-xx(month)-xx(day)");
                                            }
                                            

                                        }
                                        }else{
                                            System.out.println("Drivers cannot complete trips that are not in-progress");
                                        }

                                        
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("No assigned trips");
                        }
                    
                    }
                    if (entry.equals("report")){//make vehicle problem report
                        
                    }
                }
                if(user == null){
                    System.out.println("Driver ID does not exist");
                }
                
                
                
                
            }
        }

        
    }

    public static void loadItems(String path, String type){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//read csv
            String line;
            while ((line = br.readLine()) != null) {// go line by line
            
                
                String[] itemRay = line.split(",",-1);//comma seperated
                
                
                    //turn line into specified class
                    if (type == "vehicle"){//vehicle class
                    Vehicle newvehicle = new Vehicle();
                    //add all variables
                    newvehicle.CompanyID = Integer.parseInt(itemRay[0]);
                    newvehicle.VIN = itemRay[1];
                    newvehicle.licensePlate = itemRay[2];
                    newvehicle.make = itemRay[3];
                    newvehicle.model = itemRay[4];
                    newvehicle.year = itemRay[5];
                    newvehicle.type = itemRay[6];
                    newvehicle.acquisitionDate = LocalDate.parse(itemRay[7]);
                    for (String item : itemRay[8].split(".")){
                        newvehicle.OperationalStatus.add(item);
                    }
                    newvehicle.mileage = Integer.parseInt(itemRay[9]);
                    if(itemRay[10].split(".").length > 1){
                    for (String item : itemRay[10].split(".")){
                        newvehicle.requirements.add(item);
                    }
                    }
                    //turn itemray[9] into hashmap
                    String[] reportsed = itemRay[9].split(".");
                    HashMap<Integer, String> reportses = new HashMap<>();
                    if(reportsed.length > 1){
                    for(int i = 0;i<=(reportsed.length);i++){
                        if((i%2) == 0){
                            reportses.put(Integer.parseInt(reportsed[i]),reportsed[i+1]);
                        }
                    }
                    }
                    newvehicle.reports = reportses;


                    
                    vehicles.put(newvehicle.CompanyID,newvehicle);//add to hashmap
                    
                    }
                    else if (type == "driver"){
                    Driver newdriver = new Driver();
                    //add all variables
                    newdriver.empId = Integer.parseInt(itemRay[0]);
                    newdriver.name = itemRay[1];
                    newdriver.empStatus = itemRay[2];
                    newdriver.licenseID = itemRay[3];
                    newdriver.licenseClassification = itemRay[4];
                    newdriver.licenseExpiration = LocalDate.parse(itemRay[5]);
                    for (String item : itemRay[6].split(".")){
                        newdriver.special.add(item);
                    }
                    if((itemRay[7].split(".")).length > 1){//prevent parse error if empty
                        for (String item : itemRay[7].split(".")){
                            
                            
                                newdriver.offTime.add(LocalDate.parse(item));
                                
                        }
                    }
                    for (String item : itemRay[8].split(".")){
                        newdriver.history.add(item);
                    }
                    
                    drivers.put(newdriver.empId,newdriver);//add to hashmap

                    }
                    else if (type == "trip"){
                    Trip newtrip = new Trip();
                    //add all variables
                    newtrip.tripId = Integer.parseInt(itemRay[0]);
                    newtrip.origin = itemRay[1];
                    newtrip.destination = itemRay[2];
                    newtrip.expDeparture = LocalDate.parse(itemRay[3]);
                    newtrip.expArrival = LocalDate.parse(itemRay[4]);
                    newtrip.purpose = itemRay[5];
                    newtrip.driverId = Integer.parseInt(itemRay[6]);
                    newtrip.vehicleId = Integer.parseInt(itemRay[7]);
                    if(itemRay[8].length() >0){
                        newtrip.trueDeparture = LocalDate.parse(itemRay[8]);
                    }
                    if(itemRay[9].length() >0){
                        newtrip.trueArrival = LocalDate.parse(itemRay[9]);
                    }
                    newtrip.status = itemRay[10];


                    trips.put(newtrip.tripId,newtrip);//add to hashmap
                    }
                    else{
                    Maintenance newmaint= new Maintenance();
                    //add all variables
                    newmaint.maintId = Integer.parseInt(itemRay[0]);
                    newmaint.maintDay = LocalDate.parse(itemRay[1]);
                    newmaint.maintVehicle = Integer.parseInt(itemRay[2]);
                    newmaint.totalCost = Double.parseDouble(itemRay[3]);
                    newmaint.repairNotes = itemRay[4];


                    
                    workOrders.put(newmaint.maintId,newmaint);//add to hashmap
                    }
                
                
            }
        }
        catch(IOException e){//if it can't find the file
            System.out.println(e);
        }



    }
}