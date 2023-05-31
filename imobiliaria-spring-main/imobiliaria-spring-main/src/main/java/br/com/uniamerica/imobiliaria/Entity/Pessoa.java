package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
public abstract class Pessoa extends AbstractEntity {
    @Getter
    @Setter
    @Column(name="email",nullable=false,length=100,unique = true)
    private String email;
    @Getter
    @Setter
    @Column(name="name",nullable=false,length=100)
    private String nome;
    @Getter
    @Setter
    @Column(name="cpfCnpj",nullable=false,length=20,unique = true)
    private String cpfCnpj;
    @Getter
    @Setter
    @Column(name="phone",nullable=false,length=10,unique = true)
    private String phone;
}
