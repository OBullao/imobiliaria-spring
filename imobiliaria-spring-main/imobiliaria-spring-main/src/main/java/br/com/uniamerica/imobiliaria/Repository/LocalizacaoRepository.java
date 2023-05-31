package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Entity.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
    List<Localizacao> findByAtivo(boolean ativo);
}
