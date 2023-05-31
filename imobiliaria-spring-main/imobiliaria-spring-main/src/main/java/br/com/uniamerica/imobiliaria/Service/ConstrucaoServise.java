package br.com.uniamerica.imobiliaria.Service;
import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Repository.ConstrucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ConstrucaoServise {

    @Autowired
    private ConstrucaoRepository Repository;

    public List<Construcao> listartudo() {
        return Repository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public Construcao cadastrar(Construcao cadastrar) {
        Assert.notNull(cadastrar.getQuartos(), "Error, campo quartos vazio");
        Assert.notNull(cadastrar.getMetrosQuadrados(), "Error, campo metros quadrados vazio");
        Assert.notNull(cadastrar.getSuites(), "Error, campo suites vazio");
        Assert.notNull(cadastrar.getBanheiros(), "Error, campo banheiro vazio");
        return this.Repository.save(cadastrar);
    }
    @Transactional(rollbackFor = Exception.class)
    public void atualizar(Long id, Construcao atualizar) {
        final Construcao marcaBanco = this.Repository.findById(atualizar.getId()).orElse(null);
        Assert.isTrue(marcaBanco.getId().equals(id), "Error id da URL diferente do body");
        Assert.isTrue(marcaBanco == null || marcaBanco.getId().equals(atualizar.getId()), "nao identificado o registro informado");
        final LocalDateTime saida =  LocalDateTime.now();
        atualizar.setEdicao(saida);
        this.Repository.save(atualizar);
    }
}
