/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclass;

import java.sql.*;

/**
 *
 * @author Hunter95
 */
public class Ban {

    public Connect cn = new Connect();

    public ResultSet LoadAllBanData() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM BAN";
        return cn.LoadData(sql);
    }

    public ResultSet LoadBanById(String id) throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM BAN WHERE IDBan like '" + id + "'";
        return cn.LoadData(sql);
    }

    public void DeleteBanById(String id) throws SQLException {
        cn.connectSQL();
        String sql = "DELETE FROM BAN WHERE IDBan like '" + id + "'";
        cn.UpdateData(sql);
    }

    public void InsertBan(String id, String khuvuc) throws SQLException {
        cn.connectSQL();
        String sql = "INSERT INTO BAN Values('" + id + "',N'" + khuvuc + "')";
        cn.UpdateData(sql);
    }

    public void EditBan(String id, String khuvuc)
            throws SQLException {
        String sql = "Update Ban  set khuvuc=N'" + khuvuc + "' where IDBan='" + id + "'";
        cn.UpdateData(sql);
    }
}
