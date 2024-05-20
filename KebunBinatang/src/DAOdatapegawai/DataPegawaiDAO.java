/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatapegawai;
import java.sql.*;
import java.util.*;
import koneksi.Connector;
import DAOImplement.DataPegawaiImplement;
import model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lab Informatika
 */
public class DataPegawaiDAO implements DataPegawaiImplement{
    Connection connection;
    final String login = "SELECT * FROM `pegawai` WHERE `nama`=? AND `password`=? ";
    final String select = "SELECT * FROM `pegawai` ";

    public DataPegawaiDAO() {
        connection = Connector.connection();
    }
    
    @Override
    public List<DataPegawai> login(String user, String pass) {
        PreparedStatement statement = null;
        List<DataPegawai> dp = null;
        try{
            dp = new ArrayList<DataPegawai>();
            statement = connection.prepareStatement(login);
            statement.setString(1, user);
            statement.setString(2, pass);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                DataPegawai pegawai = new DataPegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setRole(rs.getString("role"));
                dp.add(pegawai);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataPegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
        }

    @Override
    public List<DataPegawai> getAll() {
        List<DataPegawai> dp = null;
        try{
            dp = new ArrayList<DataPegawai>();
            Statement st = connection.createStatement();
            ResultSet rs =st.executeQuery(select);
            while(rs.next()){
                DataPegawai pegawai = new DataPegawai();
                pegawai.setId(rs.getInt("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.setEmail(rs.getString("email"));
                pegawai.setRole(rs.getString("role"));
                dp.add(pegawai);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataPegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
        }
}
    

