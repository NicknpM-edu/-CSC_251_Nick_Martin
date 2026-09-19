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

        
        File startFile = new File(currentPath);//turn the string path into a file path
        System.out.println(startFile.getName());//print just name, not path
        
        
        FilenameFilter filter = new FilenameFilter(){//filter out my personal files
            public boolean accept(File f, String name)
                {
                    return (!name.startsWith(".") && !name.startsWith("bin") && !name.startsWith("com"));
                }
        };

        
        File[] contained = startFile.listFiles(filter);//add array of files within filepath



        if (contained !=null){
        for(File file:contained){//go through list
            //System.out.println(file);
            printPath(file.getPath());//run again within filepath until reach end of directory line
            
            
        }
        }
        {
            //System.out.println("--");
        }
    }

        

}


    