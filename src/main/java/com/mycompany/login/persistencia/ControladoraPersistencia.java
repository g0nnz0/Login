package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
        return usuarioJPA.findUsuarioEntities();
        }
}
