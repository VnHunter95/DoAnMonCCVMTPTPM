/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HOME
 */
public class DatabaseManage {
    public Connect cn = new Connect();
    
    private String showSaveFileDialog(JFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("BAK FILE", "bak", "text");
                fileChooser.setFileFilter(filter);
		fileChooser.setDialogTitle("Specify a file to save");

		int userSelection = fileChooser.showSaveDialog(frame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                        return fileToSave.getAbsolutePath();
		}
                return "C:\\";
	}
    
     public void BackUp(JFrame frame) throws SQLException{   
                try{
             cn.connectSQL();
                JFileChooser fileChooser = new JFileChooser();
                   FileNameExtensionFilter filter = new FileNameExtensionFilter("BAK FILE", "bak", "text");
                   fileChooser.setFileFilter(filter);
                   fileChooser.setDialogTitle("Specify a file to save");

                   int userSelection = fileChooser.showSaveDialog(frame);
                   if (userSelection == JFileChooser.APPROVE_OPTION) {
                           File fileToSave = fileChooser.getSelectedFile();
                           System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                            String sql = "USE QLNH \n"
                    + "BACKUP DATABASE QLNH TO DISK = '"+fileToSave.getAbsolutePath()+".bak' WITH FORMAT,MEDIANAME = 'QLNH',NAME = 'Full Backup of QLNH'";
                   cn.UpdateData(sql);
            }
         }
         catch(SQLException e){
             
         }
     }
}
