package br.com.uniamerica.imobiliaria.Controllers;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Entity.Owner;
import br.com.uniamerica.imobiliaria.Entity.Seller;
import br.com.uniamerica.imobiliaria.Repository.OwnerRepository;
import br.com.uniamerica.imobiliaria.Repository.SellerRepository;
import br.com.uniamerica.imobiliaria.Service.SellerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SellerController {

    @Autowired
    private SellerRepository Repository;

    @Autowired
    private SellerServise Servise;

    @GetMapping("/lista")
    public ResponseEntity<List<Seller>> lista(){return  ResponseEntity.ok(this.Servise.listar());}

    @GetMapping("/lista/id/{id}")
    public  ResponseEntity<?> listaId(@PathVariable(value = "id") Long id){
        Seller listarid = Repository.findById(id).orElse(null);
        return listarid ==null
                ? ResponseEntity.badRequest().body("Erro: valor nao encontrado.")
                : ResponseEntity.ok(listarid);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadatrar(@RequestBody Seller cadastro){
        try{
            this.Servise.cadastrar(cadastro);
            return ResponseEntity.ok("Cadastro bem sucedido");
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("Esse Seller ja exixte");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro"+ e.getStackTrace());
        }
    }

    @GetMapping("/lista/ativo/{ativo}")
    public ResponseEntity<List<Seller>> listaAtivo(@PathVariable boolean ativo) {
        return ResponseEntity.ok(this.Servise.listaSellerAtivos());
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idSeller
    ){
        this.Servise.desativar(idSeller);
        return ResponseEntity.ok().body("desativado com sucesso!");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Seller atualizarId
    ) {
        try {
            this.Servise.atualizar(id, atualizarId);
            return ResponseEntity.ok().body(" atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
