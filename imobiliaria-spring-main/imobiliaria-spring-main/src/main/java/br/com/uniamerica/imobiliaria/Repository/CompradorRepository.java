package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {
    List<Comprador> findByAtivo(boolean ativo);

    @Query(value = "select exists (select * from comprador where id = :id)", nativeQuery = true)
    boolean ProcuraId(@Param("id") final Long id);
}
