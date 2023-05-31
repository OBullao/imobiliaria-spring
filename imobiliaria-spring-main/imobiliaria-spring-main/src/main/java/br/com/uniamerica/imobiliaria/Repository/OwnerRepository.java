package br.com.uniamerica.imobiliaria.Repository;


import br.com.uniamerica.imobiliaria.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("UPDATE Owner owner SET owner.ativo = false WHERE owner.id = :id")
    public void desativar(@Param("id") Long id);

    @Query("SELECT Owner FROM Owner owner WHERE owner.ativo = true")
    public List<Owner> OwnerAtivos();
}