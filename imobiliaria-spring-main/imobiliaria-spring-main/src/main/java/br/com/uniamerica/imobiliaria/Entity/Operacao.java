package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "operacao",schema = "public")
@Audited
@AuditTable(value = "operacao_audit", schema = "audit")
public class Operacao extends AbstractEntity {
    @Getter @Setter
    @Column(name = "contrato",nullable = false)
    private Contrato contrato;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "comprador_id",nullable = false)
    private Comprador comprador;
    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private Owner owner;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "vendedor_id",nullable = false)
    private Vendedor vendedor;
    @Getter @Setter
    @Column(name = "contrato_venda",nullable = false)
    private String contratoVenda;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "descricao_venda",nullable = false)
    private Descricao descricaoVenda;
    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "propriedade",nullable = false)
    private Propriedade propriedade;
    @Getter @Setter
    @Column(name = "valor",nullable = false)
    private Double valor;





}
