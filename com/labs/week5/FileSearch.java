/*
@author: Nick Martin
@date: 9/16/2026
@purpose: a recursive class to read the file directory and print to console
*/

package com.labs.week5;

import java.io.*;
import java.util.*;

public class FileSearch{


    public void printPath(String currentPath){

        File startFile = new File(currentPath);
        System.out.println(currentPath);
        
        FilenameFilter filter = new FilenameFilter(){
            public boolean accept(File f, String name)
                {
                    return (!name.startsWith(".") && !name.startsWith("bin") && !name.startsWith("com"));
                }
        };

        
        String[] contained = startFile.list(filter);//add array of files 



        if (contained !=null){
        for(String file:contained){//go through list
            //System.out.println(file);
            
            printPath(file);
            
            
        }
        }
    }

        

}


    