
package myclass;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

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
    public ResultSet getListHD() throws SQLException
    {
        con.connectSQL();
        return con.LoadData("SELECT * FROM HoaDon");
    }
    public void xoaHd(int t) throws SQLException
    {
        con.connectSQL(); 
        con.UpdateData("delete from CT_HD where SoHD='"+t+"'");
        String sql = "delete from HoaDon where SoHD = "+t+"";
        con.UpdateData(sql);
    }
    public ResultSet getPriceofDay(int day, int month, int year) throws SQLException
    {
        con.connectSQL();
        return con.LoadData("SELECT * from HoaDon hd where DAY(hd.NgayLap) = " + day + " and MONTH(hd.NgayLap) = " + month + " and YEAR(hd.NgayLap) = " + year + "");
    }
    public ResultSet getSumPrice(int day, int month, int year) throws SQLException{
         con.connectSQL();
        ResultSet res = con.LoadData("SELECT Sum(hd.ThanhTien) from HoaDon hd where DAY(hd.NgayLap) = " + day + " and MONTH(hd.NgayLap) = " + month + " and YEAR(hd.NgayLap) = " + year + "");
        return res;
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

    public void printInVoice(int invoiceid) throws SQLException {
        try {
            con.connectSQL();
            ResultSet res = con.LoadData("Select * From ThongTinNhaHang");
            String sName="",sLoc="",sPhone1="",sPhone2="",sEmail="";
            while(res.next())
            {
                sName=res.getString(1);
                sLoc=res.getString(2);
                sPhone1=res.getString(3);
                sPhone2=res.getString(4);
                sEmail=res.getString(5);
            }
            String reportName = "report/inVoice.jasper";
            HashMap map = new HashMap();
            map.put("hdId",invoiceid);
            map.put("shopName",sName);
            map.put("shopLoc",sLoc);
            map.put("shopEmail",sEmail);
            map.put("shopPhone1",sPhone1);
            map.put("shopPhone2",sPhone2);
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
            JasperPrint jp = JasperFillManager.fillReport(is,map,con.getCon());
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
}
