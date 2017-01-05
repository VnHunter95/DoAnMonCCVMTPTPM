/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hunter95
 */
public class TaiKhoan {

    public Connect cn = new Connect();
    public Connection conn = null;

    public ResultSet LoadAllTaiKhoanata() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM TaiKhoan";
        return cn.LoadData(sql);
    }

    public ResultSet LoadTaiKhoanTheoTenVaMatKhau(String user, String pass) throws SQLException {
        cn.connectSQL();
        String userName = "sa";
        String passworld = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNH;";
        conn = java.sql.DriverManager.getConnection(url, userName, passworld);
        String sql = "SELECT * FROM TaiKhoan WHERE Username ='" + user + "' and Password ='" + pass + "'";
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM TaiKhoan WHERE Username =? and Password =?");
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        //return cn.LoadData(sql);
        return rs;
    }

    public ResultSet LoadTaiKhoanByUsername(String user) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM TaiKhoan WHERE Username like '" + user + "'";
        return cn.LoadData(sql);
    }

    public void DeleteTaiKhoanByUsername(String user) throws SQLException {
        cn.connectSQL();
        String sql = "DELETE FROM TaiKhoan WHERE Username like '" + user + "'";
        cn.UpdateData(sql);
    }
    //Tự code InsertMatHang

    public void InsertTaiKhoan(String tk,String pa,Boolean ad) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO TaiKhoan Values('"+tk+"','"+pa+"','"+ad.toString()+"')";
        cn.UpdateData(sql);
    }
    public void EditTaiKhoan(String tk,String pa,Boolean ad) throws SQLException{
         cn.connectSQL();
         String sql ="Update TaiKhoan set Username ='"+tk+"',Password='"+pa+"',CapDo='"+ad+"' ";
         cn.UpdateData(sql);
     }
}
