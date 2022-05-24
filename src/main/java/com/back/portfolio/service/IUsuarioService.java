
package com.back.portfolio.service;

import com.back.portfolio.model.Usuario;
import java.util.List;


public interface IUsuarioService {
    
    public List<Usuario> verUsuarios();
    public void crearUsuario(Usuario user);
    public void borrarUsuario(int id);
    public Usuario buscarUsuario(int id);
    public void editarUsuario(Usuario user);
    public Usuario loginUsuario(Usuario user);
}
