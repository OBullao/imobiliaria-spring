package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Entity.Localizacao;
import br.com.uniamerica.imobiliaria.Repository.ConstrucaoRepository;
import br.com.uniamerica.imobiliaria.Repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocalizacaoService {


    @Autowired
    private LocalizacaoRepository Repository;

    public List<Localizacao> listartudo() {
        return Repository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public Localizacao cadastrar(Localizacao cadastrar) {
        Assert.notNull(cadastrar.getCep(), "Error, campo cep vazio");
        Assert.notNull(cadastrar.getRua(), "Error, campo rua vazio");
        Assert.notNull(cadastrar.getBairro(), "Error, campo bairro vazio");
        Assert.notNull(cadastrar.getCidade(), "Error, campo cidade vazio");
        Assert.notNull(cadastrar.getNumero(), "Error, campo numero vazio");
        return this.Repository.save(cadastrar);
    }
    @Transactional(rollbackFor = Exception.class)
    public void atualizar(Long id, Localizacao atualizar) {
        final Localizacao marcaBanco = this.Repository.findById(atualizar.getId()).orElse(null);
        Assert.isTrue(marcaBanco.getId().equals(id), "Error id da URL diferente do body");
        Assert.isTrue(marcaBanco == null || marcaBanco.getId().equals(atualizar.getId()), "nao identificado o registro informado");
        final LocalDateTime saida =  LocalDateTime.now();
        atualizar.setEdicao(saida);
        this.Repository.save(atualizar);
    }
}
