package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Entity.Owner;
import br.com.uniamerica.imobiliaria.Entity.Seller;
import br.com.uniamerica.imobiliaria.Repository.OwnerRepository;
import br.com.uniamerica.imobiliaria.Repository.SellerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SellerServise {



    @Autowired
    private SellerRepository sellerRepository;


    public List<Seller> listar(){

        return sellerRepository.findAll();
    }



    public Seller cadastrar(Seller seller) {
        if (seller.getNome().trim().isEmpty()) {
            throw new RuntimeException("Erro: SELLER NULA");

        } else {
            return this.sellerRepository.save(seller);
        }
    }

    @Transactional
    public void atualizar(Long id,Seller seller){
        if (id ==  seller.getId()){
            this.sellerRepository.save(seller);
        }else {
            throw new RuntimeException();
        }

    }



    @Transactional
    public void desativar(Long id){
        var seller = this.sellerRepository.findById(id);
        if (id == seller.get().getId()){
            this.sellerRepository.desativar(id);
        }
        else {
            throw new RuntimeException();
        }
    }
    public List<Seller> listaSellerAtivos(){
        return this.sellerRepository.SellerAtivos();}


}
