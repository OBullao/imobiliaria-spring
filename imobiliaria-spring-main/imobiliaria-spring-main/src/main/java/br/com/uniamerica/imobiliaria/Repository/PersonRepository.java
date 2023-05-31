package br.com.uniamerica.imobiliaria.Repository;

import br.com.uniamerica.imobiliaria.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.imobiliaria.Entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("UPDATE Person person SET person.ativo = false WHERE person.id = :id")
    public void desativar(@Param("id") Long id);

    @Query("SELECT Person FROM Person person WHERE person.ativo = true")
    public List<Person> PersonAtivos();
}
