package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.imobiliaria.Entity.Construcao;

import java.util.List;

@Repository
public interface ConstrucaoRepository extends JpaRepository<Construcao, Long> {
    List<Construcao> findByAtivo(boolean ativo);
}