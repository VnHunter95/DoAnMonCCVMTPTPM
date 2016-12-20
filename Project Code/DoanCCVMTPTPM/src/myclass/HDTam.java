
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
    public void removeProduct(String tableid,String productid)
    {
    
    }
    public void changeProductQuanity(String tableid,String productid,int Quanity)
    {
    
    }
    
}
