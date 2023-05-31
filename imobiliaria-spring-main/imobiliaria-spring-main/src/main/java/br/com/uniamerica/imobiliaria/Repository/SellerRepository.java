package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Entity.Owner;
import br.com.uniamerica.imobiliaria.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    @Query("UPDATE Seller seller SET seller.ativo = false WHERE seller.id = :id")
    public void desativar(@Param("id") Long id);

    @Query("SELECT Seller FROM Seller seller WHERE seller.ativo = true")
    public List<Seller> SellerAtivos();
}