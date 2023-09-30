package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis;

    public ControladoraLogica() {
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasena) {
        //String mensaje = "";
        Usuario usr = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usu : listaUsuarios) {

            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasena().equals(contrasena)) {
                    //mensaje = "Usuario y contraseña correctos";
                    usr = usu;
                    return usr;
                } else {
                    //mensaje = "Contraseña Incorrecta";
                    usr = null;
                    return usr;
                }
            } else {
                //mensaje = "Usuario no encontrado";
                usr = null;

            }

        }
        return usr;
    }

}
