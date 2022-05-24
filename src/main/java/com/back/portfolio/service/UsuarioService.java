
package com.back.portfolio.service;

import com.back.portfolio.model.Usuario;
import com.back.portfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    public UsuarioRepository userRepo;
    
    @Override
    public List<Usuario> verUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario user) {
        userRepo.save(user);
    }

    @Override
    public void borrarUsuario(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void editarUsuario(Usuario user) {
        userRepo.save(user);
    }
    
    @Override
    public Usuario loginUsuario(Usuario user){
        return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
