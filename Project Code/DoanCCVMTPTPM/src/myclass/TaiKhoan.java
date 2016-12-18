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
 * @author Hunter95
 */
public class TaiKhoan {
    public Connect cn = new Connect();
     public ResultSet LoadAllTaiKhoanata() throws SQLException{    
         cn.connectSQL();
         String sql = "SELECT * FROM TaiKhoan";                   
         return cn.LoadData(sql);         
     }
     public ResultSet LoadTaiKhoanByUsername(String user) throws SQLException{    
         cn.connectSQL();
         String sql = "SELECT * FROM TaiKhoan WHERE Username like '" + user +"'";                   
         return cn.LoadData(sql);         
     }
     public void DeleteTaiKhoanByUsername(String user) throws SQLException{  
         cn.connectSQL();
         String sql = "DELETE FROM TaiKhoan WHERE Username like '" + user +"'";                   
         cn.UpdateData(sql);         
     }
     //Tự code InsertMatHang
     public void InsertTaiKhoan() throws SQLException{
         cn.connectSQL();
         String sql = "INSERT INTO TaiKhoan Values()";                   
         cn.UpdateData(sql);         
     }  
}
