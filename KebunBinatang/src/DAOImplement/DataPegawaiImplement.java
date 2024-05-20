/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface DataPegawaiImplement {
    public List<DataPegawai> login(String user, String pass);
    public List<DataPegawai> getAll();
}
