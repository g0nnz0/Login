package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.Usuario;
import com.mycompany.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    RolJpaController rolJPA = new RolJpaController();

    public List<Usuario> traerUsuarios() {
        return usuarioJPA.findUsuarioEntities();
        }

    public List<Rol> traerRoles() {
        return rolJPA.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
        usuarioJPA.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
        try {
            usuarioJPA.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
