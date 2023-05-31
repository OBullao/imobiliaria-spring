package br.com.uniamerica.imobiliaria.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
@Entity
@Table(name = "descricao",schema = "public")
@Audited
@AuditTable(value = "descricao_audit", schema = "audit")
public class Descricao extends AbstractEntity {
    @Getter @Setter
    @Column(name="descricao",nullable = false)
    private String descricao;
    @Getter @Setter
    @Column(name="fotos",nullable = false)
    private String fotos;
}
