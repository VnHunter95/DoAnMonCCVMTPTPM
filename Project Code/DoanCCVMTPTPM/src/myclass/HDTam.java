
package myclass;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HDTam {
    private Connect con = new Connect();
    public ResultSet getHD_TamByTable(String TableId) throws SQLException
    {
        con.connectSQL();
        return con.LoadData("Select hd.IDMH, TenMH,SoLuong, DonGia, DonGia*SoLuong AS [ThanhTien] "+
                            "From MatHang mh, HD_Tam hd "+
                            "Where mh.IDMH = hd.IDMH and hd.IDBan like '"+TableId+"'");     
    }
    
    public void deleteHD_TamByTable(String tableid)
    {
        
    }
    public void removeProduct(String tableid,String productid) throws SQLException
    {
        con.connectSQL();
        con.UpdateData("Delete HD_Tam Where IdBan like '"+tableid+"' and IDMH like '"+productid+"'");
    }
    public void changeProductQuanity(String tableid,String productid,int Quanity) throws SQLException
    {
        con.connectSQL();
          con.UpdateData("Update HD_Tam Set SoLuong = " + String.valueOf(Quanity)+" Where IdBan like '"+tableid+"' and IDMH like '"+productid+"'");
    }
    public void addProductToTable(String tableid,String productid) throws SQLException
    {
        con.connectSQL();
        ResultSet res = con.LoadData("Select SoLuong from HD_Tam Where IDBan like '"+tableid+"' and IDMH like '"+productid+"'");
        if(res.next())
        {
            changeProductQuanity(tableid,productid,res.getInt(1)+1);
            return;
        }
        con.UpdateData("Insert Into HD_Tam Values('"+tableid+"','"+productid+"',1)");
    }
    
}
