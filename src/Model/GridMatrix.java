/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Tarek
 */
public class GridMatrix {
    
    /* ************** FIELDS ************** */
    private int m_rows;
    private int m_columns;
    ArrayList<String> m_columnTitles;
    ArrayList<Product> m_products;
    
    // matrix, will be used to generate a csv file
    String[][] m_matrix;
    
    /* ************** Overloaded Constructor ************** */
    public GridMatrix(int rows, int columns, ArrayList<String> columnTitles, ArrayList<Product> products) {
        // assign fields
        m_rows = rows;
        m_columns = columns;
        m_columnTitles = columnTitles;
        m_products = products;
        // init 2d array
        m_matrix = new String[m_rows][m_columns];
        for(int i = 0; i < m_rows; ++i) {
            for(int j = 0; j < m_columns; ++j) {
                // i = row index, j = column index
                m_matrix[i][j] = m_products.get(i).getAttrByIndex(j);
            }
        }
    }
    
    @Override
    public String toString() {
        String ret = "";
        // first loop is first column titles
        for(int i = 0; i < m_columns; ++i) {
            ret += m_columnTitles.get(i);
            if(i != m_columns - 1) {
                ret += ",";
            }
        }
        ret += "\n";
        for(int i = 0; i < m_rows; ++i) {
            String currentRow = "";
            for(int j = 0; j < m_columns; ++j) {
                currentRow += m_matrix[i][j];
                if(j != m_columns - 1) {
                    currentRow += ",";
                }
            }
            //System.out.println(currentRow);
            ret += currentRow;
            ret += "\n";
        }
        return ret;
    }
}
