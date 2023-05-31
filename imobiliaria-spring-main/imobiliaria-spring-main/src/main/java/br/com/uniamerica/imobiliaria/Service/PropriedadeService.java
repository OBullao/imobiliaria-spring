package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Entity.Propriedade;
import br.com.uniamerica.imobiliaria.Repository.ConstrucaoRepository;
import br.com.uniamerica.imobiliaria.Repository.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropriedadeService {
    @Autowired
    private PropriedadeRepository Repository;

    public List<Propriedade> listartudo() {
        return Repository.findAll();
    }
    @Transactional(rollbackFor = Exception.class)
    public Propriedade cadastrar(Propriedade cadastrar) {
        return this.Repository.save(cadastrar);
    }
    @Transactional(rollbackFor = Exception.class)
    public void atualizar(Long id, Propriedade atualizar) {
        final Propriedade marcaBanco = this.Repository.findById(atualizar.getId()).orElse(null);
        Assert.isTrue(marcaBanco.getId().equals(id), "Error id da URL diferente do body");
        Assert.isTrue(marcaBanco == null || marcaBanco.getId().equals(atualizar.getId()), "nao identificado o registro informado");
        final LocalDateTime saida =  LocalDateTime.now();
        atualizar.setEdicao(saida);
        this.Repository.save(atualizar);
    }
}
