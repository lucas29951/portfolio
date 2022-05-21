
package com.back.portfolio.controller;

import com.back.portfolio.model.Tecnologia;
import com.back.portfolio.service.ITecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/technology")
@CrossOrigin(origins = "http://localhost:4200")
public class TecnologiaController {
    
    @Autowired
    private ITecnologiaService tecnoServ;
    
    @PostMapping("/new")
    public void createTechnology(@RequestBody Tecnologia tec){
        tecnoServ.agregarTecnologia(tec);
    }
    
    @PutMapping("/edit/{id}")
    public void editTechnology(@PathVariable("id") int id, 
                           @RequestBody Tecnologia tec){
        Tecnologia nva = tecnoServ.buscarTecnologia(id);
        if(nva != null){
            nva.setNombre_tecno(tec.getNombre_tecno());
            nva.setPersona(tec.getPersona());
            
            tecnoServ.editarTecnologia(nva);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteTechnology(@PathVariable("id") int id){
        tecnoServ.borrarTecnologia(id);
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Tecnologia detail(@PathVariable("id") int id){
        return tecnoServ.buscarTecnologia(id);
    }
}
