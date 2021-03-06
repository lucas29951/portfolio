
package com.back.portfolio.repository;

import com.back.portfolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{
    
    Usuario findByUsername(String username);
    Usuario findByUsernameAndPassword(String username, String password);
}
