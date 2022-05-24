
package com.back.portfolio.controller;

import com.back.portfolio.model.Usuario;
import com.back.portfolio.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService uServ;
    
    @PostMapping("/new")
    public void createUser(@RequestBody Usuario user){
        uServ.crearUsuario(user);
    }
    
    @PutMapping("/edit/{id}")
    public void editUser(@PathVariable("id") int id, 
                           @RequestBody Usuario user){
        Usuario nvo = uServ.buscarUsuario(id);
        if(nvo != null){
            nvo.setNombre(user.getNombre());
            nvo.setApellido(user.getApellido());
            nvo.setEmail(user.getEmail());
            nvo.setUsername(user.getUsername());
            nvo.setPassword(user.getPassword());
            
            uServ.editarUsuario(nvo);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        uServ.borrarUsuario(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Usuario detail(@PathVariable("id") int id){
        return uServ.buscarUsuario(id);
    }
    
    @GetMapping("/showAll")
    @ResponseBody
    public List<Usuario> showUsers(){
        return uServ.verUsuarios();
    }
    
    @PostMapping("/login")
    @ResponseBody
    public Usuario login(@RequestBody Usuario user){
        return uServ.loginUsuario(user);
    }
    
}
