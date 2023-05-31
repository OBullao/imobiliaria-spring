package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Entity.Buyer;
import br.com.uniamerica.imobiliaria.Entity.Owner;
import br.com.uniamerica.imobiliaria.Entity.Seller;
import br.com.uniamerica.imobiliaria.Repository.BuyerRepository;
import br.com.uniamerica.imobiliaria.Repository.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OwnerServise {


    @Autowired
    private OwnerRepository ownerRepository;


    public List<Owner> listar(){

        return ownerRepository.findAll();
    }

    public Owner cadastrar(Owner owner) {
        if (owner.getName().trim().isEmpty()) {
            throw new RuntimeException("Erro: OWNER NULA");

        } else {
            return this.ownerRepository.save(owner);
        }
    }

    @Transactional
    public void atualizar(Long id,Owner owner){
        if (id ==  owner.getId()){
            this.ownerRepository.save(owner);
        }else {
            throw new RuntimeException();
        }

    }



    @Transactional
    public void desativar(Long id){
        var owner = this.ownerRepository.findById(id);
        if (id == owner.get().getId()){
            this.ownerRepository.desativar(id);
        }
        else {
            throw new RuntimeException();
        }
    }
    public List<Owner> listaOwnerAtivos(){
        return this.ownerRepository.OwnerAtivos();}
}
