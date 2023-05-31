package br.com.uniamerica.imobiliaria.Controllers;

import br.com.uniamerica.imobiliaria.Service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/api/comprador")
public class CompradorController {
    @Autowired
    private CompradorService compradorService;
///////////////////////////////////GET ID COMPRADORES///////////////////////////////////
    @GetMapping
    public ResponseEntity<?> idComprador(@RequestParam("id") final Long id){
        try{
            return ResponseEntity.ok(compradorService.procurarComprador(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }
///////////////////////////////////GET LISTA COMPRADORES///////////////////////////////////
    @GetMapping ({"/lista"})
    public ResponseEntity<?> ListaCondutor(){
        return ResponseEntity.ok(compradorService.listaComprador());
    }
///////////////////////////////////GET ATIVOS COMPRADORES///////////////////////////////////
    @GetMapping({"/ativos"})
    public ResponseEntity<?> getAtivos(){
        return ResponseEntity.ok(compradorService.ativosComprador());
    }












}







