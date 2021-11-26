/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

/**
 *
 * @author Tarek
 */
public class FileHelper {
    /* CONSTRUCTOR */
    public FileHelper() {
        m_outputFile = "output";
        m_fileExtension = ".csv";
        m_fullFileName = m_outputFile + m_fileExtension;
    }
    
    /* FIELDS */
    private String m_outputFile;
    private String m_fileExtension;
    private String m_fullFileName;
    
    
    /* METHODS */
    public void writeOutputToFile() {
        File inFile = new File(m_fullFileName);
        // check if a file exists; if so, delete and recreate file
        if(inFile.exists()) {
            try {
                inFile.delete();
            }
            catch(SecurityException e) {
                System.out.println("An error occurred when trying to delete exisitng file."
                        + "\nAsecurity manager exists that denies delete access to the file");
                e.printStackTrace();
            }
            try {
                inFile.createNewFile();
            }
            catch(SecurityException e) {
                System.out.println("An error occurred when trying to create the file."
                        + "\nAsecurity manager exists that denies the creation");
                e.printStackTrace();
            }
            catch(IOException e) {
                System.out.println("An error occurred when trying to create the file.");
                e.printStackTrace();
            }
        }
    }
}
