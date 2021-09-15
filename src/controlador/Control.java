
package controlador;

import accesoADatos.participanteDAO;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.ParticipanteModel;
import vista.*;


public class Control {

    public Control() {
        
    }
    
    public void accionesVPrincipal(VentanaPrincipal vPrincipal, ActionEvent evt){
        Object clicado=evt.getSource();
        
        if(clicado==vPrincipal.botonP ){
           vPrincipal.panelTablaP.setVisible(true);
           vPrincipal.panelTablaS.setVisible(false);
           vPrincipal.botonactualizar.setVisible(false);
           vPrincipal.botonBorrar.setVisible(false);
           vPrincipal.imagen1.setVisible(true);
           
       }else if(clicado==vPrincipal.botonS){
           vPrincipal.panelTablaS.setVisible(true);
           vPrincipal.panelTablaP.setVisible(false);
           vPrincipal.botonactualizar.setVisible(true);
           vPrincipal.botonBorrar.setVisible(true);
           vPrincipal.imagen1.setVisible(false);
       }else if(clicado==vPrincipal.botonAgregarP){
            vPrincipal.vRegistro = new ventanaRegistro();
            vPrincipal.vRegistro.setVisible(true);
           
       }else if(clicado==vPrincipal.botonactualizar){
           vPrincipal.vActualizar = new ventanaActualizar();
           vPrincipal.vActualizar.setVisible(true);
           vPrincipal.vActualizar.setLocationRelativeTo(null);
       }else if(clicado==vPrincipal.actualizarTa){
           vPrincipal.limpiarTablas();
           vPrincipal.listarT1();
           vPrincipal.listarT2();
       }else if(clicado==vPrincipal.botonBorrar){
            int fila=vPrincipal.tablaS.getSelectedRow();
        
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "Usuario no Seleccionado");
            }else{
                String login =vPrincipal.tablaS.getValueAt(fila, 0).toString();
                vPrincipal.participantes.borrar(login);
            }
    }
    

}

    public void accionesVRegistro(ventanaRegistro vRegisto, ActionEvent evt){
        Object clicado=evt.getSource();
        if(clicado==vRegisto.Registrar){
            vRegisto.agregar();
        }
    }

    public void accionesVActualizar(ventanaActualizar vActualizar, ActionEvent evt){
         Object clicado=evt.getSource();
        if(clicado == vActualizar.botonActualizar){
            
            String datoJcbo       = (String) vActualizar.jcboActualizar.getSelectedItem();                       
            String datoOutputTxt  = vActualizar.txtNombreU.getText();
            String datoOutputTxt2 = vActualizar.txtActualizado.getText();
            
            if(datoOutputTxt.equals("") || datoOutputTxt2.equals("")){              
                JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
     
            }else{
                
                if(datoJcbo.equals("Correo Electronico")){

                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_email(datoOutputTxt2);
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateEmail(vActualizar.pModel);

                  
                }else if(datoJcbo.equals("Celular")){ 
                    try{
                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_celular(Long.parseLong(datoOutputTxt2));
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateCelular(vActualizar.pModel);
                          
                    }catch(NumberFormatException ex){
        	          JOptionPane.showMessageDialog(null, "No se permiten letras");
    	         }        

                }else if(datoJcbo.equals("Clave")){

                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_clave(datoOutputTxt2);
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateClave(vActualizar.pModel);


                }else if(datoJcbo.equals("Nombre")){

                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_nombre(datoOutputTxt2);
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateNombre(vActualizar.pModel);


                }else if(datoJcbo.equals("Apellido")){

                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_apellido(datoOutputTxt2);
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateApellido(vActualizar.pModel);


                }else if(datoJcbo.equals("Fecha Nacimiento")){

                          vActualizar.pModel = new ParticipanteModel();
                          vActualizar.pModel.setPar_fecha_nto(datoOutputTxt2);
                          vActualizar.pModel.setPar_login(datoOutputTxt);

                          vActualizar.pDAO = new participanteDAO();
                          vActualizar.pDAO.updateFecha(vActualizar.pModel);

                }
                
              vActualizar.txtActualizado.setText("");
              vActualizar.jcboActualizar.setSelectedItem("Correo Electronico");
            }    
        }
    }
    
}
