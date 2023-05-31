package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "construcao",schema = "public")
@Audited
@AuditTable(value = "construcao_audit", schema = "audit")
public class Construcao extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "tipo", length = 20, nullable = false)
    private Tipo tipo;
    @Getter @Setter
    @Column(name="quartos",nullable=false)
    private int quartos;
    @Getter @Setter
    @Column(name="metros_quadrados",nullable=false)
    private double metrosQuadrados;
    @Getter @Setter
    @Column(name="suites",nullable=false)
    private int suites;
    @Getter @Setter
    @Column(name="banheiros",nullable=false)
    private int banheiros;
    @Getter @Setter
    @OneToOne
    @JoinColumn(name="apartamento",nullable=false)
    private Apartamento apartamento;

}