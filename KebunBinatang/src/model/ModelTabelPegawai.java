/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelTabelPegawai extends AbstractTableModel {
    List<DataPegawai> dp;

    public ModelTabelPegawai(List<DataPegawai> dp) {
        this.dp = dp;
    }
    
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int column){
        switch(column){
           case 0:
               return "id";
           case 1:
               return "nama";
           case 2:
               return "email";
           case 3:
               return "password";
           case 4:
               return "role";
           default:
               return null;
       } 
    }
    
    @Override
    public Object getValueAt(int row, int column) {
       switch(column){
           case 0:
               return dp.get(row).getId();
           case 1:
               return dp.get(row).getNama();
           case 2:
               return dp.get(row).getEmail();
           case 3:
               return dp.get(row).getPassword();
           case 4:
               return dp.get(row).getRole();
           default:
               return null;
       } 
    }
    
}
