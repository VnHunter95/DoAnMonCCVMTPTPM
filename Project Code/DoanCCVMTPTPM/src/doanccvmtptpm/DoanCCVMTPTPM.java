/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanccvmtptpm;

import myclass.Connect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hunter95
 */
public class DoanCCVMTPTPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connect c = new Connect();
        try {
            c.connectSQL();
        } catch (SQLException ex) {
            Logger.getLogger(DoanCCVMTPTPM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
