
package myclass;
import java.sql.*;
import javax.swing.JOptionPane;
public class Connect {
    public Connection conn = null;
    public void connectSQL() throws SQLException{
        try{
            String userName = "sa";
            String passworld = "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNH;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=java.sql.DriverManager.getConnection(url,userName,passworld);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Kết nối CSDL thất bại:  " + ex.getMessage() ,"Thông Báo",1);
        }    
    }
    public ResultSet LoadData(String sql)
    {
        ResultSet res = null;
        try{
            Statement st = conn.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally
        {
            return res;
        }
    }
    public void UpdateData(String sql)
    {
         try { 
             Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
    }
    

}
