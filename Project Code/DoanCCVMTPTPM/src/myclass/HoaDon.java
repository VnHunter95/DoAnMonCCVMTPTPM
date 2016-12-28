
package myclass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class HoaDon {
    Connect con = new Connect();
    public void insertHoaDon(double total,double discount,double tax,double payment,String tableid) throws SQLException
    {
        con.connectSQL();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
       con.UpdateData("INSERT INTO HoaDon Values('"+timeStamp+"',"+total+","+discount+","+tax+","+payment+",'"+tableid+"')");
    }
    public void insertCT_HD(int invoiceid,String productid,int quanity,double price) throws SQLException
    {
        con.connectSQL();
        con.UpdateData("INSERT INTO CT_HD(SoHD,IDMH,DonGia,SoLuong,ThanhTien) Values("+invoiceid+",'"+productid+"',"+price+","+quanity+","+price*quanity+")");
    }
    public int getLatestId() throws SQLException
    {
        ResultSet res = con.LoadData("SELECT IDENT_CURRENT ('HoaDon') as [ID]");
        if(res.next())
        {
            return res.getInt("ID");
        }
        return -1;
    }
    public ResultSet loadhoadontheoma(String ma) throws SQLException{
         con.connectSQL();
         String sql ="SELECT * FROM HOADON WHERE IDBan='"+ma+"'";
         return con.LoadData(sql);
    }
}
