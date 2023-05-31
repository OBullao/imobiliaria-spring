package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Apartamento;
import br.com.uniamerica.imobiliaria.Repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ApartamentoService {
    @Autowired
    private ApartamentoRepository Repository;

    public List<Apartamento> listartudo() {
        return Repository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Apartamento cadastrar(Apartamento cadastrar) {
        Assert.notNull(cadastrar.getAndar(), "Error, campo andar vazio");
        Assert.notNull(cadastrar.getNome(), "Error, campo nome vazio");
        Assert.notNull(cadastrar.getInterphone(), "Error, campo interphone vazio");
        Assert.notNull(cadastrar.getEstacionamento(), "Error, campo estacionamento vazio");
        return this.Repository.save(cadastrar);
    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizar(Long id, Apartamento atualizar) {
        final Apartamento marcaBanco = this.Repository.findById(atualizar.getId()).orElse(null);
        Assert.isTrue(marcaBanco.getId().equals(id), "Error id da URL diferente do body");
        Assert.isTrue(marcaBanco == null || marcaBanco.getId().equals(atualizar.getId()), "nao identificado o registro informado");
        final LocalDateTime saida =  LocalDateTime.now();
        atualizar.setEdicao(saida);
        this.Repository.save(atualizar);
    }
}
