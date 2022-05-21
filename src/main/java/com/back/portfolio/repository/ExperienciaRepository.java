
package com.back.portfolio.repository;

import com.back.portfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lucas Rodriguez
 */

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia,Integer>{
    
}
