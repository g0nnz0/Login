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

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contrasena, String rolRecibido) {
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasena(contrasena);
        
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        controlPersis.crearUsuario(usu);
        
    }

    private Rol traerRol(String rolRecibido) {
        List <Rol> listaRoles = controlPersis.traerRoles();
        
        for(Rol rol : listaRoles){
            if(rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        
        return null; 
    }

}
