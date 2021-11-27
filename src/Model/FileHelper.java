/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

/**
 *
 * @author Tarek
 */
public class FileHelper {
    /* CONSTRUCTORS */
    public FileHelper() {
        m_outputFile = "output";
        m_fileExtension = ".csv";
        m_fullFileName = m_outputFile + m_fileExtension;
        m_gridMatrix = null;
    }
    /* Overloaded Constructor */
    public FileHelper(GridMatrix gridMatrix) {
        m_outputFile = "output";
        m_fileExtension = ".csv";
        m_fullFileName = m_outputFile + m_fileExtension;
        m_gridMatrix = gridMatrix;
    }
    
    /* FIELDS */
    private String m_outputFile;
    private String m_fileExtension;
    private String m_fullFileName;
    private GridMatrix m_gridMatrix;
    
    /* METHODS */
    public void writeOutputToFile() {
        File inFile = new File(m_fullFileName);
        // check if a file exists; if so, delete and recreate file
        if(inFile.exists()) {
            try {
                inFile.delete();
            }
            catch(SecurityException err) {
                System.out.println("An error occurred when trying to delete exisitng file."
                        + "\nAsecurity manager exists that denies delete access to the file");
                err.printStackTrace();
            }
            try {
                inFile.createNewFile();
            }
            catch(SecurityException err) {
                System.out.println("An error occurred when trying to create the file."
                        + "\nAsecurity manager exists that denies the creation");
                err.printStackTrace();
            }
            catch(IOException err) {
                System.out.println("An error occurred when trying to create the file.");
                err.printStackTrace();
            }
        }
        FileWriter inFileWriter;
        try {
           inFileWriter = new FileWriter(inFile);
           System.out.println("Writing to file " + m_fullFileName + "...");
           // write toString GridMatrix which of .csv format
           inFileWriter.write(m_gridMatrix.toString());
           System.out.println("Finished writing to file. Closing and saving changes.");
           inFileWriter.close();
        }
        catch(IOException err) {
            System.out.println("Error: The file cannot be opened.");
            err.printStackTrace();
        }
    }
        
}
