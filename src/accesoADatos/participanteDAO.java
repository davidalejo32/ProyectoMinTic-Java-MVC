
package accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import modelo.ParticipanteModel;
import utilidades.ConnectionDB;

public class participanteDAO {
    //aqui voy a tener mis queries
    
    private Connection conn = null;
    
    //creamos cada uno de los elementos del crud 
    //leer todos los participantes
    public ArrayList<ParticipanteModel> getTodosParticipantesT2(){
        ArrayList<ParticipanteModel> Todosparticipantes = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql ="SELECT par_login, par_nombre, par_apellido, par_email, par_celular, par_clave, par_fecha_nto FROM concurso2.participante ORDER BY par_login;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while(result.next()){
                ParticipanteModel participante = new ParticipanteModel(result.getString(1), result.getString(2),result.getString(3),
                        result.getString(4),result.getLong(5),result.getString(6),result.getString(7));
                Todosparticipantes.add(participante);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
        return Todosparticipantes;
    }
    
    //leer queri principal solo 4 campos
    public ArrayList<ParticipanteModel> getParticipantesT1(){
        ArrayList<ParticipanteModel> participantes4Camp = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql ="SELECT par_login, par_nombre, par_apellido, par_celular FROM concurso2.participante ORDER BY par_login;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while(result.next()){
                ParticipanteModel participante = new ParticipanteModel(result.getString(1), result.getString(2),result.getString(3),
                        result.getLong(4));
                participantes4Camp.add(participante);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
        return participantes4Camp;
    }
    
    //crear/create
    
    public void insertParticipante(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "INSERT INTO participante (par_login, par_nombre, par_apellido, par_email, par_celular, "
                + "par_clave, par_fecha_nto) VALUES (?,?,?,?,?,?,?);";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_login());
        statement.setString(2, participante.getPar_nombre());
        statement.setString(3, participante.getPar_apellido());
        statement.setString(4, participante.getPar_email());
        statement.setLong(5, participante.getPar_celular() );
        statement.setString(6, participante.getPar_clave());
        statement.setString(7, participante.getPar_fecha_nto());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado");
        }

    }
    
    //update
     
    public void updateEmail(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_email=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_email());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
         
         
     }
     
    public void updateCelular(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_celular=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, participante.getPar_celular());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
         
         
     }
     
    public void updateClave(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_clave=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_clave());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
    }
     
    public void updateNombre(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_nombre=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_nombre());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        } 
     }
      
    public void updateApellido(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_apellido=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_apellido());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        } 
     }
      
    public void updateFecha(ParticipanteModel participante){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "UPDATE participante SET par_fecha_nto=? WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, participante.getPar_fecha_nto());
        statement.setString(2, participante.getPar_login());
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "La Actualizacion fue agregada exitosamente");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }   
     }
     
        
        //DELETE
        
     public void borrar(String login){
         try{
            if(conn == null)
                conn = ConnectionDB.getConnection();
        String sql = "DELETE FROM participante WHERE par_login=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, login);
        
        int rowsInserted = statement.executeUpdate();
        if(rowsInserted > 0)
            JOptionPane.showMessageDialog(null, "Usuario Eliminado con Exito");
         } 
        catch (SQLException ex) {
        
           JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()+"\nError :" + ex.getMessage());
        }
    }
    
     
    
    
}
