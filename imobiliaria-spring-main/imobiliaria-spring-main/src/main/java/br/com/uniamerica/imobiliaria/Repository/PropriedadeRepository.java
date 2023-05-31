package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Construcao;
import br.com.uniamerica.imobiliaria.Entity.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade,Long> {
    List<Propriedade> findByAtivo(boolean ativo);
}
