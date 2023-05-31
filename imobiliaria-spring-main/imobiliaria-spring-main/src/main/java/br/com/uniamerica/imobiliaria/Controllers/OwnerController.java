package br.com.uniamerica.imobiliaria.Controllers;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Entity.Owner;
import br.com.uniamerica.imobiliaria.Repository.AskRepository;
import br.com.uniamerica.imobiliaria.Repository.OwnerRepository;
import br.com.uniamerica.imobiliaria.Service.OwnerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OwnerController {

    @Autowired
    private OwnerRepository Repository;

    @Autowired
    private OwnerServise Servise;

    @GetMapping("/lista")
    public ResponseEntity<List<Owner>> lista(){return  ResponseEntity.ok(this.Servise.listar());}

    @GetMapping("/lista/id/{id}")
    public  ResponseEntity<?> listaId(@PathVariable(value = "id") Long id){
        Owner listarid = Repository.findById(id).orElse(null);
        return listarid ==null
                ? ResponseEntity.badRequest().body("Erro: valor nao encontrado.")
                : ResponseEntity.ok(listarid);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadatrar(@RequestBody Owner cadastro){
        try{
            this.Servise.cadastrar(cadastro);
            return ResponseEntity.ok("Cadastro bem sucedido");
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("Esse Owner ja exixte");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro"+ e.getStackTrace());
        }
    }

    @GetMapping("/lista/ativo/{ativo}")
    public ResponseEntity<List<Owner>> listaAtivo(@PathVariable boolean ativo) {
        return ResponseEntity.ok(this.Servise.listaOwnerAtivos());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idOwner
    ){
        this.Servise.desativar(idOwner);
        return ResponseEntity.ok().body("desativado com sucesso!");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Owner atualizarId
    ) {
        try {
            this.Servise.atualizar(id, atualizarId);
            return ResponseEntity.ok().body(" atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
