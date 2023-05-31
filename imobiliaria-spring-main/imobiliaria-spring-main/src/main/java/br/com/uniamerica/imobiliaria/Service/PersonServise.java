package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Person;
import br.com.uniamerica.imobiliaria.Entity.Seller;
import br.com.uniamerica.imobiliaria.Repository.PersonRepository;
import br.com.uniamerica.imobiliaria.Repository.SellerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServise {


    @Autowired
    private PersonRepository personRepository;


    public List<Person> listar(){

        return personRepository.findAll();
    }



    public Person cadastrar(Person person) {
        if (person.getName().trim().isEmpty()) {
            throw new RuntimeException("Erro: PERSON NULA");

        } else {
            return this.personRepository.save(person);
        }
    }

    @Transactional
    public void atualizar(Long id,Person person){
        if (id ==  person.getId()){
            this.personRepository.save(person);
        }else {
            throw new RuntimeException();
        }

    }



    @Transactional
    public void desativar(Long id){
        var person = this.personRepository.findById(id);
        if (id == person.get().getId()){
            this.personRepository.desativar(id);
        }
        else {
            throw new RuntimeException();
        }
    }
    public List<Person> listaPersonAtivos(){
        return this.personRepository.PersonAtivos();}
}
