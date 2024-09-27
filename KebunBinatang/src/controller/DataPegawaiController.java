/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import javax.swing.*;
import DAOImplement.DataPegawaiImplement;
import DAOdatapegawai.DataPegawaiDAO;
import model.*;
import view.*;
/**
 *
 * @author Lab Informatika
 */
public class DataPegawaiController {
    LoginPage frame;
    DataPegawaiImplement impldatapegawai;
    List<DataPegawai> dp;
    List<DataPegawai> kosong;


    public DataPegawaiController(LoginPage frame) {
        this.frame = frame;
        impldatapegawai = new DataPegawaiDAO();
        dp = impldatapegawai.getAll();
    }
    
    public void login(){
        String user = frame.getjTextUsername().getText();
        String pass = frame.getjTextPassword().getText();
        dp = impldatapegawai.login(user, pass);
        ModelTabelPegawai mp = new ModelTabelPegawai(dp);
        System.out.println(dp);
        if(dp == kosong ){
            JOptionPane.showMessageDialog(null, "Password atau username salah", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            LoginPage l = new LoginPage();
            MenuPage m = new MenuPage();
            l.setVisible(false);
            m.setVisible(true);
            m.setLocationRelativeTo(null);
            
        }
    }
    
    public void isi(){
        dp = impldatapegawai.getAll();
    }
}
