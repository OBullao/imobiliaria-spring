package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("UPDATE Admin admin SET admin.ativo = false WHERE admin.id = :id")
    public void desativar(@Param("id") Long id);

    @Query("SELECT Admin FROM Admin admin WHERE admin.ativo = true")
    public List<Admin> AdminAtivos();

}
