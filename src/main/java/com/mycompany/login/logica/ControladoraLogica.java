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
        
        //Recibo el id del metodo buscarUltimaId()
        int id = this.buscarUltimaId();
        
        
        //Se lo asigno al nuevo usuario sumandole uno.
        usu.setId(id + 1);
        
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

    private int buscarUltimaId() {
        List <Usuario> listaUsuarios = this.traerUsuarios();
        
        //Obtengo el ultimo usuario y lo asigno a usu
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        
        //Una vez tengo al usuario obtengo su id y lo retorno
        return usu.getId();
    }

    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu, String usuario, String contrasena, String rolRecibido) {
        //A usu (el usuario original) le seteo el string usuario y su contraseña
        usu.setNombreUsuario(usuario);
        usu.setContrasena(contrasena);
        
        //Al igual que en el procedure crearUsuario() de esta manera le seteo el rol.
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        //Le paso el usuario ya editado a la persistencia
        controlPersis.editarUsuario(usu);
        
        
    }

}
