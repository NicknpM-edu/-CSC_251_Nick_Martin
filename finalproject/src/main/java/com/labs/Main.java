/*
@author: Nick Martin
@date: 11/2/2026
@purpose: show and complete dashboard operations
@where i left off: fix line 96
*/


package com.labs;

import java.io.*;
import java.util.*;
import java.time.*;


public class Main {
        public static HashMap<Integer, Vehicle> vehicles = new HashMap<>();//hashmap of Vehicles
        public static  HashMap<Integer, Driver> drivers = new HashMap<>();//hashmap of Drivers
        public static HashMap<Integer, Trip> trips = new HashMap<>();//hashmap of Trips
        public static HashMap<Integer, Maintenance> workOrders = new HashMap<>();//hashmap of maintenence work orders

    public static void main(String[] args) {

        String Vpath = "C:\\coding classes\\-CSC_251_Nick_Martin\\week7\\src\\main\\java\\com\\labs\\sales.csv";//path for Vehicle csv
        String Dpath = "C:\\Users\\lh178-16\\Downloads\\-CSC_251_Nick_Martin\\finalproject\\drivers.csv";//path for drivers csv
        String Tpath = "C:\\coding classes\\-CSC_251_Nick_Martin\\week7\\src\\main\\java\\com\\labs\\sales.csv";//path for trips csv
        String Mpath = "C:\\coding classes\\-CSC_251_Nick_Martin\\week7\\src\\main\\java\\com\\labs\\sales.csv";//path for workOrders csv

        //DashBoard
        Boolean leave = false;
        Scanner speak = new Scanner(System.in);//make scanner

        while(leave == false){
            System.out.println("What is your company role (please input exact option) \n [Driver] [Dispatcher] [Maintenance Supervisor] [Maintenance Technician] [Fleet Manager] \n(input \"Leave\" to exit program)");
            String entry = speak.nextLine();
            System.out.println("Welcome "+entry);

            if(entry.equals("Leave")){
                leave = true;
            }

            if(entry.equals("Driver")){
                loadItems(Dpath,"driver");//load driver hashmap

                System.out.println("Please enter employee ID");
                entry = speak.nextLine();//receive id
                
                Driver user = drivers.get(Integer.parseInt(entry));
                if(user != null){

                }

                else{
                    System.out.println("Driver ID does not exist");
                }
                
                
                
                //System.out.println("What would you like to see? \n [review assigned trips] [review reports given]");
            }
        }

        
    }

    public static void loadItems(String path, String type){

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {//read csv
            String line;
            while ((line = br.readLine()) != null) {// go line by line
            
                
                String[] itemRay = line.split(",",-1);//comma seperated
                
                
                    //turn line into specified class
                    if (type == "vehicle"){//driver class
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
                    for (String item : itemRay[10].split(".")){
                        newvehicle.requirements.add(item);
                    }


                    
                    vehicles.put(newvehicle.CompanyID,newvehicle);//add to hashmap
                    
                    }
                    else if (type == "driver"){
                    Driver newdriver = new Driver();
                    //add all variables
                    System.out.println(itemRay[0]);
                    newdriver.empId = Integer.parseInt(itemRay[0]);
                    newdriver.name = itemRay[1];
                    newdriver.empStatus = itemRay[2];
                    newdriver.licenseID = itemRay[3];
                    newdriver.licenseClassification = itemRay[4];
                    newdriver.licenseExpiration = LocalDate.parse(itemRay[5]);
                    for (String item : itemRay[6].split(".")){
                        newdriver.special.add(item);
                    }
                    if((itemRay[7].split(".")).length > 0){//prevent parse error if empty
                        for (String item : itemRay[7].split(".")){
                        
                            newdriver.offTime.add(LocalDate.parse(item));
                        }
                    }
                    for (String item : itemRay[8].split(".")){
                        newdriver.history.add(item);
                    }
                    //turn itemray[9] into hashmap
                    String[] reportsed = itemRay[9].split(".");
                    HashMap<LocalDate, String> reportses = new HashMap<>();
                    if(reportsed.length > 1){
                    for(int i = 0;i<=(reportsed.length);i++){
                        if((i%2) == 0){
                            reportses.put(LocalDate.parse(reportsed[i]),reportsed[i+1]);
                        }
                    }
                    }
                    newdriver.reports = reportses;
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
                    newtrip.trueDeparture = LocalDate.parse(itemRay[7]);
                    newtrip.trueArrival = LocalDate.parse(itemRay[7]);
                    newtrip.status = itemRay[9];


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