package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
@Entity
@Table(name = "localizacao",schema = "public")
@Audited
@AuditTable(value = "localizacao_audit", schema = "audit")
public class Localizacao extends AbstractEntity {
    @Getter @Setter
    @Column(name="cep",nullable=false,length = 100)
    private String cep;
    @Getter @Setter
    @Column(name="numero",nullable=false)
    private int numero;
    @Getter @Setter
    @Column(name="rua",nullable=false,length = 100)
    private String rua;
    @Getter @Setter
    @Column(name="cidade",nullable=false,length = 100)
    private String cidade;
    @Getter @Setter
    @Column(name="bairro",nullable=false,length = 100)
    private String bairro;
}
