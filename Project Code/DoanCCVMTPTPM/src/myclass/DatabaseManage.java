/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HOME
 */
public class DatabaseManage {
    public Connect cn = new Connect();
     public void BackUp() throws SQLException{   
         try{
             cn.connectSQL();
         String sql = "USE QLNH \n"
                 + "BACKUP DATABASE QLNH TO DISK = 'C:\\Users\\HOME\\Desktop\\New folder (3)\\DoAnMonCCVMTPTPM\\Backup\\DB.Bak'WITH FORMAT,MEDIANAME = 'QLNH',NAME = 'Full Backup of QLNH'";
        cn.UpdateData(sql);
         }
         catch(SQLException e){
             
         }
     }
     public void Restore() throws SQLException{
         try{
             cn.connectSQL();
         String sql ="USE master \n" +
            "RESTORE DATABASE QLNH FROM DISK='C:\\Users\\HOME\\Desktop\\New folder (3)\\DoAnMonCCVMTPTPM\\Backup\\DB.Bak'\n" +
            "WITH \n" +
            "   MOVE 'QLNH' TO 'C:\\Users\\HOME\\Desktop\\New folder (3)\\DoAnMonCCVMTPTPM\\Backup\\QLNH.mdf',\n" +
            "   MOVE 'QLNH_log' TO 'C:\\Users\\HOME\\Desktop\\New folder (3)\\DoAnMonCCVMTPTPM\\Backup\\QLNH_log.ldf'";  
         cn.UpdateData(sql);   
         }
         catch(SQLException e){
             
         }      
     }
     public void Restore(String filename) throws SQLException //khôi phục database
        {
            cn.connectSQL();
            String query = "USE master; ALTER DATABASE QLNH SET SINGLE_USER WITH ROLLBACK IMMEDIATE;" +
                    "RESTORE DATABASE QLNH" +
                   " FROM DISK ='" + filename + "' WITH REPLACE; ";
            cn.UpdateData(query);
        }
}
