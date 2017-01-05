/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author My PC
 */ 
public class Menu {
    public Connect cn = new Connect();
    public Connection conn = null;
    public ResultSet LoadAllmathang() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM MatHang";
        return cn.LoadData(sql);
    }
    public ResultSet LoadTheoten(String user) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM MatHang WHERE TenMH like N'%" + user + "%'";
        return cn.LoadData(sql);
    }
    public ResultSet LoadTheogia(String a,String b) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM MatHang WHERE DonGia between '" + a +"' and '" + b +"'";
        return cn.LoadData(sql);
    }
}