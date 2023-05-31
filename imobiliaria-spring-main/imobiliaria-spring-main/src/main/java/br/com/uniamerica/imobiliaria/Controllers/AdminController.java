package br.com.uniamerica.imobiliaria.Controllers;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Repository.AdminRepository;
import br.com.uniamerica.imobiliaria.Servise.AdminServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private AdminServise Servise;

    @Autowired
    private AdminRepository Repository;

    @GetMapping("/lista")
    public ResponseEntity<List<Admin>> lista(){return  ResponseEntity.ok(this.Servise.listar());}

    @GetMapping("/lista/id/{id}")
    public  ResponseEntity<?> listaId(@PathVariable(value = "id") Long id){
        Admin listarid = Repository.findById(id).orElse(null);
        return listarid ==null
                ? ResponseEntity.badRequest().body("Erro: valor nao encontrado.")
                : ResponseEntity.ok(listarid);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadatrar(@RequestBody Admin cadastro){
        try{
            this.Servise.cadastrar(cadastro);
            return ResponseEntity.ok("Cadastro bem sucedido");
        } catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("Esse adm ja exixte");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro"+ e.getStackTrace());
        }
    }

    @GetMapping("/lista/ativo/{ativo}")
    public ResponseEntity<List<Admin>> listaAtivo(@PathVariable boolean ativo) {
        return ResponseEntity.ok(this.Servise.listaAdminAtivos());
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> desativar(
            @PathVariable Long idAdmin
    ){
        this.Servise.desativar(idAdmin);
        return ResponseEntity.ok().body("desativado com sucesso!");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody Admin atualizarId
    ) {
        try {
            this.Servise.atualizar(id, atualizarId);
            return ResponseEntity.ok().body(" atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





}
