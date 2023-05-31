package br.com.uniamerica.imobiliaria.Service;
import br.com.uniamerica.imobiliaria.Entity.Admin;
import br.com.uniamerica.imobiliaria.Repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//import br.com.uniamerica.imobiliaria.repository.AdminRepository;
@Service
public class AdminServise {

    public List<Admin> listar(){

        return adminRepository.findAll();
    }


    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public Admin cadastrar(Admin admin) {
        if (admin.getName().trim().isEmpty()) {
            throw new RuntimeException("Erro: ADMIN NULA");

        } else {
            return this.adminRepository.save(admin);
        }
    }

    @Transactional
    public void atualizar(Long id,Admin admin){
        if (id ==  admin.getId()){
            this.adminRepository.save(admin);
        }else {
            throw new RuntimeException();
    }

    }


    @Transactional
    public void desativar(Long id){
        var admin = this.adminRepository.findById(id);
        if (id == admin.get().getId()){
            this.adminRepository.desativar(id);
        }
        else {
                throw new RuntimeException();
        }
    }

    public List<Admin> listaAdminAtivos(){
        return this.adminRepository.AdminAtivos();
    }

}

















