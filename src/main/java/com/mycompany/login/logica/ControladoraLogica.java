package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis;

    public ControladoraLogica(){
        controlPersis = new ControladoraPersistencia();
    }
    
    public String validarUsuario(String usuario, String contrasena) {
        String mensaje = "";
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usu : listaUsuarios) {
            
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasena().equals(contrasena)) {
                    mensaje = "Usuario y contraseña correctos";
                    return mensaje;
                } else {
                    mensaje = "Contraseña Incorrecta";
                    return mensaje;
                }
            } else {
                mensaje = "Usuario no encontrado";
                
            }

        }
        return mensaje;
    }
}
