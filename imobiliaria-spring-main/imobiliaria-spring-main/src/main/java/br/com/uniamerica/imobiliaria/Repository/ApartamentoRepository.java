package br.com.uniamerica.imobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.imobiliaria.Entity.Apartamento;

import java.util.List;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
    List<Apartamento> findByAtivo(boolean ativo);
}

