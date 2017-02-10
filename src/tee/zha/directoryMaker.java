package tee.zha;
/*=========================================================================
* directoryMaker.java
* Author: Toby Zhang
*
* Purpose: This program makes me folders for my TV shows and puts the min so I can place them in the sorted folder
*
* Future plans: make the default path selectable or changeable by the user.
* Create regex input to sort different filename formats
 */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class directoryMaker {

    public static void main(String[] args) {
        // Change the directory to your own if needed

        File folder = new File("D:\\UNSORTED TBW\\");
        File[] listOfFiles = folder.listFiles();
        String defaultPath = "D:\\UNSORTED TBW\\";


        //for loop for each file in the list
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                //splits file name with - Only want the name before - so we call for 0.
                //This is the deafult way of show my shows are sorted.
                // also adds a - in the string in case there is no - in file
                String fileName = listOfFiles[i].getName() + "-";
                String[] names = fileName.split("-");
                //System.out.print(names[0]+"\n");
                Path folderPath = Paths.get(defaultPath + names[0].trim() + "\\");
                System.out.print(folderPath + "\n");
                File directory = new File(String.valueOf(folderPath));

                //checks if directory exists. if does not exist, make new directory.
                if (!directory.exists()) {
                    //makes a directory if not exists
                    directory.mkdir();
                }
                //sets initial file directory
                File dirA = listOfFiles[i];
                //renames the file path of the file i nthe if loop
                //returns a user response if successful or not
                if (dirA.renameTo(new File(String.valueOf(folderPath) + "\\" + dirA.getName()))) {
                    System.out.print("Move success");
                } else {
                    System.out.print("Failed");
                }
            }
        }
    }
}

