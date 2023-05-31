package br.com.uniamerica.imobiliaria.Controllers;

import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Entity.Localizacao;
import br.com.uniamerica.imobiliaria.Repository.ConstrucaoRepository;
import br.com.uniamerica.imobiliaria.Repository.LocalizacaoRepository;
import br.com.uniamerica.imobiliaria.Service.ConstrucaoServise;
import br.com.uniamerica.imobiliaria.Service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = ("/api/localizacao"))
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService Service;
    @Autowired
    private LocalizacaoRepository Repository;
    @GetMapping("/lista")
    public ResponseEntity<List<Localizacao>> lista(){
        List<Localizacao> listartudo = Service.listartudo();
        return ResponseEntity.ok(listartudo);
    }
    @GetMapping("/lista/id/{id}")
    public ResponseEntity<?> listaId(@PathVariable(value = "id") Long id){
        Localizacao listarid = Repository.findById(id).orElse(null);
        return listarid == null
                ? ResponseEntity.badRequest().body(" <<ERRO>>: valor nao encontrado.")
                : ResponseEntity.ok(listarid);
    }
    @GetMapping("/lista/ativo/{ativo}")
    public ResponseEntity<List<Localizacao>> listaAtivo(@PathVariable boolean ativo) {
        List<Localizacao> listarAtivo = Repository.findByAtivo(ativo);
        return ResponseEntity.ok(listarAtivo);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Localizacao cadastro){
        try{
            this.Service.cadastrar(cadastro);
            return ResponseEntity.ok("Cadastro feito com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("ERRO:"+e.getMessage());
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("ERRO: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Localizacao> deletarId = Repository.findById(id);
        if (deletarId.isPresent()) {
            Repository.deleteById(id);
            return ResponseEntity.ok("Apagado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/put/id/{id}")
    public ResponseEntity<?> atualizar( @PathVariable Long id, @RequestBody Localizacao atualizarId) {
        try {
            this.Service.atualizar(id, atualizarId);
            return ResponseEntity.ok().body(" atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
