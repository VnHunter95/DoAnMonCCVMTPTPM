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
public class ThongTinNhaHang {
    public Connect cn = new Connect();
    public ResultSet LoadInfoData() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM ThongTinNhaHang";
        return cn.LoadData(sql);
    }
    public void InsertInfo(String ten, String dc, String dt1, String dt2, String Email) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO BAN Values(N'" + ten + "',N'" + dc + "',N'" + dt1 + "',N'" + dt2 + "',N'" + Email + "')";
        cn.UpdateData(sql);
    }
    public void EditInfo(String ten, String dc, String dt1, String dt2, String Email)
            throws SQLException {
        String sql = "Truncate ThongTinNhaHang";
        cn.UpdateData(sql);
        InsertInfo(ten, dc,dt1, dt2, Email);
}
}