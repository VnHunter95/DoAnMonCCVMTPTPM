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
public class MatHang {
      public Connect cn = new Connect();
     public ResultSet LoadAllMatHangData() throws SQLException{    
         cn.connectSQL();
         String sql = "SELECT * FROM MatHang";                   
         return cn.LoadData(sql);         
     }
     public ResultSet LoadMatHangById(String id) throws SQLException{    
         cn.connectSQL();
         String sql = "SELECT * FROM MatHang WHERE IDMH like '" + id +"'";                   
         return cn.LoadData(sql);         
     }
     public void DeleteMatHangById(String id) throws SQLException{  
         cn.connectSQL();
         String sql = "DELETE FROM MatHang WHERE IDMH like '" + id +"'";                   
         cn.UpdateData(sql);         
     }
     //Tự code InsertMatHang
     public void InsertMatHang(String id,String mh,String dg,String loai) throws SQLException{
         cn.connectSQL();
         String sql = "INSERT INTO MatHang Values('"+id+"','"+mh+"',"+dg+",'"+loai+"')";                   
         cn.UpdateData(sql);         
     }  
     public void EditMatHang(String ml , String mh,String dg,String loai) throws SQLException{
         cn.connectSQL();
         String sql ="Update MatHang set TenMH ='"+mh+"',DonGia="+dg+",Loai='"+loai+"' where IdMh like '"+ml+"'";
         cn.UpdateData(sql);
     }
}
