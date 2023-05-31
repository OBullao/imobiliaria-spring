package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "apartamento",schema = "public")
@Audited
@AuditTable(value = "apartamento_audit", schema = "audit")
public class Apartamento extends AbstractEntity {
    @Getter @Setter
    @Column(name="andar",nullable=false)
    private int andar;
    @Getter @Setter
    @Column(name = "nome",nullable=false,length=30)
    private String nome;
    @Getter @Setter
    @Column(name = "interphone",nullable=false)
    private int interphone;
    @Getter
    @Setter
    @Column(name = "estacionamento",nullable=false)
    private int estacionamento;
}
