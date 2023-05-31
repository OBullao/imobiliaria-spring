package br.com.uniamerica.imobiliaria.Service;

import br.com.uniamerica.imobiliaria.Entity.Comprador;
import br.com.uniamerica.imobiliaria.Repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompradorService {
    @Autowired
    private CompradorRepository compradorRepository;

///////////////////////////////////GET ID COMPRADORES///////////////////////////////////
    public Optional<Comprador> procurarComprador(Long id){
        if (!compradorRepository.ProcuraId(id) ){
            throw new RuntimeException("Esse ID nao esta no banco de dados, verifique e tente novamente");
        }else {
            Optional<Comprador> comprador = this.compradorRepository.findById(id);
            return comprador;
        }
    }
///////////////////////////////////GET LISTA COMPRADORES///////////////////////////////////
    public List<Comprador> listaComprador(){
        List<Comprador> comprador = compradorRepository.findAll();
        return comprador;
    }
///////////////////////////////////GET ATIVOS COMPRADORES///////////////////////////////////
    public List<Comprador> ativosComprador(){
    List<Comprador> comprador = compradorRepository.findByAtivo(true);
    return comprador;
    }











}
